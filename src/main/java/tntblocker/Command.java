package tntblocker;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Command
implements CommandExecutor {
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String commandLabel, String[] args) {
        if ((sender instanceof Player || sender instanceof ConsoleCommandSender) && cmd.getName().equalsIgnoreCase("tntblocker")) {
            sender.sendMessage("�8�l[�cTnT�fBlocker�8�l]�r�7 Version: 1.0 | This plugin was made by alex3025.");
        }
        return false;
    }
}
