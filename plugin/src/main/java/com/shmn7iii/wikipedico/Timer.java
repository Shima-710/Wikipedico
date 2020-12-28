package com.shmn7iii.wikipedico;

import com.shmn7iii.wikipedico.Enum.TimerKind;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer extends BukkitRunnable {
    private final Main plg;
    private TimerKind kind;
    private int count;
    private final Boolean expBar;

    /**
     * @param plg_    プラグインメインクラスのインスタンス
     * @param kind_   しゅるい
     * @param count_  時間
     * @param expBar_ 経験値バーの変動の有無
     */
    public Timer(Main plg_, TimerKind kind_, int count_, Boolean expBar_) {
        plg = plg_;
        kind = kind_;
        count = count_;
        expBar = expBar_;
    }

    /**
     * 非同期処理実行メソッド
     */
    public void run() {

        if (expBar) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendExperienceChange(0, count);
            }
        }

        if (count == 0) {
            switch (kind){
                case PREPARE:
                    SystemMain.gameStart();
            }
            this.cancel();
        }

        count--;
    }
}
