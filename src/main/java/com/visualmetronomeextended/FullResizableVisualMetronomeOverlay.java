package com.visualmetronomeextended;

import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.*;

// Grabbed from the existing visual-metronome repo
public class FullResizableVisualMetronomeOverlay extends Overlay {

    private static final int MINIMUM_SIZE = 16; // too small and resizing becomes impossible, requiring a reset
    private final VisualMetronomeExtendedConfig config;
    private final VisualMetronomeExtendedPlugin plugin;

    @Inject
    public FullResizableVisualMetronomeOverlay(VisualMetronomeExtendedConfig config, VisualMetronomeExtendedPlugin plugin) {
        super(plugin);
        this.config = config;
        this.plugin = plugin;
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
        setMinimumSize(MINIMUM_SIZE);
        setResizable(true);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        Dimension preferredSize = getPreferredSize();

        if (preferredSize == null) {
            // if this happens, reset to default - should be rare, but eg. alt+rightclick will cause this
            preferredSize = plugin.DEFAULT_SIZE;
            setPreferredSize(preferredSize);
        }

        graphics.setColor(plugin.CurrentColor);
        graphics.fillRect(0, 0, preferredSize.width, preferredSize.height);
        int TITLE_PADDING = (Math.min(preferredSize.width, preferredSize.height) / 2 - 4); // scales tick number position with box size

        if (config.showTick()) {
            graphics.setColor(config.NumberColor());
            graphics.drawString(String.valueOf(plugin.tickCounter), TITLE_PADDING, preferredSize.height - TITLE_PADDING);
        }

        return preferredSize;
    }
}
