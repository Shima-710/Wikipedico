package com.shmn7iii.wikipedico;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Event  implements Listener {
    public static Main plugin;
    public Event(Main instance) { plugin = instance; }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

    }
}
