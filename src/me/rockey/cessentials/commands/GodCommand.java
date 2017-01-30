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

package me.rockey.cessentials.commands;

import me.rockey.cessentials.core.CustomEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GodCommand implements CommandExecutor {

    private ArrayList<Player> godList = CustomEssentials.god;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("god")) {
                if (args.length < 1) {
                    if (p.hasPermission("cessentials.god")) {
                        if (godList.contains(p)) {
                            godList.remove(p);
                            p.sendMessage(ChatColor.GRAY + "God mode " + ChatColor.RED + "disabled");
                            return true;
                        } else if (!(godList.contains(p))) {
                            godList.add(p);
                            p.sendMessage(ChatColor.GRAY + "God mode " + ChatColor.GREEN + "enabled");
                            return true;
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "No permission!");
                    }
                } else {
                    if (p.hasPermission("cessentials.god.others")) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            if (godList.contains(target)) {
                                godList.remove(target);
                                target.sendMessage(ChatColor.GRAY + "God mode " + ChatColor.RED + "disabled");
                                p.sendMessage(ChatColor.GRAY + "Set god mode " + ChatColor.RED + "disabled " + ChatColor.GRAY + "for " + ChatColor.GREEN + target.getName());
                                return true;
                            } else if (!(godList.contains(p))) {
                                godList.add(target);
                                target.sendMessage(ChatColor.GRAY + "God mode " + ChatColor.GREEN + "enabled");
                                p.sendMessage(ChatColor.GRAY + "Set god mode " + ChatColor.GREEN + "enabled " + ChatColor.GRAY + "for " + ChatColor.GREEN + target.getName());
                                return true;
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "Player not found!");
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "No permission!");
                    }
                }
            }
        } else {
            if (cmd.getName().equalsIgnoreCase("god")) {
                if (sender.hasPermission("cessentials.god.others")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        if (godList.contains(target)) {
                            godList.remove(target);
                            target.sendMessage(ChatColor.GRAY + "God mode " + ChatColor.RED + "disabled");
                            sender.sendMessage("Set god mode disabled for "+ target.getName());
                            return true;
                        } else if (!(godList.contains(target))) {
                            godList.add(target);
                            target.sendMessage(ChatColor.GRAY + "God mode " + ChatColor.GREEN + "enabled");
                            sender.sendMessage("Set god mode enabled for "+ target.getName());
                            return true;
                        }
                    } else {
                        sender.sendMessage(ChatColor.RED + "Player not found!");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "No permission!");
                }
            }
        }
        return false;
    }
}
