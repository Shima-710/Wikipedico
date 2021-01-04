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

    public int bs_count;

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

        switch (kind){
            case PREPARE:
                if (count <= 5 && count != 0) {
                    for (Player p:Bukkit.getOnlinePlayers()){
                        p.sendTitle(null, String.valueOf(count),20,20,20);
                    }
                }
                if (count == 0) {
                    this.cancel();
                    SystemMain.gameStart();
                }
                break;
            case SETWB:
                if (count == 0) {
                    this.cancel();
                    SystemMain.setWorldBorder();
                }
                break;
            case BOSSBAR:
                SystemMain.setBossBar((double) count/Config.WorldBorderTime);
                if (count == 0) {
                    Main.BOSSBAR.setVisible(false);
                    this.cancel();
                }
        }

        count--;
    }
}
