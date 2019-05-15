package pl.iberioncraft.welcome;

import java.util.Random;

import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class JoinListener implements Listener{
	private Messenger messenger;
	
	JoinListener( Messenger messenger){
		this.messenger = messenger;
	}
	
	void registerThisListener(Plugin plugin){
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	void unregisterThisListener(){
		HandlerList.unregisterAll(this);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		if(messenger.blockVanillaMsgs) e.setJoinMessage(null);
		if(!e.getPlayer().hasPlayedBefore()){
			String message = messenger.msgs.get(this.getRandInt(0, (messenger.msgs.size()-1))).replaceAll("%player%", e.getPlayer().getName()).replaceAll("&", "§");
			Bukkit.broadcastMessage(message);
		}
	}
	
	
	private static final Random RAND = new Random();
	private int getRandInt(int min, int max) throws IllegalArgumentException { 
		Validate.isTrue(max >= min, "Minimum value cannot be greater than maximum!");
		return RAND.nextInt(max - min + 1) + min;
	}
	
}
