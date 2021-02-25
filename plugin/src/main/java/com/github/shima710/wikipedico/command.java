package com.github.shima710.wikipedico;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static com.github.shima710.wikipedico.Wikipedico.*;

public class command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){

        if(cmd.getName().equalsIgnoreCase("update")){
            try {
                update();
                Bukkit.getLogger().info("[Wikipedico] Updated Successfully!");
                Bukkit.getLogger().info("[Wikipedico] Server will be reloaded.");
                Bukkit.reload();
                sender.sendMessage(ChatColor.GREEN + ">Wikipedico [INFO] " + ChatColor.WHITE + "Updated! Current version is v" + version);
            } catch (Exception e) {
                e.printStackTrace();
                sender.sendMessage(ChatColor.RED + ">Wikipedico [ERROR] " + ChatColor.WHITE + "Some error occurred.");
            }
            return true;
        }
        else if(cmd.getName().equalsIgnoreCase("install")){
            try {
                delFile("./plugins/Wikipedico/config.yml");
                loadVaris();
                update();
                Bukkit.getLogger().info("[Wikipedico] Installed Successfully!");
                Bukkit.getLogger().info("[Wikipedico] Server will be reloaded.");
                Bukkit.reload();
                sender.sendMessage(ChatColor.GREEN + ">Wikipedico [INFO] " + ChatColor.WHITE + "Installed! Current version is v" + version);
            } catch (Exception e) {
                e.printStackTrace();
                sender.sendMessage(ChatColor.RED + ">Wikipedico [ERROR] " + ChatColor.WHITE + "Some error occurred.");
            }
            return true;
        }
        else if(cmd.getName().equalsIgnoreCase("loadvaris")){
            try {
                loadVaris();
                Bukkit.getLogger().info("[Wikipedico] Reloading variables.csv wes Succeed!");
                Bukkit.getLogger().info("[Wikipedico] Server will be reloaded.");
                Bukkit.reload();
                sender.sendMessage(ChatColor.GREEN + ">Wikipedico [INFO] " + ChatColor.WHITE + "variables.csv was Reloaded! Current version is v" + version);
            } catch (Exception e) {
                e.printStackTrace();
                sender.sendMessage(ChatColor.RED + ">Wikipedico [ERROR] " + ChatColor.WHITE + "Some error occurred.");
            }
            return true;
        }
        else if(cmd.getName().equalsIgnoreCase("backup")){
            try {
                backupVaris();
                sender.sendMessage(ChatColor.GREEN + ">Wikipedico [INFO] " + ChatColor.WHITE + "Success! variables.csv is backed up.");
            } catch (Exception e) {
                e.printStackTrace();
                sender.sendMessage(ChatColor.RED + ">Wikipedico [ERROR] " + ChatColor.WHITE + "Some error occurred.");
            }
            return true;
        }
        return false;
    }
}
