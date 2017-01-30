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
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("feed")) {
                if (args.length < 1) {
                    if (p.hasPermission(cmd.getPermission())) {
                        p.setFoodLevel(20);
                        p.sendMessage(ChatColor.GREEN + "Your appetite is satisfied.");
                    } else {
                        p.sendMessage(ChatColor.RED + "No permission!");
                    }
                } else {
                    if (p.hasPermission(cmd.getPermission() + ".others")) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            target.setFoodLevel(20);
                            target.sendMessage(ChatColor.GREEN + "Your appetite is satisfied by " + p.getName() + ".");
                            p.sendMessage(ChatColor.GREEN + "You satisfied " + target.getName() + "'s appetite.");
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
