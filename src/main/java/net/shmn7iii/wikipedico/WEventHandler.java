package net.shmn7iii.wikipedico;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class WEventHandler implements Listener {
    public static Wikipedico plugin;

    public WEventHandler(Wikipedico instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent e) {
        WGame wgame = WGame.getInstance();
        if (wgame.status != WGame.GameStatusEnum.PROGRESS) {
            return;
        }

        WPlayer wPLayer = wgame.playerMap.get(e.getPlayer()); // nullなら？
        wPLayer.dead();

        wgame.checkGameEnd();
    }
    
    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent e) {
        WGame wgame = WGame.getInstance();
        if (wgame.status != WGame.GameStatusEnum.PROGRESS) {
            return;
        }

        WPlayer victimWPLayer = wgame.playerMap.get(e.getEntity()); // nullなら？
        victimWPLayer.dead();

        if (e.getEntity().getKiller() != null) {
            Player killer = e.getEntity().getKiller();
            WPlayer killerWPLayer = wgame.playerMap.get(killer);
            killerWPLayer.kill();
        }

        wgame.checkGameEnd();
    }


    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
        // Open control panel
        if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.NETHER_STAR) && e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            WControlPanel.getInstance().open(e.getPlayer());
        }
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent e) {
        if (e.getAction().equals(InventoryAction.NOTHING)) {
            return;
        }

        WControlPanel.getInstance().clickItemEvent(e);
    }
}
