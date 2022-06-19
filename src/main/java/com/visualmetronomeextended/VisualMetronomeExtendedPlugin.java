package com.visualmetronomeextended;

import com.google.inject.Provides;
import net.runelite.api.ChatMessageType;
import net.runelite.api.events.GameTick;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;
import java.awt.*;

@PluginDescriptor(
        name = "Visual Metronome Extended",
        description = "Shows a visual cue on an overlay every game tick to help timing based activities",
        tags = {"timers", "overlays", "tick", "skilling"}
)
public class VisualMetronomeExtendedPlugin extends Plugin {
    public int tickCounter = 0;
    public int[] tickCycles = new int[]{2, 3, 4, 5, 6};
    public Color[] tickColors = new Color[]{
            Color.DARK_GRAY,
            Color.DARK_GRAY,
            Color.DARK_GRAY,
            Color.DARK_GRAY,
            Color.DARK_GRAY,
            Color.DARK_GRAY,
            Color.DARK_GRAY,
            Color.DARK_GRAY,
            Color.DARK_GRAY,
            Color.DARK_GRAY
    };
    public int tickCycleIndex = 0;
    public Color CurrentColor = Color.WHITE;
    public Dimension DEFAULT_SIZE = new Dimension(25, 25);
    @Inject
    private OverlayManager overlayManager;
    @Inject
    private ConfigManager configManager;
    @Inject
    private FullResizableVisualMetronomeOverlay overlay;
    @Inject
    private VisualMetronomeExtendedConfig config;
    @Inject
    private VisualMetronomeExtendedInputListener inputListener;
    @Inject
    private KeyManager keyManager;
    @Inject
    private ChatMessageManager chatMessageManager;

    @Provides
    VisualMetronomeExtendedConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(VisualMetronomeExtendedConfig.class);
    }

    @Subscribe
    public void onGameTick(GameTick tick) {
        int tickCount = tickCycles[tickCycleIndex];
        CurrentColor = tickColors[(++tickCounter) % 11];
        if (tickCounter >= tickCount) {
            tickCounter = 0;
        }
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged event) {
        int tickCount = tickCycles[tickCycleIndex];

        if (tickCounter >= tickCount) {
            tickCounter = 0;
        }
        DEFAULT_SIZE = new Dimension(config.boxWidth(), config.boxWidth());

        readConfigValues();
    }

    @Override
    protected void startUp() throws Exception {
        readConfigValues();
        overlayManager.add(overlay);
        overlay.setPreferredSize(DEFAULT_SIZE);
        keyManager.registerKeyListener(inputListener);
    }

    private void readConfigValues() {
        tickCycles = new int[]{
                config.getTickCycle1(),
                config.getTickCycle2(),
                config.getTickCycle3(),
                config.getTickCycle4(),
                config.getTickCycle5()
        };
        tickColors = new Color[]{
                config.getTick1Color(),
                config.getTick2Color(),
                config.getTick3Color(),
                config.getTick4Color(),
                config.getTick5Color(),
                config.getTick6Color(),
                config.getTick7Color(),
                config.getTick8Color(),
                config.getTick9Color(),
                config.getTick10Color(),
        };
    }

    @Override
    protected void shutDown() throws Exception {
        overlayManager.remove(overlay);
        tickCounter = 0;
        keyManager.unregisterKeyListener(inputListener);
    }

    private void sendChatMessage(String chatMessage) {
        final String message = new ChatMessageBuilder().append(ChatColorType.HIGHLIGHT).append(chatMessage).build();
        chatMessageManager.queue(QueuedMessage.builder().type(ChatMessageType.CONSOLE).runeLiteFormattedMessage(message).build());
    }

    public void onCycleHotkeyPressed() {
        tickCycleIndex = (tickCycleIndex + 1) % tickCycles.length;
        tickCounter = 0;
        sendChatMessage(String.format("Metronome reset to a %d cycle.", tickCycles[tickCycleIndex]));
    }

    public void resetHotkeyPressed() {
        tickCounter = 0;
    }
}
