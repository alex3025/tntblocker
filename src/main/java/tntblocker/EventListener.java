package tntblocker;

import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EventListener implements Listener {

	@EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof TNTPrimed) {
        	Entity source = ((TNTPrimed) entity).getSource();

        	if (source != null) {
        		if (source.hasPermission("tntblocker.destroy") || source.isOp()) {
            		// Nothing!
            	} else {
                    event.setCancelled(true);
            	}
        	}
        }
    }
}

