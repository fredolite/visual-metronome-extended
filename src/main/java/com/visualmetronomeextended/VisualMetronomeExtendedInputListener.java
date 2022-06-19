package com.visualmetronomeextended;

import net.runelite.client.input.KeyListener;

import javax.inject.Inject;
import java.awt.event.KeyEvent;

public class VisualMetronomeExtendedInputListener implements KeyListener {

    @Inject
    private VisualMetronomeExtendedPlugin plugin;

    @Inject
    private VisualMetronomeExtendedConfig config;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (config.tickCycleChangeHotkey().matches(e)) {
            plugin.onCycleHotkeyPressed();
        }
        if (config.tickCycleResetHotkey().matches(e)) {
            plugin.resetHotkeyPressed();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}