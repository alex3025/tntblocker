package tntblocker;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import tntblocker.Command;
import tntblocker.EventListener;

public class Main extends JavaPlugin {
    public static Main plugin;
    static ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

    public void onEnable() {
        plugin = this;
        console.sendMessage("§8§l[§cTnT§fBlocker§8§l]§r §aENABLED!");
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
        this.getCommand("tntblocker").setExecutor(new Command());
        saveDefaultConfig();
    }

    public void onDisable() {
    	console.sendMessage("§8§l[§cTnT§fBlocker§8§l]§r§c DISABLED!");
    }

    public static Main getInstance() {
        return plugin;
    }
}

