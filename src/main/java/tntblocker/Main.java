package tntblocker;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tntblocker.Command;
import tntblocker.EventListener;

public class Main extends JavaPlugin {
    public static Main plugin;

    public void onEnable() {
        plugin = this;
        System.out.println("TnTBlocker by alex3025 - ENABLED!");
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
        this.getCommand("tntblocker").setExecutor(new Command());
    }

    public void onDisable() {
        System.out.println("TnTBlocker by alex3025 - DISABLED!");
    }

    public static Main getInstance() {
        return plugin;
    }
}

