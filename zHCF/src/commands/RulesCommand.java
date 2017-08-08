package commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.imarco.zhcf.Main;

public class RulesCommand implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(!sender.hasPermission("zhcf.rules")){
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().config.getString("messages.nopermission")));
			return true;
		}
		for(String rulescmd : Main.getInstance().config.getStringList("rules")){
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', rulescmd));
		}
		return false;
	}
}
