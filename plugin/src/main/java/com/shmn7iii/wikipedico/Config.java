package com.shmn7iii.wikipedico;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;

public class Config {

    public static int WorldBorderSize = 400;
    public static int WorldBorderTime = 500;
    public static int WorldBorderDamageAmount = 5;
    public static int WorldBorderDamageBuffer = 5;

    public static void load(){
        FileConfiguration config = Main.plugin.getConfig();

        if (config.contains("WorldBorder.Size")) {
            WorldBorderSize = config.getInt("WorldBorder.Size");
        }
        if (config.contains("WorldBorder.Time")) {
            WorldBorderTime = config.getInt("WorldBorder.Time");
        }
        if (config.contains("WorldBorder.DamageAmount")) {
            WorldBorderDamageAmount = config.getInt("WorldBorder.DamageAmount");
        }
        if (config.contains("WorldBorder.DamageBuffer")) {
            WorldBorderDamageBuffer = config.getInt("WorldBorder.DamageBuffer");
        }

    }
}
