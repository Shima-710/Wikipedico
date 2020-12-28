package com.shmn7iii.wikipedico;

import com.shmn7iii.wikipedico.Enum.GameStatus;
import com.shmn7iii.wikipedico.Enum.PlayerStatus;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Event  implements Listener {
    public static Main plugin;
    public Event(Main instance) { plugin = instance; }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        if(!(Main.GAMESTATUS.equals(GameStatus.NONE))){//ゲーム中なら
            if(PlayerMap.playerMap.containsValue(player)){//参加者なら
                PlayerMap.setPlayerMapKey(player, PlayerMap.PlayerMapKay.PS, PlayerStatus.SPEC);
            }
            else{
                PlayerMap.setPlayerMap(player,PlayerStatus.SPEC,0,0,null);
            }
        }
        else{

        }
    }


}
