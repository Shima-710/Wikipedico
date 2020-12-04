package com.github.shima710.wikipedico;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public final class Wikipedico extends JavaPlugin {

    public static String version = Wikipedico.class.getPackage().getImplementationVersion();

    @Override
    public void onEnable() {
        getLogger().info("Hello!");
        getLogger().info("Current version is v"+version);
        try {
            rewriteVersion();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye!");
    }


    public void update() throws IOException, URISyntaxException {
        delScripts();
        copyScripts();

        delDatapacks();
        copyDatapacks();

        Bukkit.getLogger().info("[Wikipedico] Installed Successfully!");
        Bukkit.getLogger().info("[Wikipedico] Server will be reloaded.");
        Bukkit.reload();
    }

    public void delScripts() throws IOException {
        String strSkriptScript = "./plugins/Skript/scripts";
        Path pathSkriptScript = Paths.get(strSkriptScript);
        Files.deleteIfExists(pathSkriptScript);
    }

    public void copyScripts() throws IOException, URISyntaxException {
        String srcDirName = "scripts"; // コピーしたいリソース
        File destDir = new File("./plugins/Skript"); // コピー先のディレクトリ
        File resource = new File(Objects.requireNonNull(Wikipedico.class.getClassLoader().getResource(srcDirName)).toURI());
        FileUtils.copyDirectory(resource, destDir);
    }

    public void delDatapacks() throws IOException {
        String strWorldDatapacks = "../world/datapacks";
        Path pathWorldDatapacks = Paths.get(strWorldDatapacks);
        Files.deleteIfExists(pathWorldDatapacks);
    }

    public void copyDatapacks() throws IOException, URISyntaxException {
        String srcDirName = "datapacks"; // コピーしたいリソース
        File destDir = new File("../world"); // コピー先のディレクトリ
        File resource = new File(Objects.requireNonNull(Wikipedico.class.getClassLoader().getResource(srcDirName)).toURI());
        FileUtils.copyDirectory(resource, destDir);
    }

    public void rewriteVersion() throws IOException, URISyntaxException {
        String srcStrConfig = "scripts/config.sk";
        File srcFileConfig = new File(Objects.requireNonNull(Wikipedico.class.getClassLoader().getResource(srcStrConfig)).toURI());

        BufferedReader br = new BufferedReader(new FileReader(srcFileConfig));
        StringBuffer inputBuffer = new StringBuffer();
        String line;

        while ((line = br.readLine()) != null) {
            if (line.contains("set {ver} to")){
                line = "set {ver} to " + version;
            }
            inputBuffer.append(line);
            inputBuffer.append('\n');
        }
        br.close();

        FileOutputStream fileOut = new FileOutputStream(srcFileConfig);
        fileOut.write(inputBuffer.toString().getBytes());
        fileOut.close();
    }




    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){

        // update
        if(cmd.getName().equalsIgnoreCase("update")){
            try {
                update();
                sender.sendMessage(ChatColor.GREEN + ">Wikipedico [INFO] " + ChatColor.WHITE + "Success!");
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
                sender.sendMessage(ChatColor.RED + ">Wikipedico [ERROR] " + ChatColor.WHITE + "Some error occurred.");
            }
            return true;
            }
        return false;
    }



}
