package com.shmn7iii.wikipedico;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {
    public static Main plugin;
    public static String version = Main.class.getPackage().getImplementationVersion();

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new Event(this), this);
        setCommandExecutor();
        saveDefaultConfig();
        Bukkit.getLogger().info("Hello!");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("GoodBye!");
    }



    public void setCommandExecutor(){
        Commands command = new Commands();
        Objects.requireNonNull(getCommand("start")).setExecutor(command);
    }
}
