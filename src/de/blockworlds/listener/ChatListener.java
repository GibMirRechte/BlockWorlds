package de.blockworlds.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class ChatListener implements Listener {
	
	@EventHandler
	public void onChat(PlayerCommandPreprocessEvent e) {
		if(e.getMessage().toLowerCase().startsWith("/blockworld")) {
			e.setCancelled(true);
				e.getPlayer().sendMessage("§8§m--------§c§o BlockWorlds §8§m--------");
				e.getPlayer().sendMessage(" ");
				e.getPlayer().sendMessage("§7Developer: §eGibMirRechte");
				e.getPlayer().sendMessage("§7Discord: §bhttps://discord.gg/yhBX6KT");
				e.getPlayer().sendMessage(" ");
				e.getPlayer().sendMessage("§8§m--------§c§o BlockWorlds §8§m--------");
		}
	}
}