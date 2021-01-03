package com.shmn7iii.wikipedico.SubSystem;

import com.shmn7iii.wikipedico.Enum.PlayerStatus;
import com.shmn7iii.wikipedico.Main;
import com.shmn7iii.wikipedico.PlayerMap;
import org.bukkit.entity.Player;

public class SystemTeam {

    public static void playerAddTeam(Player player, TeamColor col){
        switch (col){
            case PLAY:
                Main.TEAM_PLAYER.addEntry(player.getName());
                PlayerMap.setPlayerMapKey(player, PlayerMap.PlayerMapKay.PS, PlayerStatus.PLAY);
            case SPEC:
                Main.TEAM_SPEC.addEntry(player.getName());
                PlayerMap.setPlayerMapKey(player, PlayerMap.PlayerMapKay.PS, PlayerStatus.SPEC);
            case RED:
                Main.TEAM_RED.addEntry(player.getName());
            case BLUE:
                Main.TEAM_BLUE.addEntry(player.getName());
            case YELLOW:
                Main.TEAM_YELLOW.addEntry(player.getName());
            case GREEN:
                Main.TEAM_GREEN.addEntry(player.getName());
            case ORANGE:
                Main.TEAM_ORANGE.addEntry(player.getName());
            case PURPLE:
                Main.TEAM_PURPLE.addEntry(player.getName());
            case GRAY:
                Main.TEAM_GRAY.addEntry(player.getName());
        }
    }
}
