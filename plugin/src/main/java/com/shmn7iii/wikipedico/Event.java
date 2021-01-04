package com.shmn7iii.wikipedico;

import com.shmn7iii.wikipedico.Enum.GameStatus;
import com.shmn7iii.wikipedico.Enum.PlayerStatus;
import com.shmn7iii.wikipedico.SubSystem.SystemTeam;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
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
                PlayerMap.setPlayerMap(player,PlayerStatus.SPEC,0,0,null,null);
            }
        }
        else{

        }
    }


    @EventHandler
    public void onDeathPlayer(PlayerDeathEvent e){
        Player victim = e.getEntity();
        if(!(Main.GAMESTATUS.equals(GameStatus.NONE))){//ゲーム中なら
            e.setDeathMessage(null);
            if(PlayerMap.playerMap.containsValue(victim)) {//参加者なら
                if(e.getEntity().getKiller() != null){
                    Player killer = e.getEntity().getKiller();
                    SystemMain.deathPlayer(victim,killer);
                    SystemMain.deathMessage(victim,killer,null);
                }
                else{
                    Entity ent = e.getEntity();
                    EntityDamageEvent ede = ent.getLastDamageCause();
                    assert ede != null;
                    EntityDamageEvent.DamageCause dc = ede.getCause();
                    SystemMain.deathMessage(victim,null,dc);
                }
            }
        }
    }

}
