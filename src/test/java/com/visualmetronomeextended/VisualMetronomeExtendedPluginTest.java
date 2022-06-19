package com.visualmetronomeextended;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class VisualMetronomeExtendedPluginTest {
    public static void main(String[] args) throws Exception {
        ExternalPluginManager.loadBuiltin(VisualMetronomeExtendedPlugin.class);
        RuneLite.main(args);
    }
}
