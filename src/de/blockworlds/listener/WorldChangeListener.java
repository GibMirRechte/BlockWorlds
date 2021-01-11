package de.blockworlds.listener;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class WorldChangeListener implements Listener {
	
	File file = new File("plugins//BlockWorlds//worlds.yml");
	YamlConfiguration worlds = YamlConfiguration.loadConfiguration(file);
	
	@EventHandler
	public void onWorldChange(PlayerChangedWorldEvent event) {
		if(worlds.getStringList("BlockedWorlds").contains(event.getPlayer().getWorld().getName())) {
			event.getPlayer().teleport(event.getFrom().getSpawnLocation());
			event.getPlayer().sendMessage("§7[§cBlockWorlds§7] §cThis world is blocked.");
			event.getPlayer().sendMessage("§7[§cBlockWorlds§7] §cYou have been send back!");
		}
	}

}
