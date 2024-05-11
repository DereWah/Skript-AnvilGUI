package org.derewah.skriptanvilgui;

import org.bstats.bukkit.Metrics;
import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import org.bstats.charts.SimplePie;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.derewah.skriptanvilgui.utils.UpdateChecker;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SkriptAnvilGUI extends JavaPlugin {

    static SkriptAnvilGUI instance;
    SkriptAddon addon;
    public static FileConfiguration config;
    public void onEnable(){
        instance = this;
        String latest_compatible = "1.20.4";
        if (!isCompatible(this.getServer().getVersion(), latest_compatible)){
            getInstance().getLogger().severe("Skript-AnvilGUI is not compatible yet with this MC version." +
                    "Current version: " + this.getServer().getVersion() + ", latest compatible version: "
                    + latest_compatible);
            getServer().getPluginManager().disablePlugin(this);
            return;
        }



        addon = Skript.registerAddon(this);
        try {
            addon.loadClasses("org.derewah.skriptanvilgui");
        } catch(IOException e){
            e.printStackTrace();
        }
        addon.setLanguageFileDirectory("lang");
        // Register Metrics
        Metrics metrics = new Metrics(this, 18524);

        metrics.addCustomChart(new SimplePie("skript_version", () ->
                Bukkit.getServer().getPluginManager().getPlugin("Skript").getDescription().getVersion()));
        metrics.addCustomChart(new SimplePie("skript-anvilgui_version", () ->
                this.getDescription().getVersion()));

            new UpdateChecker(this, 110009).getVersion(version -> {
            if(this.getDescription().getVersion().equals(version)){
                getInstance().getLogger().info("Skript-AnvilGUI is up to date! Current:" + version);
            }else{
                getInstance().getLogger().info("Skript-AnvilGUI is out of date. Current: "+ this.getDescription().getVersion() + " Please update to make sure " +
                        "all of your anvil GUIs Skripts will work correctly. New version: " + version);
            }
        });




        Bukkit.getLogger().info("[Skript-AnvilGUI] has been enabled!");
    }

    public boolean isCompatible(String version, String limit) {
        // Regular expression pattern to extract version number
        String regex = "\\(MC: ([0-9.]+)\\)";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(version);

        // Check if the pattern is found in the input string
        if (matcher.find()) {
            String versionString = matcher.group(1);
            // Split the version string by dots
            String[] versionNumbers = versionString.split("\\.");
            String[] limitNumbers = limit.split("\\.");

            // Compare each part of the version number with the limit
            for (int i = 0; i < Math.min(versionNumbers.length, limitNumbers.length); i++) {
                int versionPart = Integer.parseInt(versionNumbers[i]);
                int limitPart = Integer.parseInt(limitNumbers[i]);
                if (versionPart > limitPart) {
                    // Version is newer than the limit
                    return false;
                } else if (versionPart < limitPart) {
                    // Version is older than the limit
                    return true;
                }
            }
            // If all parts are equal, the version is compatible
            return true;
        } else {
            // Version pattern not found
            return false;
        }
    }

    public static SkriptAnvilGUI getInstance(){
        return instance;
    }

    public SkriptAddon getAddonInstance(){
        return addon;
    }
}
