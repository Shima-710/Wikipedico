package com.shmn7iii.wikipedico;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer extends BukkitRunnable {
    private final Main plg;
    private int count;
    private final Boolean expBar;

    /**
     * コンストラクタ
     *
     * @param plg_   プラグインメインクラスのインスタンス
     * @param count_ 表示する値
     */
    public Timer(Main plg_, int count_, Boolean expBar_) {
        plg = plg_;
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
            this.cancel();
        }

        count--;
    }
}
