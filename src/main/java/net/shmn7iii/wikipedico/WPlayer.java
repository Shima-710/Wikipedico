package net.shmn7iii.wikipedico;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class WPlayer {
    public Player player;
    public Integer killCount;
    public PlayerStateEnum state;

    /**
     * プレイヤーステータス
     * ALIVE:    生存中
     * DEAD:     死亡
     * SPECTATE: 観戦
     */
    public enum PlayerStateEnum {
        ALIVE,
        DEAD,
        SPECTATE
    }

    public WPlayer(Player _player, PlayerStateEnum _state) {
        this.player = _player;
        this.state = _state;
        this.killCount = 0;

        if (this.state == PlayerStateEnum.SPECTATE) {
            this.player.setGameMode(GameMode.SPECTATOR);
        } else {
            this.player.setGameMode(GameMode.ADVENTURE);
        }
    }

    /**
     * Player kills someone.
     */
    public void kill() {
        this.killCount++;
    }

    /**
     * Player has killed by someone.
     */
    public void dead() {
        this.state = PlayerStateEnum.DEAD;
        this.player.setGameMode(GameMode.SPECTATOR);
    }

    /**
     * Player has revived by someone.
     */
    public void revived() {
        this.state = PlayerStateEnum.ALIVE;
        this.player.setGameMode(GameMode.ADVENTURE);
    }
}
