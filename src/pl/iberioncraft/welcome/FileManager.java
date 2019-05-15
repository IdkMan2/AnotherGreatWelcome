package pl.iberioncraft.welcome;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class FileManager {
	private File configf;
	private FileConfiguration config;
	private File dataFolder;
	
	public FileManager(File file){
		this.dataFolder = file;
	}
	public void createFiles(Plugin plugin){
		if(!dataFolder.exists()) dataFolder.mkdirs();
		
		configf = new File(dataFolder, "config.yml");
		
		if (!configf.exists()) {
			plugin.saveResource("config.yml", false);
		}
		
		config = YamlConfiguration.loadConfiguration(configf);
	}
	public FileConfiguration getConfig(){
		return this.config;
	}
	public void reloadConfig(){
		config = YamlConfiguration.loadConfiguration(configf);
	}
}
