package pl.iberioncraft.welcome;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Messenger{
	private FileManager fileManager;
	List<String> msgs = new ArrayList<String>();
	boolean blockVanillaMsgs = true;
	private Plugin plugin;
	
	private JoinListener onJoin;
	private ExitListener onExit;
	
	Messenger(Plugin plugin, FileManager fileManager){
		this.plugin = plugin;
		this.fileManager = fileManager;
	}
	
	void initalizeMessages(){
		if(!fileManager.getConfig().isSet("Messages")){
			Bukkit.getServer().getConsoleSender().sendMessage("§7[§bAnotherGreatWelcome§7] Messages section was not found in config.");
			return;
		}else{
			msgs = fileManager.getConfig().getStringList("Messages");
		}
		if(!fileManager.getConfig().isSet("BlockVanillaJoinExitMessage")){
			Bukkit.getServer().getConsoleSender().sendMessage("§7[§bAnotherGreatWelcome§7] BlockVanillaJoinExitMessage field was not found in the config.");
			blockVanillaMsgs = true;
		}else{
			blockVanillaMsgs = fileManager.getConfig().getBoolean("BlockVanillaJoinExitMessage");
		}
		
		onJoin = new JoinListener(this);
		onJoin.registerThisListener(plugin);
		
		if(blockVanillaMsgs){
			onExit = new ExitListener();
			onExit.unregisterThisListener();
		}
	}
	
	void reload(){
		onJoin.unregisterThisListener();
		if(onExit!=null) onExit.unregisterThisListener();
		
		fileManager.reloadConfig();
		
		initalizeMessages();
	}
}
