package tntblocker;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tntblocker.Command;
import tntblocker.EventListener;

public class Main extends JavaPlugin {
    public static Main plugin;
    static java.util.logging.Logger log = Bukkit.getLogger();

    public void onEnable() {
        plugin = this;
        log.info("[TntBlocker] Plugin ENABLED!");
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
        this.getCommand("tntblocker").setExecutor(new Command());
        saveDefaultConfig();
    }

    public void onDisable() {
    	log.info("[TntBlocker] Plugin DISABLED!");
    }

    public static Main getInstance() {
        return plugin;
    }
}

