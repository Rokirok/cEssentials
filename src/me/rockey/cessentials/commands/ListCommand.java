package me.rockey.cessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("list")) {
			if (sender.hasPermission(cmd.getPermission())) {
				
				StringBuilder homo = new StringBuilder();
				
				for (Player p : Bukkit.getOnlinePlayers()) {
					homo.append("&a");
					homo.append(p.getName());
					homo.append("&7, ");
				}
				
				String finalhomo = homo.toString();
				
				sender.sendMessage("&7Online players (&a" + Bukkit.getOnlinePlayers().size() +  "&7): " + finalhomo);
				
				
			} else {
				sender.sendMessage("§cNo permission!");
			}
		}
		return false;
	}

}
