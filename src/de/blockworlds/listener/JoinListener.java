package de.blockworlds.listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

	    public boolean isAvailable;

	    @EventHandler
	    public void on(PlayerJoinEvent event) {
	        if(event.getPlayer().hasPermission("bw.perm.notification")) {
	            if(isAvailable) {
	            	event.getPlayer().sendMessage(" ");
	                event.getPlayer().sendMessage("§7[§cBlockWorlds§7] §aA NEW UPDATE IS AVAILABLE!");
	                event.getPlayer().sendMessage("§7[§cBlockWorlds§7] §cDownload: §bhttps://www.spigotmc.org/resources/1-16-x-blockworlds-by-gibmirrechte.87743/");
	            }
	            }
	        }
}