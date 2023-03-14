package net.shmn7iii.wikipedico;

import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class Wikipedico extends JavaPlugin {
    public Wikipedico plugin;
    public String version = Wikipedico.class.getPackage().getImplementationVersion();

    @Override
    public void onEnable() {
        plugin = this;

        getServer().getPluginManager().registerEvents(new WEventHandler(this), this);

        setGameRules(plugin.getServer().getWorld("world"));

        getLogger().info("Hello!");
        getLogger().info("Current version is v" + version);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private static void setGameRules(World world) {
        world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        world.setGameRule(GameRule.COMMAND_BLOCK_OUTPUT, false);
        world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        world.setGameRule(GameRule.DO_MOB_SPAWNING, false);
        world.setGameRule(GameRule.FALL_DAMAGE, false);
        world.setGameRule(GameRule.KEEP_INVENTORY, true);
        world.setGameRule(GameRule.SPAWN_RADIUS, 1);
        world.setStorm(false);
        world.setTime(6000);
    }
}
