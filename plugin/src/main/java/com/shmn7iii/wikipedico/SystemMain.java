package com.shmn7iii.wikipedico;


import com.shmn7iii.wikipedico.Enum.GameStatus;
import com.shmn7iii.wikipedico.Enum.PlayerStatus;
import com.shmn7iii.wikipedico.Enum.TimerKind;
import com.shmn7iii.wikipedico.Prefix.*;
import com.shmn7iii.wikipedico.SubSystem.SystemTeam;
import com.shmn7iii.wikipedico.SubSystem.TeamColor;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.shmn7iii.wikipedico.Prefix.getMessagePrefix;

public class SystemMain {
    public static Main plugin;

    public static void trigStart(CommandSender sender, GameStatus gs){
        if (gs == GameStatus.NONE) { preStart(); }
        else { sender.sendMessage(getMessagePrefix(MessPref.ERROR) + "現在実行不可です"); }
    }

    public static void preStart(){
        registPlayer();
        new Timer(plugin, TimerKind.PREPARE,10,true).runTaskTimer(plugin, 10,20);//TODO config ni prepare time
    }

    public static void gameStart(){
        for(Player p:Bukkit.getOnlinePlayers()){
            if(PlayerMap.playerMap.get(p).get(0).equals(PlayerStatus.PLAY)){//プレイヤーなら
                p.teleport(Main.LOBBY);//TODO ロビー座標をconfigに保存しよう
                p.setGameMode(GameMode.SURVIVAL);
                p.getInventory().setChestplate(new ItemStack(Material.ELYTRA));
                p.teleport(p.getLocation().add(0,0,-2.0));
                p.setFlying(true);//TODO ugokukana
            }
        }

    }

    public static void registPlayer(){
        for(Player p:Bukkit.getOnlinePlayers()){
            if(p.getGameMode().equals(GameMode.SURVIVAL) || p.getGameMode().equals(GameMode.SPECTATOR)){
                // 参加
                p.setGameMode(GameMode.ADVENTURE);
                PlayerMap.setPlayerMap(p, PlayerStatus.PLAY,0,0, TeamColor.PLAY);
                SystemTeam.playerAddTeam(p,TeamColor.PLAY);
            }
            else{
                // 観戦
                p.setGameMode(GameMode.SPECTATOR);
                PlayerMap.setPlayerMap(p,PlayerStatus.SPEC,0,0,TeamColor.SPEC);
                SystemTeam.playerAddTeam(p,TeamColor.SPEC);
            }
        }
    }

    public static void setWorldBorder(){
        WorldBorder wb = Main.WORLD.getWorldBorder();
        wb.setSize(400);//TODO config
        wb.setDamageAmount(5);//TODO config
        ArrayList<Player> players = new ArrayList<>();
        for(Player p:Bukkit.getOnlinePlayers()){
            if(PlayerMap.playerMap.get(p).get(0).equals(PlayerStatus.PLAY)){
                players.add(p);
            }
        }
        int random = new Random().nextInt(players.size());
        Player picked = players.get(random);
        wb.setCenter(picked.getLocation());
    }


    public static void deathPlayer(Player victim, Player killer){
        int nd = (int) PlayerMap.getPlayerMapKey(victim, PlayerMap.PlayerMapKay.DEATHS);
        nd++;
        PlayerMap.setPlayerMapKey(victim, PlayerMap.PlayerMapKay.DEATHS,nd);


        SystemTeam.playerAddTeam(killer,TeamColor.SPEC);
        PlayerMap.setPlayerMapKey(killer, PlayerMap.PlayerMapKay.PS, PlayerStatus.SPEC);
        killer.setGameMode(GameMode.SPECTATOR);

        int nk = (int) PlayerMap.getPlayerMapKey(killer, PlayerMap.PlayerMapKay.KILLS);
        nk++;
        PlayerMap.setPlayerMapKey(killer, PlayerMap.PlayerMapKay.KILLS,nk);
    }

    public static void deathMessage(){

    }
}
