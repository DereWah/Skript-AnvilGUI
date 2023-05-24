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

public class SkriptAnvilGUI extends JavaPlugin {

    static SkriptAnvilGUI instance;
    SkriptAddon addon;
    public static FileConfiguration config;
    public void onEnable(){
        instance = this;
        addon = Skript.registerAddon(this);
        try {
            addon.loadClasses("org.derewah.skriptanvilgui");
        } catch(IOException e){
            e.printStackTrace();
        }

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

    public static SkriptAnvilGUI getInstance(){
        return instance;
    }

    public SkriptAddon getAddonInstance(){
        return addon;
    }
}
