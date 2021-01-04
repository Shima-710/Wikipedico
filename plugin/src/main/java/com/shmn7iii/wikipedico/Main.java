package com.shmn7iii.wikipedico;

import com.shmn7iii.wikipedico.Enum.GameStatus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.boss.BossBar;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.Objects;

public final class Main extends JavaPlugin {
    public static Main plugin = null;
    public static String version = Main.class.getPackage().getImplementationVersion();



    public static World WORLD;
    public static Location LOBBY;
    public static GameStatus GAMESTATUS = GameStatus.NONE;

    public static BossBar BOSSBAR;

    public static Objective objective;
    public static Team TEAM_RED;
    public static Team TEAM_BLUE;
    public static Team TEAM_YELLOW;
    public static Team TEAM_GREEN;
    public static Team TEAM_ORANGE;
    public static Team TEAM_PURPLE;
    public static Team TEAM_GRAY;
    public static Team TEAM_PLAYER;
    public static Team TEAM_SPEC;


    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new Event(this), this);
        getServer().getPluginManager().registerEvents(new SystemMain(this), this);
        setCommandExecutor();
        saveDefaultConfig();
        Bukkit.getLogger().info("Hello!");

        setScoreBoard();
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("GoodBye!");
        try{
            TEAM_RED.unregister();
            TEAM_BLUE.unregister();
            TEAM_YELLOW.unregister();
            TEAM_GREEN.unregister();
            TEAM_ORANGE.unregister();
            TEAM_PURPLE.unregister();
            TEAM_GRAY.unregister();
            TEAM_PLAYER.unregister();
            TEAM_SPEC.unregister();
        }catch (IllegalArgumentException ignored){ }
    }




    public static void setScoreBoard(){
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        assert manager != null;
        Scoreboard board = manager.getMainScoreboard();


        TEAM_RED = board.registerNewTeam("RED");
        TEAM_RED.setColor(ChatColor.RED);
        TEAM_RED.setAllowFriendlyFire(false);

        TEAM_BLUE = board.registerNewTeam("BLUE");
        TEAM_BLUE.setColor(ChatColor.BLUE);
        TEAM_BLUE.setAllowFriendlyFire(false);

        TEAM_YELLOW = board.registerNewTeam("YELLOW");
        TEAM_YELLOW.setColor(ChatColor.YELLOW);
        TEAM_YELLOW.setAllowFriendlyFire(false);

        TEAM_GREEN = board.registerNewTeam("GREEN");
        TEAM_GREEN.setColor(ChatColor.GREEN);
        TEAM_GREEN.setAllowFriendlyFire(false);

        TEAM_ORANGE = board.registerNewTeam("ORANGE");
        TEAM_ORANGE.setColor(ChatColor.GOLD);
        TEAM_ORANGE.setAllowFriendlyFire(false);

        TEAM_PURPLE = board.registerNewTeam("PURPLE");
        TEAM_PURPLE.setColor(ChatColor.LIGHT_PURPLE);
        TEAM_PURPLE.setAllowFriendlyFire(false);

        TEAM_GRAY = board.registerNewTeam("GRAY");
        TEAM_GRAY.setColor(ChatColor.GRAY);
        TEAM_GRAY.setAllowFriendlyFire(false);
        TEAM_GRAY.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.FOR_OWN_TEAM);//TODO atteru?

        TEAM_PLAYER = board.registerNewTeam("PLAYER");
        TEAM_PLAYER.setColor(ChatColor.GREEN);
        TEAM_PLAYER.setAllowFriendlyFire(false);
        TEAM_PLAYER.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.FOR_OTHER_TEAMS);

        TEAM_SPEC = board.registerNewTeam("SPECTATOR");
        TEAM_SPEC.setColor(ChatColor.GRAY);
        TEAM_SPEC.setAllowFriendlyFire(false);

    }
    public void setCommandExecutor(){
        Commands command = new Commands();
        Objects.requireNonNull(getCommand("start")).setExecutor(command);
        Objects.requireNonNull(getCommand("end")).setExecutor(command);

    }
}
