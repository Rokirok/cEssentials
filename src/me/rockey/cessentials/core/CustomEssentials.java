package me.rockey.cessentials.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Created by oskar on 27.1.2017.
 */
public class CustomEssentials extends JavaPlugin {

    public final Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        String version = Bukkit.getVersion();
        if(!(version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11"))) {
            log.warning("You must use this plugin on a 1.8+ server, otherwise it won't work.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {

    }

    public void loadListeners() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
    }
}
