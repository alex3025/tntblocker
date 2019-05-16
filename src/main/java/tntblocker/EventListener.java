package tntblocker;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EventListener implements Listener {

	@EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof TNTPrimed) {
        	Entity source = ((TNTPrimed) entity).getSource();

        	if (source != null) {
        		if (!source.isOp() || !source.hasPermission("tntblocker.grief")) {
        			if (!Boolean.parseBoolean(Main.getInstance().getConfig().getString("allow-tnt-grief"))) {
        				event.setCancelled(true);
	            	} else {
	                    event.setCancelled(false);
	            	}
        		}
        	}
        }
	}
	
	@EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
		Player source = event.getPlayer();
		
		if (source != null) {
    		if (!source.isOp() || !source.hasPermission("tntblocker.place")) {
    			if (!Boolean.parseBoolean(Main.getInstance().getConfig().getString("allow-tnt-placing"))) {
    				if (event.getBlock().getType() == Material.TNT) {
    					event.setCancelled(true);
    					if (Boolean.parseBoolean(Main.getInstance().getConfig().getString("placing-warning"))) {
    						Main.console.sendMessage("§8§l[§cTnT§fBlocker§8§l]§r§f " + source.getName() + "§c tried to place a tnt at §f" + Math.round(source.getLocation().getX()) + " §c/§f " + Math.round(source.getLocation().getY()) + " §c/§f " + Math.round(source.getLocation().getZ()));
    					}
	                } else {
	                    event.setCancelled(false);
	                }
    			}
    			
    		}
		}
	}
	
	@EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof TNTPrimed) {
        	if (Boolean.parseBoolean(Main.getInstance().getConfig().getString("allow-tnt-damage"))) {
        		event.setCancelled(false);
        	} else {
        		event.setCancelled(true);
        	}
        }
    }
}

