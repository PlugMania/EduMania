package info.plugmania.EduMania;

import org.bukkit.entity.Player;

public class util {
	EduMania plugin;
	public util(EduMania instance) {
		plugin = instance;
		}
	
	public boolean authPlayer(Player p,String key){
		if(!plugin.authKeys.containsKey(p.getName().toLowerCase())) plugin.authKeys.put(p.getName().toLowerCase(), key);
	    if(isPlayerAuthed(p)) return true;
	    if(plugin.authKeys.get(p.getName().toLowerCase())==key){
	    	plugin.authedPlayers.add(p);
	    	return true;
	    }
	    else return false;
	}
	
	public void deAuthPlayer(Player p){
		plugin.authedPlayers.remove(p);
	}
	
	public boolean isPlayerAuthed(Player p){
		return plugin.authedPlayers.contains(p);
	}
}
