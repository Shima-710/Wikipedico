package com.shmn7iii.wikipedico;

import com.shmn7iii.wikipedico.Main.*;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands  implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("start")) {
            if(sender instanceof Player){
                Player player = (Player) sender;
                Main.WORLD = player.getWorld();
                SystemMain.trigStart(sender,Main.GAMESTATUS);
                return true;
            }
            else{
                Bukkit.getLogger().info(Prefix.getMessagePrefix(Prefix.MessPref.ERROR)+"Do this command from client!");
                return false;
            }
        }


        return false;
    }
}
