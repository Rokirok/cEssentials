package me.rockey.cessentials.core;

import me.rockey.cessentials.commands.GodCommand;
import me.rockey.cessentials.listeners.DamageListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.logging.Logger;

public class CustomEssentials extends JavaPlugin {

    public final Logger log = Logger.getLogger("Minecraft");
    public static ArrayList<Player> god = new ArrayList<Player>();

    @Override
    public void onEnable() {
        String version = Bukkit.getVersion();
        if(!(version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11"))) {
            log.warning("You must use this plugin on a 1.8+ server, otherwise it won't work.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        log.info("Hooked into: " + Bukkit.getVersion());
        getCommand("god").setExecutor(new GodCommand());
        loadListeners();
    }

    @Override
    public void onDisable() {

    }

    public void loadListeners() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new DamageListener(), this);
    }
}
