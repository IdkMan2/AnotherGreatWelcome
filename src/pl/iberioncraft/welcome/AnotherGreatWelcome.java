package pl.iberioncraft.welcome;

import org.bukkit.plugin.java.JavaPlugin;

public class AnotherGreatWelcome extends JavaPlugin{
	private FileManager fileManager;
	private Messenger messenger;
	
	@Override
	public void onEnable(){
		fileManager = new FileManager(this.getDataFolder());
		fileManager.createFiles(this);
		
		messenger = new Messenger(this, fileManager);
		messenger.initalizeMessages();
	}
	
	
}
