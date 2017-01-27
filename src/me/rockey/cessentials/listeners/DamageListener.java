package me.rockey.cessentials.listeners;

import me.rockey.cessentials.core.CustomEssentials;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;

public class DamageListener implements Listener {

    private ArrayList<Player> godList = CustomEssentials.god;

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (godList.contains(p)) {
                e.setCancelled(true);
            }
        }
    }
}
