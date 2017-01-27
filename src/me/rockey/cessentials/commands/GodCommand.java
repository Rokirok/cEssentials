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
                    if (p.hasPermission(cmd.getPermission())) {
                        if (godList.contains(p)) {
                            godList.remove(p);
                            p.sendMessage("Message!");
                            return true;
                        } else if (!(godList.contains(p))) {
                            godList.add(p);
                            p.sendMessage("Message!");
                            return true;
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + "No permission!");
                    }
                } else {
                    if (p.hasPermission(cmd.getPermission() + ".others")) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            if (godList.contains(target)) {
                                godList.remove(target);
                                target.sendMessage("Message!");
                                p.sendMessage("Message!");
                                return true;
                            } else if (!(godList.contains(p))) {
                                godList.add(target);
                                target.sendMessage("Message!");
                                p.sendMessage("Message!");
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
        }
        return false;
    }
}
