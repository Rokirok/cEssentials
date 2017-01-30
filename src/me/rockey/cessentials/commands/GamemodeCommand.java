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

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("gamemode")) {
                if (args.length < 1) {
                    p.sendMessage(ChatColor.RED + "Usage: /gamemode <creative/survival/adventure>");
                    return true;
                }
                if (args[0].equals("1") || args[0].equals("c") || args[0].equals("creative")) {
                    if (!(args.length >= 2)) {
                        if (p.hasPermission("cessentials.gamemode.creative")) {
                            p.setGameMode(GameMode.CREATIVE);
                        } else {
                            p.sendMessage(ChatColor.RED + "No permission!");
                        }
                    } else {
                        if (p.hasPermission("cessentials.gamemode.creative.others")) {
                            Player target = Bukkit.getPlayer(args[1]);
                            if (target != null) {
                                target.setGameMode(GameMode.CREATIVE);
                            } else {
                                p.sendMessage(ChatColor.RED + "Player not found!");
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "No permission!");
                        }
                    }
                }
                if (args[0].equals("0") || args[0].equals("s") || args[0].equals("survival")) {
                    if (!(args.length >= 2)) {
                        if (p.hasPermission("cessentials.gamemode.survival")) {
                            p.setGameMode(GameMode.SURVIVAL);
                        } else {
                            p.sendMessage(ChatColor.RED + "No permission!");
                        }
                    } else {
                        if (p.hasPermission("cessentials.gamemode.survival.others")) {
                            Player target = Bukkit.getPlayer(args[1]);
                            if (target != null) {
                                target.setGameMode(GameMode.SURVIVAL);
                            } else {
                                p.sendMessage(ChatColor.RED + "Player not found!");
                            }
                        } else
                            p.sendMessage(ChatColor.RED + "No permission!");
                    }
                }
                if (args[0].equals("2") || args[0].equals("a") || args[0].equals("adventure")) {
                    if (!(args.length >= 2)) {
                        if (p.hasPermission("cessentials.gamemode.adventure")) {
                            p.setGameMode(GameMode.ADVENTURE);
                        } else {
                            p.sendMessage(ChatColor.RED + "No permission!");
                        }
                    } else {
                        if (p.hasPermission("cessentials.gamemode.adventure.others")) {
                            Player target = Bukkit.getPlayer(args[1]);
                            if (target != null) {
                                target.setGameMode(GameMode.ADVENTURE);
                            } else {
                                p.sendMessage(ChatColor.RED + "Player not found!");
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "No permission!");
                        }
                    }
                }
                if (args[0].equals("3") || args[0].equals("sp") || args[0].equals("spectator")) {
                    if (!(args.length >= 2)) {
                        if (p.hasPermission("cessentials.gamemode.spectator")) {
                            p.setGameMode(GameMode.SPECTATOR);
                        } else {
                            p.sendMessage(ChatColor.RED + "No permission!");
                        }
                    } else {
                        if (p.hasPermission("cessentials.gamemode.spectator.others")) {
                            Player target = Bukkit.getPlayer(args[1]);
                            if (target != null) {
                                target.setGameMode(GameMode.SPECTATOR);
                            } else {
                                p.sendMessage(ChatColor.RED + "Player not found!");
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "No permission!");
                        }
                    }
                }
            }
            if (cmd.getName().equalsIgnoreCase("gmc")) {
                if (!(args.length >= 1)) {
                    if (p.hasPermission("cessentials.gamemode.creative")) {
                        p.setGameMode(GameMode.CREATIVE);
                    } else {
                        p.sendMessage(ChatColor.RED + "No permission!");
                    }
                } else {
                    if (p.hasPermission("cessentials.gamemode.creative.others")) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            target.setGameMode(GameMode.CREATIVE);
                        } else {
                            p.sendMessage(ChatColor.RED + "Player not found!");
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "No permission!");
                    }
                }
            }
            if (cmd.getName().equalsIgnoreCase("gms")) {
                if (!(args.length >= 1)) {
                    if (p.hasPermission("cessentials.gamemode.survival")) {
                        p.setGameMode(GameMode.SURVIVAL);
                    } else {
                        p.sendMessage(ChatColor.RED + "No permission!");
                    }
                } else {
                    if (p.hasPermission("cessentials.gamemode.survival.others")) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            target.setGameMode(GameMode.SURVIVAL);
                        } else {
                            p.sendMessage(ChatColor.RED + "Player not found!");
                        }
                    } else
                        p.sendMessage(ChatColor.RED + "No permission!");
                }
            }
            if (cmd.getName().equalsIgnoreCase("gma")) {
                if (!(args.length >= 1)) {
                    if (p.hasPermission("cessentials.gamemode.adventure")) {
                        p.setGameMode(GameMode.ADVENTURE);
                    } else {
                        p.sendMessage(ChatColor.RED + "No permission!");
                    }
                } else {
                    if (p.hasPermission("cessentials.gamemode.adventure.others")) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            target.setGameMode(GameMode.ADVENTURE);
                        } else {
                            p.sendMessage(ChatColor.RED + "Player not found!");
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "No permission!");
                    }
                }
            }
            if (cmd.getName().equalsIgnoreCase("gmsp")) {
                if (!(args.length >= 1)) {
                    if (p.hasPermission("cessentials.gamemode.spectator")) {
                        p.setGameMode(GameMode.SPECTATOR);
                    } else {
                        p.sendMessage(ChatColor.RED + "No permission!");
                    }
                } else {
                    if (p.hasPermission("cessentials.gamemode.spectator.others")) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            target.setGameMode(GameMode.SPECTATOR);
                        } else {
                            p.sendMessage(ChatColor.RED + "Player not found!");
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "No permission!");
                    }
                }
            }
        }
        return false;
    }
}
