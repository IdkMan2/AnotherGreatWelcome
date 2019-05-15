package pl.iberioncraft.welcome;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class ExitListener implements Listener{
	//private Messenger messenger;
	
	/*ExitListener( Messenger messenger){
		this.messenger = messenger;
	}*/
	
	void registerThisListener(Plugin plugin){
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	void unregisterThisListener(){
		HandlerList.unregisterAll(this);
	}
	
	
	@EventHandler
	public void onExit(PlayerQuitEvent e){
		e.setQuitMessage(null);
	}
}
