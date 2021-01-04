package com.shmn7iii.wikipedico;

import com.shmn7iii.wikipedico.SubSystem.TeamColor;
import com.sun.istack.internal.Nullable;
import org.bukkit.entity.Player;

import com.shmn7iii.wikipedico.Enum.PlayerStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerMap {
    public static Map<Player, List<Object>> playerMap = new HashMap<>();

    public enum PlayerMapKay{
        PS,
        KILLS,
        DEATHS,
        TEAM,
        RANK
    }

    public static void setPlayerMap(Player player, PlayerStatus playerStatus, int kills, int deaths, TeamColor teamColor,@Nullable Integer rank){
        playerMap.put(player,new ArrayList<>());
        playerMap.get(player).add(0,playerStatus);
        playerMap.get(player).add(1,kills);
        playerMap.get(player).add(2,deaths);
        playerMap.get(player).add(3,teamColor);
        playerMap.get(player).add(4,rank);
    }

    public static void setPlayerMapKey(Player player, PlayerMapKay key, Object obj){
        switch (key){
            case PS:
                playerMap.get(player).add(0,obj);
                break;
            case KILLS:
                playerMap.get(player).add(1,obj);
                break;
            case DEATHS:
                playerMap.get(player).add(2,obj);
                break;
            case TEAM:
                playerMap.get(player).add(3,obj);
                break;
            case RANK:
                playerMap.get(player).add(4,obj);
                break;
        }
    }

    public static Object getPlayerMapKey(Player player,PlayerMapKay key){
        switch (key){
            case PS:
                return playerMap.get(player).get(0);
            case KILLS:
                return playerMap.get(player).get(1);
            case DEATHS:
                return playerMap.get(player).get(2);
            case TEAM:
                return playerMap.get(player).get(3);
            case RANK:
                return playerMap.get(player).get(4);
        }
        return null;
    }


    public static void resetPlayerMap(){
        playerMap.clear();
    }
}
