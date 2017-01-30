/*
 *     Copyright 2016-2017 Rockey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package me.rockey.cessentials.core;

import me.rockey.cessentials.commands.*;
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
            log.warning("[cEssentials] You must use this plugin on a 1.8+ server, otherwise it won't work.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        log.info("[cEssentials] Hooked into: " + Bukkit.getVersion());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("list").setExecutor(new ListCommand());
        getCommand("invsee").setExecutor(new InvseeCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("clear").setExecutor(new ClearCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("day").setExecutor(new DayCommand());
        getCommand("night").setExecutor(new NightCommand());
        getCommand("sun").setExecutor(new SunCommand());
        getCommand("rain").setExecutor(new RainCommand());
        getCommand("storm").setExecutor(new StormCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("tp").setExecutor(new TpCommand());
        getCommand("tphere").setExecutor(new TphereCommand());
        getCommand("gmc").setExecutor(new GamemodeCommand());
        getCommand("gms").setExecutor(new GamemodeCommand());
        getCommand("gma").setExecutor(new GamemodeCommand());
        getCommand("gmsp").setExecutor(new GamemodeCommand());
        getCommand("world").setExecutor(new WorldCommand());
        getCommand("give").setExecutor(new GiveCommand());
        getCommand("item").setExecutor(new ItemCommand());
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
