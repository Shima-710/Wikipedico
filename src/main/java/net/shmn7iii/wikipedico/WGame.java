package net.shmn7iii.wikipedico;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.*;

public class WGame {
    public Map<Player, WPlayer> playerMap = new HashMap<>();
    public GameStatusEnum status;
    private World world;
    private WWorldBorder wWorldBorder;

    /**
     * ゲームステータス
     * PREPARE:  準備フェーズ
     * PROGRESS: 試合中
     * END:      終了後
     */
    public enum GameStatusEnum {
        PREPARE,
        PROGRESS,
        END,
    }

    /**
     * Singleton pattern
     * usage: WGame.getInstance()
     */
    private static WGame wGame = new WGame();

    private WGame() {
        wWorldBorder = new WWorldBorder();
    }

    public static WGame getInstance() {
        return wGame;
    }

    /**
     * 準備フェーズ
     * PVPオフ・上空ロービへTP
     *
     * @param _world ゲームを開始するワールド
     */
    public void prepare(World _world) {
        this.world = _world;
        this.status = GameStatusEnum.PROGRESS;

        // オンラインプレイヤーを参加者へ登録
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getGameMode().equals(GameMode.SURVIVAL) || p.getGameMode().equals(GameMode.ADVENTURE)) {
                this.playerMap.put(p, new WPlayer(p, WPlayer.PlayerStateEnum.ALIVE));
            } else {
                this.playerMap.put(p, new WPlayer(p, WPlayer.PlayerStateEnum.SPECTATE));
            }
        }

        if (this.getAlivePlayers().size() == 0) {
            Bukkit.broadcastMessage("error, no players");
            this.end("error");
            return;
        }

        //TODO: tp to sky lobby

        Timer timer = new Timer();
        timer.schedule(prepareTimerTask, 10000);

        Bukkit.broadcastMessage("prepare");
    }

    /**
     * ゲーム開始
     * PVP開始・降下開始
     */
    public void start() {
        Bukkit.broadcastMessage("start");

        Timer timer = new Timer();
        timer.schedule(worldBorderStartTimerTask, 10000);
    }

    /**
     * ゲーム終了
     * ワールド入れ替え前提ならロビーに帰さなくても良いのでは
     *
     * @param winner
     */
    public void end(String winner) {
        status = GameStatusEnum.END;

        Bukkit.broadcastMessage("end, winner: " + winner);

        wWorldBorder.resetWorldBorder(world);
    }

    /**
     * 終了チェック
     *
     * @return 終了条件達成でendさせる
     */
    public void checkGameEnd() {
        ArrayList<WPlayer> alivePlayers = this.getAlivePlayers();

        if (alivePlayers.size() != 1) {
            return;
        }

        this.end(alivePlayers.get(0).player.getDisplayName());
    }

    /**
     * 生存者のリストを返却
     *
     * @return 生存しているWPlayer
     */
    public ArrayList<WPlayer> getAlivePlayers() {
        ArrayList<WPlayer> alivePlayers = new ArrayList<>();
        for (WPlayer wPlayer : this.playerMap.values()) {
            if (wPlayer.state == WPlayer.PlayerStateEnum.ALIVE) {
                alivePlayers.add(wPlayer);
            }
        }

        return alivePlayers;
    }

    private TimerTask prepareTimerTask = new TimerTask() {
        public void run() {
            start();
        }
    };

    private TimerTask worldBorderStartTimerTask = new TimerTask() {
        public void run() {
            Bukkit.broadcastMessage("set world border");
            wWorldBorder.startWorldBorder(world, getAlivePlayers());
        }
    };

}
