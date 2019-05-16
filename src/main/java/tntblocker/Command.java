package tntblocker;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class Command
implements CommandExecutor {
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String commandLabel, String[] args) {
        if ((sender instanceof Player || sender instanceof ConsoleCommandSender) && cmd.getName().equalsIgnoreCase("tntblocker")) {
        	if (args.length == 0) {
        		PluginDescriptionFile pdf = Main.getInstance().getDescription();
                sender.sendMessage("§8§l-=[ §cTnT§fBlocker§8§l ]=-§r§7");
                sender.sendMessage("");
                sender.sendMessage("§7Version: §a" + pdf.getVersion());
                sender.sendMessage("§7Credits: §aalex3025");
                sender.sendMessage("");
                if (sender.isOp() || sender.hasPermission("tntblocker.reload")) {
	                sender.sendMessage("§a/tntblocker reload§7 - Reloads the config.");
	                sender.sendMessage("");
                }
                sender.sendMessage("§8§l-=[ §cTnT§fBlocker§8§l ]=-§r§7");
        	} else if (args.length == 1) {
        		if (args[0].equalsIgnoreCase("reload")) {
        			if (sender.isOp() || sender.hasPermission("tntblocker.reload")) {
        				Main.getInstance().reloadConfig();
        				sender.sendMessage("§8§l[§cTnT§fBlocker§8§l]§r§a Config reloaded!");
        			} else {
        				sender.sendMessage("§8§l[§cTnT§fBlocker§8§l]§r§c You don't have permission!");
        			}
        		} else {
        			sender.sendMessage("§8§l[§cTnT§fBlocker§8§l]§r§c Unknow command!");
        		}
        	}
        }
		return false;
    }
}

