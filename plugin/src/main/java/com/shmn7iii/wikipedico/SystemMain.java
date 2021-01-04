package com.shmn7iii.wikipedico;


import com.shmn7iii.wikipedico.Enum.GameStatus;
import com.shmn7iii.wikipedico.Enum.PlayerStatus;
import com.shmn7iii.wikipedico.Enum.TimerKind;
import com.shmn7iii.wikipedico.Prefix.*;
import com.shmn7iii.wikipedico.SubSystem.SystemTeam;
import com.shmn7iii.wikipedico.SubSystem.TeamColor;
import org.bukkit.*;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;

import static com.shmn7iii.wikipedico.Prefix.getMessagePrefix;

public class SystemMain {
    public static Main plugin;

    public static void trigStart(CommandSender sender, GameStatus gs){
        if (gs == GameStatus.NONE) { preStart(); }
        else { sender.sendMessage(getMessagePrefix(MessPref.ERROR) + "現在実行不可です"); }
    }

    public static void preStart(){
        registPlayer();
        createBossBar();
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
        new Timer(plugin, TimerKind.SETWB,15,false).runTaskTimer(plugin, 10,20);
        new Timer(plugin, TimerKind.BOSSBAR,Config.WorldBorderTime,false).runTaskTimer(plugin, 10,20);
    }

    public static void registPlayer(){
        for(Player p:Bukkit.getOnlinePlayers()){
            if(p.getGameMode().equals(GameMode.SURVIVAL) || p.getGameMode().equals(GameMode.SPECTATOR)){
                // 参加
                p.setGameMode(GameMode.ADVENTURE);
                PlayerMap.setPlayerMap(p, PlayerStatus.PLAY,0,0, TeamColor.PLAY,null);
                SystemTeam.playerAddTeam(p,TeamColor.PLAY);
            }
            else{
                // 観戦
                p.setGameMode(GameMode.SPECTATOR);
                PlayerMap.setPlayerMap(p,PlayerStatus.SPEC,0,0,TeamColor.SPEC,null);
                SystemTeam.playerAddTeam(p,TeamColor.SPEC);
            }
        }
    }

    public static void setWorldBorder(){
        WorldBorder wb = Main.WORLD.getWorldBorder();
        wb.setSize(Config.WorldBorderSize,Config.WorldBorderTime);
        wb.setDamageAmount(Config.WorldBorderDamageAmount);
        wb.setDamageBuffer(Config.WorldBorderDamageBuffer);
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

    public static void createBossBar(){
        Main.BOSSBAR = Bukkit.createBossBar("-= Wikipedico =-", BarColor.BLUE, BarStyle.SEGMENTED_10);
        Main.BOSSBAR.setProgress(1);
        for(Player p:Bukkit.getOnlinePlayers()){
            Main.BOSSBAR.addPlayer(p);
        }
    }

    public static void setBossBar(double progress){
        Main.BOSSBAR.setProgress(progress);
    }



    public static void setRank(Player player){
        int tmp_rank = 0;
        for(Player p:Bukkit.getOnlinePlayers()){
            if(Objects.equals(PlayerMap.getPlayerMapKey(p, PlayerMap.PlayerMapKay.PS), PlayerStatus.PLAY)){
                tmp_rank++;
            }
        }
        tmp_rank++;
        PlayerMap.setPlayerMapKey(player, PlayerMap.PlayerMapKay.RANK,tmp_rank);
    }

    public static void deathPlayer(Player victim, Player killer){
        int nd = (int) PlayerMap.getPlayerMapKey(victim, PlayerMap.PlayerMapKay.DEATHS);
        nd++;
        PlayerMap.setPlayerMapKey(victim, PlayerMap.PlayerMapKay.DEATHS,nd);


        SystemTeam.playerAddTeam(killer,TeamColor.SPEC);
        PlayerMap.setPlayerMapKey(killer, PlayerMap.PlayerMapKay.PS, PlayerStatus.SPEC);
        killer.setGameMode(GameMode.SPECTATOR);
        setRank(victim);

        int nk = (int) PlayerMap.getPlayerMapKey(killer, PlayerMap.PlayerMapKay.KILLS);
        nk++;
        PlayerMap.setPlayerMapKey(killer, PlayerMap.PlayerMapKay.KILLS,nk);


        checkGameEnd();
    }

    public static void deathMessage(Player victim, Player killer, EntityDamageEvent.DamageCause cause){
        if(killer != null){
            Bukkit.broadcastMessage(ChatColor.AQUA+killer.getName()+ChatColor.WHITE+"✈►"+ChatColor.RED+victim.getName());
        }
        else{
            switch (cause){
                case FALL:
                    Bukkit.broadcastMessage(ChatColor.RED+victim.getName()+"は落下して死亡した");
                    break;
                case LAVA:
                    Bukkit.broadcastMessage(ChatColor.RED+victim.getName()+"は溶岩に入って死亡した");
                    break;
                case DROWNING:
                    Bukkit.broadcastMessage(ChatColor.RED+victim.getName()+"は溺れて死亡した");
                    break;
                case SUFFOCATION:
                    Bukkit.broadcastMessage(ChatColor.RED+victim.getName()+"は安地へ逃げられず死亡した");
                    break;
                case BLOCK_EXPLOSION:
                    Bukkit.broadcastMessage(ChatColor.RED+victim.getName()+"は爆発に巻きこまあれて死亡した");
                    break;
                default:
                    Bukkit.broadcastMessage(ChatColor.RED+victim.getName()+"は死亡した");
                    break;
            }

        }

    }

    public static int calSurvivor(){
        int dum=0;
        for(Player p:Bukkit.getOnlinePlayers()){
            if(PlayerMap.playerMap.containsValue(p)) {//参加者なら
                if (Objects.equals(PlayerMap.getPlayerMapKey(p, PlayerMap.PlayerMapKay.PS), PlayerStatus.PLAY)) {//生存者なら
                    dum++;
                }
            }
        }
        return dum;
    }

    public static void checkGameEnd(){
        if(calSurvivor() <= 1){
            gameEnd();
        }
    }


    public static void gameEnd(){

    }


    public static void resetGame(){

    }
}
