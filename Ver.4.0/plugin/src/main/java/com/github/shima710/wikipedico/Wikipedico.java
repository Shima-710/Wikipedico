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

        File con = new File("./plugins/Wikipedico/config.yml");
        if(!con.exists()){
            saveDefaultConfig();
        }

    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye!");
    }




    public static void update() throws Exception {
        delDir("./plugins/Skript/scripts");
        copyResrcDir("scripts", "./plugins/Skript/scripts");

        delDir("./world/datapacks");
        copyResrcDir("datapacks", "./world/datapacks");

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

