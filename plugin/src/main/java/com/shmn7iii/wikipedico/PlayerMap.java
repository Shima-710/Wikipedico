package com.shmn7iii.wikipedico;

import com.shmn7iii.wikipedico.SubSystem.TeamColor;
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
        TEAM
    }

    public static void setPlayerMap(Player player, PlayerStatus playerStatus, int kills, int deaths, TeamColor teamColor){
        playerMap.put(player,new ArrayList<>());
        playerMap.get(player).add(0,playerStatus);
        playerMap.get(player).add(1,kills);
        playerMap.get(player).add(2,deaths);
        playerMap.get(player).add(3,teamColor);
    }

    public static void setPlayerMapKey(Player player, PlayerMapKay key, Object obj){
        switch (key){
            case PS:
                playerMap.get(player).add(0,obj);
            case KILLS:
                playerMap.get(player).add(1,obj);
            case DEATHS:
                playerMap.get(player).add(2,obj);
            case TEAM:
                playerMap.get(player).add(3,obj);
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
        }
        return null;
    }


    public static void resetPlayerMap(){
        playerMap.clear();
    }
}
