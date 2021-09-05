package de.blockworlds.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import de.blockworlds.listener.ChatListener;
import de.blockworlds.listener.JoinListener;
import de.blockworlds.listener.WorldChangeListener;

import javax.net.ssl.HttpsURLConnection;

public class BlockWorlds extends JavaPlugin {
	
	public static ArrayList<String> blocked_worlds = new ArrayList<>();
	
	File file = new File("plugins//BlockWorlds//worlds.yml");
	YamlConfiguration worlds = YamlConfiguration.loadConfiguration(file);
	
	public void onEnable() {
		if(!file.exists()) {
			List<String> list = worlds.getStringList("BlockedWorlds");
			list.add("world_nether");
			list.add("world_the_end");
			worlds.set("BlockedWorlds",list);
			try { worlds.save(file); } catch (IOException exception) {}
		}
		
		for(String w : worlds.getStringList("BlockedWorlds")) {
			blocked_worlds.add(w);
		}
		
		Bukkit.getPluginManager().registerEvents(new WorldChangeListener(), this);
		Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
		Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("========== BlockWorlds ==========");
		System.out.println(" ");
		System.out.println("Author: GibMirRechte");
		System.out.println("Version: " + Bukkit.getPluginManager().getPlugin("BlockWorlds").getDescription().getVersion());
		System.out.println("Discord: cbcWksB");
		System.out.println(" ");
		System.out.println("========== BlockWorlds ==========");
	}

	public void check() {
		JoinListener joinListener = new JoinListener();
		joinListener.isAvailable = checkUpdate();
	}

	public boolean checkUpdate() {
		String url = "https://api.spigotmc.org/legacy/update.php?resource=";
		String id = "87743";
		System.out.println("§7[§cBlockWorlds§7] §aChecking for updates...");
		try {
			String localVersion = Bukkit.getPluginManager().getPlugin("BlockWorlds").getDescription().getVersion();
			HttpsURLConnection connection = (HttpsURLConnection) new URL(url + id).openConnection();
			connection.setRequestMethod("GET");
			String raw = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();

			String remoteVersion;
			if(raw.contains("-")) {
				remoteVersion = raw.split("-")[0].trim();
			} else {
				remoteVersion = raw;
			}

			if(!localVersion.equalsIgnoreCase(remoteVersion))
				return true;

		} catch (IOException e) {
			return false;
		}
		return false;
	}
}
