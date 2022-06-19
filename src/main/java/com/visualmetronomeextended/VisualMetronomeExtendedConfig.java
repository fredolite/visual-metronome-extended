package com.visualmetronomeextended;

import net.runelite.client.config.*;

import java.awt.*;

@ConfigGroup("visualmetronomeextended")
public interface VisualMetronomeExtendedConfig extends Config {
    @ConfigSection(
            position = 1,
            name = "Color Settings",
            description = "Change the colors to cycle through"
    )
    String ColorSettings = "Color Settings";
    @ConfigSection(
            position = 2,
            name = "Cycle Settings",
            description = "Change any extended settings for visual metronome e.g. cycles, cycle change hotkey."
    )
    String ExtendedSettings = "Additional settings";

    @Range(
            min = 16
    )
    @ConfigItem(
            keyName = "boxWidth",
            name = "Default Box Size (Alt + Right Click Box)",
            description = "Configure the default length and width of the box. Use alt + right click on the box to reset to the size specified"
    )
    default int boxWidth() {
        return 25;
    }

    @ConfigItem(
            keyName = "showTick",
            name = "Show Tick Number",
            description = "Shows current tick number on the overlay"
    )
    default boolean showTick() {
        return false;
    }

    @ConfigItem(
            keyName = "countColor",
            name = "Tick Number Color",
            description = "Configures the color of tick number, if enabled"
    )
    default Color NumberColor() {
        return Color.WHITE;
    }


    @Alpha
    @ConfigItem(
            keyName = "tick1Color",
            name = "1st Tick Color",
            description = "Configures the color of 1st tick if enabled",
            section = ColorSettings,
            position=1

    )
    default Color getTick1Color() {
        return Color.DARK_GRAY;
    }

    @Alpha
    @ConfigItem(
            keyName = "tick2Color",
            name = "2nd Tock Color",
            description = "Configures the color of 2nd tick if enabled",
            section = ColorSettings,
            position=2

    )
    default Color getTick2Color() {
        return Color.DARK_GRAY;
    }

    @Alpha
    @ConfigItem(
            keyName = "tick3Color",
            name = "3rd Tick Color",
            description = "Configures the color of 3rd tick if enabled",
            section = ColorSettings,
            position=3
    )
    default Color getTick3Color() {
        return Color.DARK_GRAY;
    }

    @Alpha
    @ConfigItem(
            keyName = "tick4Color",
            name = "4th Tick Color",
            description = "Configures the color of the 4th tick if enabled",
            section = ColorSettings,
            position=4
    )
    default Color getTick4Color() {
        return Color.DARK_GRAY;
    }

    @Alpha
    @ConfigItem(
            keyName = "tick5Color",
            name = "5th Tick Color",
            description = "Configures the color of the 5th tick if enabled",
            section = ColorSettings,
            position=5
    )
    default Color getTick5Color() {
        return Color.DARK_GRAY;
    }

    @Alpha
    @ConfigItem(
            keyName = "tick6Color",
            name = "6th Tick Color",
            description = "Configures the color of the 6th tick if enabled",
            section = ColorSettings,
            position=6
    )
    default Color getTick6Color() {
        return Color.DARK_GRAY;
    }

    @Alpha
    @ConfigItem(
            keyName = "tick7Color",
            name = "7th Tick Color",
            description = "Configures the color of the 7th tick if enabled",
            section = ColorSettings,
            position=7
    )
    default Color getTick7Color() {
        return Color.DARK_GRAY;
    }

    @Alpha
    @ConfigItem(
            keyName = "tick8Color",
            name = "8th Tick Color",
            description = "Configures the color of the 8th tick if enabled",
            section = ColorSettings,
            position=8
    )
    default Color getTick8Color() {
        return Color.DARK_GRAY;
    }

    @Alpha
    @ConfigItem(
            keyName = "tick9Color",
            name = "9th Tick Color",
            description = "Configures the color of the 9th tick if enabled",
            section = ColorSettings,
            position=9
    )
    default Color getTick9Color() {
        return Color.DARK_GRAY;
    }

    @Alpha
    @ConfigItem(
            keyName = "tick10Color",
            name = "10th Tick Color",
            description = "Configures the color of the 10th tick if enabled",
            section = ColorSettings,
            position=10
    )
    default Color getTick10Color() {
        return Color.DARK_GRAY;
    }

    @ConfigItem(
            keyName = "tickCycleChangeHotkey",
            name = "Tick cycle change hotkey",
            description = "Hotkey to change the tick cycle being used.",
            section = ExtendedSettings
    )
    default Keybind tickCycleChangeHotkey() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(
            keyName = "tickCycleResetHotkey",
            name = "Tick cycle reset hotkey",
            description = "Hotkey to reset the tick cycle being used.",
            section = ExtendedSettings
    )
    default Keybind tickCycleResetHotkey() {
        return Keybind.NOT_SET;
    }

    @Range(
            min = 2,
            max = 40
    )
    @ConfigItem(
            keyName = "getTickCycle1",
            name = "Tick cycle 1",
            description = "Number of ticks to count",
            section = ExtendedSettings
    )
    default int getTickCycle1() {
        return 2;
    }

    @Range(
            min = 2,
            max = 40
    )
    @ConfigItem(
            keyName = "getTickCycle2",
            name = "Tick cycle 2",
            description = "Number of ticks to count",
            section = ExtendedSettings
    )
    default int getTickCycle2() {
        return 3;
    }

    @Range(
            min = 2,
            max = 40
    )
    @ConfigItem(
            keyName = "getTickCycle3",
            name = "Tick cycle 3",
            description = "Number of ticks to count",
            section = ExtendedSettings
    )
    default int getTickCycle3() {
        return 4;
    }

    @Range(
            min = 2,
            max = 40
    )
    @ConfigItem(
            keyName = "getTickCycle4",
            name = "Tick cycle 4",
            description = "Number of ticks to count",
            section = ExtendedSettings
    )
    default int getTickCycle4() {
        return 5;
    }

    @Range(
            min = 2,
            max = 40
    )
    @ConfigItem(
            keyName = "getTickCycle5",
            name = "Tick cycle 5",
            description = "Number of ticks to count",
            section = ExtendedSettings
    )
    default int getTickCycle5() {
        return 6;
    }
}

