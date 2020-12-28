package com.shmn7iii.wikipedico;

import org.bukkit.ChatColor;

public class Prefix {

    public enum MessPref{GAME,ERROR,ADMIN,INFO,SPEC}

    public static String prefGame = "" + ChatColor.GREEN + ChatColor.BOLD + ">GAME " + ChatColor.WHITE;
    public static String prefERROR = "" + ChatColor.RED + ChatColor.BOLD + ">ERROR " + ChatColor.WHITE;
    public static String prefAdmin = "" + ChatColor.DARK_RED + ChatColor.BOLD + ">ADMIN " + ChatColor.WHITE;
    public static String prefInfo = "" + ChatColor.AQUA + ChatColor.BOLD + ">INFO " + ChatColor.WHITE;
    public static String prefSpec = "" + ChatColor.AQUA + ChatColor.BOLD + ">観戦 " + ChatColor.WHITE;

    public static String getMessagePrefix(MessPref mp){
        switch (mp){
            case GAME:
                return prefGame;
            case ERROR:
                return prefERROR;
            case ADMIN:
                return prefAdmin;
            case INFO:
                return prefInfo;
            case SPEC:
                return prefSpec;
        }
        return null;
    }
}
