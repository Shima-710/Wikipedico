package com.github.shima710.wikipedico;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import java.util.Objects;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class Wikipedico extends JavaPlugin {

    public static String version = Wikipedico.class.getPackage().getImplementationVersion();

    @Override
    public void onEnable() {
        getLogger().info("Hello!");
        getLogger().info("Current version is v"+version);

        File exconfig = new File("./plugins/Wikipedico/config.yml");
        if(!exconfig.exists()){
            saveDefaultConfig();
        }
        wikiConfigReload();

    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye!");
    }


    public void wikiConfigReload(){
        FileConfiguration config = getConfig();
        try {
            BufferedReader file = new BufferedReader(new FileReader("./plugins/Skript/scripts/config.sk"));
            StringBuffer inputBuffer = new StringBuffer();
            String line;

            while ((line = file.readLine()) != null) {
                if(line.contains("set {Natto.defaultModeTeam} to")){
                    line = "    set {Natto.defaultModeTeam} to " + config.getString("DefaultMode.Team");
                }
                if(line.contains("set {Natto.defaultMode2Team} to")){
                    line = "    set {Natto.defaultMode2Team} to " + config.getString("DefaultMode.2Team");
                }
                if(line.contains("set {Natto.defaultModeDaruma} to")){
                    line = "    set {Natto.defaultModeDaruma} to " + config.getString("DefaultMode.Daruma");
                }
                if(line.contains("set {Natto.defaultModeYuki} to")){
                    line = "    set {Natto.defaultModeYuki} to " + config.getString("DefaultMode.Yukigassen");
                }
                if(line.contains("set {Natto.defaultModeIbuibu} to")){
                    line = "    set {Natto.defaultModeIbuibu} to " + config.getString("DefaultMode.Ibuibu");
                }
                if(line.contains("set {Natto.teamMaxPlayer} to")){
                    line = "    set {Natto.teamMaxPlayer} to " + config.getString("TeamMaxPlayer");
                }
                if(line.contains("set {Natto.prepareTime} to")){
                    line = "    set {Natto.prepareTime} to " + config.getString("PreparationTime");
                }
                if(line.contains("set {Natto.countdownTimes} to")){
                    line = "    set {Natto.countdownTimes} to " + config.getString("CountDownTime");
                }
                if(line.contains("set {Natto.KillRankingTimes} to")){
                    line = "    set {Natto.KillRankingTimes} to " + config.getString("KillRankingTimes");
                }
                if(line.contains("set {Natto.daruma.damage} to")){
                    line = "    set {Natto.daruma.damage} to " + config.getString("DarumaDamage");
                }
                if(line.contains("set {Natto.maxChestSlotQua} to")){
                    line = "    set {Natto.maxChestSlotQua} to " + config.getString("MaxChestSlotOccupancy");
                }
                if(line.contains("set {Natto.delBlockTime} to")){
                    line = "    set {Natto.delBlockTime} to " + config.getString("BlockDestroyTime");
                }
                if(line.contains("set {Natto.yukidamaAmount} to")){
                    line = "    set {Natto.yukidamaAmount} to " + config.getString("YukidamaAmount");
                }
                if(line.contains("set {Natto.snowball.power} to")) {
                    line = "    set {Natto.snowball.power} to " + config.getString("YukidamaExplosionPower");
                }
                if(line.contains("set {price.buy.leather} to")) {
                    line = "    set {price.buy.leather} to " + config.getString("Shop.Buy.leather");
                }
                if(line.contains("set {price.buy.iron} to")) {
                    line = "    set {price.buy.iron} to " + config.getString("Shop.Buy.iron");
                }
                if(line.contains("set {price.buy.gold} to")) {
                    line = "    set {price.buy.gold} to " + config.getString("Shop.Buy.gold");
                }
                if(line.contains("set {price.buy.diamond} to")) {
                    line = "    set {price.buy.diamond} to " + config.getString("Shop.Buy.diamond");
                }
                if(line.contains("set {price.buy.planks} to")) {
                    line = "    set {price.buy.planks} to " + config.getString("Shop.Buy.planks");
                }
                if(line.contains("set {price.buy.stone} to")) {
                    line = "    set {price.buy.stone} to " + config.getString("Shop.Buy.stone");
                }
                if(line.contains("set {price.buy.string} to")) {
                    line = "    set {price.buy.string} to " + config.getString("Shop.Buy.string");
                }
                if(line.contains("set {price.buy.arrow} to")) {
                    line = "    set {price.buy.arrow} to " + config.getString("Shop.Buy.arrow");
                }
                if(line.contains("set {price.buy.apple} to")) {
                    line = "    set {price.buy.apple} to " + config.getString("Shop.Buy.apple");
                }
                if(line.contains("set {price.buy.firework} to")) {
                    line = "    set {price.buy.firework} to " + config.getString("Shop.Buy.firework");
                }
                if(line.contains("set {price.buy.lapis} to")) {
                    line = "    set {price.buy.lapis} to " + config.getString("Shop.Buy.lapislazuli");
                }
                if(line.contains("set {price.buy.enchant} to")) {
                    line = "    set {price.buy.enchant} to " + config.getString("Shop.Buy.enchant_bottle");
                }
                if(line.contains("set {price.sell.leather} to")) {
                    line = "    set {price.sell.leather} to " + config.getString("Shop.Sell.leather");
                }
                if(line.contains("set {price.sell.iron} to")) {
                    line = "    set {price.sell.iron} to " + config.getString("Shop.Sell.iron");
                }
                if(line.contains("set {price.sell.gold} to")) {
                    line = "    set {price.sell.gold} to " + config.getString("Shop.Sell.gold");
                }
                if(line.contains("set {price.sell.diamond} to")) {
                    line = "    set {price.sell.diamond} to " + config.getString("Shop.Sell.diamond");
                }
                if(line.contains("set {price.sell.planks} to")) {
                    line = "    set {price.sell.planks} to " + config.getString("Shop.Sell.planks");
                }
                if(line.contains("set {price.sell.stone} to")) {
                    line = "    set {price.sell.stone} to " + config.getString("Shop.Sell.stone");
                }
                if(line.contains("set {price.sell.string} to")) {
                    line = "    set {price.sell.string} to " + config.getString("Shop.Sell.string");
                }
                if(line.contains("set {price.sell.arrow} to")) {
                    line = "    set {price.sell.arrow} to " + config.getString("Shop.Sell.arrow");
                }
                if(line.contains("set {price.sell.apple} to")) {
                    line = "    set {price.sell.apple} to " + config.getString("Shop.Sell.apple");
                }
                if(line.contains("set {price.sell.firework} to")) {
                    line = "    set {price.sell.firework} to " + config.getString("Shop.Sell.firework");
                }
                if(line.contains("set {price.sell.lapis} to")) {
                    line = "    set {price.sell.lapis} to " + config.getString("Shop.Sell.lapislazuli");
                }
                if(line.contains("set {price.sell.enchant} to")) {
                    line = "    set {price.sell.enchant} to " + config.getString("Shop.Sell.enchant_bottle");
                }
                if(line.contains("set {price.sell.leather_helmet} to")) {
                    line = "    set {price.sell.leather_helmet} to " + config.getString("Shop.Sell.leather_armors");
                }
                if(line.contains("set {price.sell.leather_chestplate} to")) {
                    line = "    set {price.sell.leather_chestplate} to " + config.getString("Shop.Sell.leather_armors");
                }
                if(line.contains("set {price.sell.leather_leggings} to")) {
                    line = "    set {price.sell.leather_leggings} to " + config.getString("Shop.Sell.leather_armors");
                }
                if(line.contains("set {price.sell.leather_boots} to")) {
                    line = "    set {price.sell.leather_boots} to " + config.getString("Shop.Sell.leather_armors");
                }
                if(line.contains("set {price.sell.iron_helmet} to")) {
                    line = "    set {price.sell.iron_helmet} to " + config.getString("Shop.Sell.iron_armors");
                }
                if(line.contains("set {price.sell.iron_chestplate} to")) {
                    line = "    set {price.sell.iron_chestplate} to " + config.getString("Shop.Sell.iron_armors");
                }
                if(line.contains("set {price.sell.iron_leggings} to")) {
                    line = "    set {price.sell.iron_leggings} to " + config.getString("Shop.Sell.iron_armors");
                }
                if(line.contains("set {price.sell.iron_boots} to")) {
                    line = "    set {price.sell.iron_boots} to " + config.getString("Shop.Sell.iron_armors");
                }
                if(line.contains("set {price.sell.golden_helmet} to")) {
                    line = "    set {price.sell.golden_helmet} to " + config.getString("Shop.Sell.golden_armors");
                }
                if(line.contains("set {price.sell.golden_chestplate} to")) {
                    line = "    set {price.sell.golden_chestplate} to " + config.getString("Shop.Sell.golden_armors");
                }
                if(line.contains("set {price.sell.golden_leggings} to")) {
                    line = "    set {price.sell.golden_leggings} to " + config.getString("Shop.Sell.golden_armors");
                }
                if(line.contains("set {price.sell.golden_boots} to")) {
                    line = "    set {price.sell.golden_boots} to " + config.getString("Shop.Sell.golden_armors");
                }
                if(line.contains("set {price.sell.diamond_helmet} to")) {
                    line = "    set {price.sell.diamond_helmet} to " + config.getString("Shop.Sell.diamond_armors");
                }
                if(line.contains("set {price.sell.diamond_chestplate} to")) {
                    line = "    set {price.sell.diamond_chestplate} to " + config.getString("Shop.Sell.diamond_armors");
                }
                if(line.contains("set {price.sell.diamond_leggings} to")) {
                    line = "    set {price.sell.diamond_leggings} to " + config.getString("Shop.Sell.diamond_armors");
                }
                if(line.contains("set {price.sell.diamond_boots} to")) {
                    line = "    set {price.sell.diamond_boots} to " + config.getString("Shop.Sell.diamond_armors");
                }
                if(line.contains("set {price.sell.wooden_sword} to")) {
                    line = "    set {price.sell.wooden_sword} to " + config.getString("Shop.Sell.wooden_sword");
                }
                if(line.contains("set {price.sell.stone_sword} to")) {
                    line = "    set {price.sell.stone_sword} to " + config.getString("Shop.Sell.stone_sword");
                }
                if(line.contains("set {price.sell.iron_sword} to")) {
                    line = "    set {price.sell.iron_sword} to " + config.getString("Shop.Sell.iron_sword");
                }
                if(line.contains("set {price.sell.golden_sword} to")) {
                    line = "    set {price.sell.golden_sword} to " + config.getString("Shop.Sell.golden_sword");
                }
                if(line.contains("set {price.sell.diamond_sword} to")) {
                    line = "    set {price.sell.diamond_sword} to " + config.getString("Shop.Sell.diamond_sword");
                }
                if(line.contains("set {price.sell.bow} to")) {
                    line = "    set {price.sell.bow} to " + config.getString("Shop.Sell.bow");
                }
                if(line.contains("set {price.sell.crossbow} to")) {
                    line = "    set {price.sell.crossbow} to " + config.getString("Shop.Sell.crossbow");
                }
                if(line.contains("set {price.sell.elytra} to")) {
                    line = "    set {price.sell.elytra} to " + config.getString("Shop.Sell.elytra");
                }
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            file.close();

            FileOutputStream fileOut = new FileOutputStream("./plugins/Skript/scripts/config.sk");
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }
    }


    public static void update() throws Exception {
        delDir("./plugins/Skript/scripts");
        copyResrcDir("scripts", "./plugins/Skript/scripts");

        delDir("./world/datapacks");
        copyResrcDir("datapacks", "./world/datapacks");

        rewriteVer();

    }

    public static void rewriteVer(){
        try {
            BufferedReader file = new BufferedReader(new FileReader("./plugins/Skript/scripts/config.sk"));
            StringBuffer inputBuffer = new StringBuffer();
            String line;

            while ((line = file.readLine()) != null) {
                if(line.contains("set {ver} to")){
                    line = "    set {ver} to \"v" + version + "\"";
                }
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            file.close();

            FileOutputStream fileOut = new FileOutputStream("./plugins/Skript/scripts/config.sk");
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }
    }


    public static void loadVaris() throws IOException, URISyntaxException {
        backupVaris();
        delFile("./plugins/Skript/variables.csv");
        copyResrcDir("variables","./plugins/Skript");
    }

    public static void backupVaris() throws IOException {
        File bkup = new File("./plugins/Wikipedico/backup");
        if(!bkup.exists()){
            bkup.mkdir();
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("MMdd_HHmm");
        String datetimeformated = datetimeformatter.format(localDateTime);
        String targ = "./plugins/Wikipedico/backup/variables_" + datetimeformated + ".csv";

        Path source = Paths.get("./plugins/Skript/variables.csv");
        Path target = Paths.get(targ);
        Files.copy(source, target);
    }


    public static void delDir(final String dirPath) {
        File file = new File(dirPath);
        if(file.exists()){
            recursiveDeleteFile(file);
        }
    }

    public static void delFile(String filePath) throws IOException {
        Files.deleteIfExists(Paths.get(filePath));
    }

    public static void copyResrcDir(String strSrcName, String strDestPath) throws IOException, URISyntaxException {
        File destDir = new File(strDestPath);

        final File jarFile = new File(Wikipedico.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        if (jarFile.isFile()) {
            // JARで実行する場合
            final JarFile jar = new JarFile(jarFile);
            for (Enumeration<JarEntry> entries = jar.entries(); entries.hasMoreElements();) {
                JarEntry entry = entries.nextElement();
                if (entry.getName().startsWith(strSrcName + "/") && !entry.isDirectory()) {
                    File dest = new File(destDir, entry.getName().substring(strSrcName.length() + 1));
                    File parent = dest.getParentFile();
                    if (parent != null) {
                        parent.mkdirs();
                    }
                    try (FileOutputStream out = new FileOutputStream(dest); InputStream in = jar.getInputStream(entry)) {
                        byte[] buffer = new byte[8 * 1024];
                        int s = 0;
                        while ((s = in.read(buffer)) > 0) {
                            out.write(buffer, 0, s);
                        }
                    }
                }
            }
            jar.close();
        } else {
            // IDEで実行する場合
            final File resource = new File(Objects.requireNonNull(Wikipedico.class.getClassLoader().getResource(strSrcName)).toURI());
            FileUtils.copyDirectory(resource, destDir);
        }
    }







    /**
     * 対象のファイルオブジェクトの削除を行う.
     * ディレクトリの場合は再帰処理を行い、削除する。
     *
     * @param file ファイルオブジェクト
     */
    private static void recursiveDeleteFile(final File file) {
        // 存在しない場合は処理終了
        if (!file.exists()) {
            return;
        }
        // 対象がディレクトリの場合は再帰処理
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                recursiveDeleteFile(child);
            }
        }
        // 対象がファイルもしくは配下が空のディレクトリの場合は削除する
        file.delete();
    }


    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){

        if(cmd.getName().equalsIgnoreCase("update")){
            try {
                update();
                Bukkit.getLogger().info("[Wikipedico] Updated Successfully!");
                Bukkit.getLogger().info("[Wikipedico] Server will be reloaded.");
                Bukkit.reload();
                sender.sendMessage(ChatColor.GREEN + ">Wikipedico [INFO] " + ChatColor.WHITE + "Updated! Current version is v" + version);
            } catch (Exception e) {
                e.printStackTrace();
                sender.sendMessage(ChatColor.RED + ">Wikipedico [ERROR] " + ChatColor.WHITE + "Some error occurred.");
            }
            return true;
        }
        else if(cmd.getName().equalsIgnoreCase("install")){
            try {
                delFile("./plugins/Wikipedico/config.yml");
                loadVaris();
                update();
                Bukkit.getLogger().info("[Wikipedico] Installed Successfully!");
                Bukkit.getLogger().info("[Wikipedico] Server will be reloaded.");
                Bukkit.reload();
                sender.sendMessage(ChatColor.GREEN + ">Wikipedico [INFO] " + ChatColor.WHITE + "Installed! Current version is v" + version);
            } catch (Exception e) {
                e.printStackTrace();
                sender.sendMessage(ChatColor.RED + ">Wikipedico [ERROR] " + ChatColor.WHITE + "Some error occurred.");
            }
            return true;
        }
        else if(cmd.getName().equalsIgnoreCase("loadvaris")){
            try {
                loadVaris();
                Bukkit.getLogger().info("[Wikipedico] Reloading variables.csv wes Succeed!");
                Bukkit.getLogger().info("[Wikipedico] Server will be reloaded.");
                Bukkit.reload();
                sender.sendMessage(ChatColor.GREEN + ">Wikipedico [INFO] " + ChatColor.WHITE + "variables.csv was Reloaded! Current version is v" + version);
            } catch (Exception e) {
                e.printStackTrace();
                sender.sendMessage(ChatColor.RED + ">Wikipedico [ERROR] " + ChatColor.WHITE + "Some error occurred.");
            }
            return true;
        }
        else if(cmd.getName().equalsIgnoreCase("backup")){
            try {
                backupVaris();
                sender.sendMessage(ChatColor.GREEN + ">Wikipedico [INFO] " + ChatColor.WHITE + "Success! variables.csv is backed up.");
            } catch (Exception e) {
                e.printStackTrace();
                sender.sendMessage(ChatColor.RED + ">Wikipedico [ERROR] " + ChatColor.WHITE + "Some error occurred.");
            }
            return true;
        }
        return false;
    }



}

