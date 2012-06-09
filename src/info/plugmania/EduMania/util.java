package info.plugmania.EduMania;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.bukkit.entity.Player;

public class util {
	EduMania plugin;
	public util(EduMania instance) {
		plugin = instance;
		}
	
	public boolean authPlayer(Player p,String key){
		if(!plugin.authKeys.containsKey(p.getName().toLowerCase())) plugin.authKeys.put(p.getName().toLowerCase(), key);
	    if(isPlayerAuthed(p)) return true;
	    if(plugin.authKeys.get(p.getName().toLowerCase()).equals(key)){
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
	
	public String join(String[] a, String delimiter,Integer startIndex) { 
		try{
		Collection<String> s=Arrays.asList(a);
		StringBuffer buffer = new StringBuffer();
		Iterator<String> iter = s.iterator();
		
		while (iter.hasNext()) {
			if(startIndex==0){
			buffer.append(iter.next());
			if (iter.hasNext()) {
				buffer.append(delimiter);
			}
				}else{startIndex--; iter.next();}
			}
		
		return buffer.toString();
	}catch(Exception e)
	{
		e.printStackTrace();
		return "";
	}
		} 

	public String sit(String iStr,char delimiter,int part){
		if(part==0){
		if(!iStr.contains(String.valueOf(delimiter))) return iStr;
		}else{
			if(!iStr.contains(String.valueOf(delimiter))) return "";
		}
	    if(part==0) return iStr.substring(0, (iStr.indexOf(delimiter, 0)));
	    return iStr.substring(iStr.indexOf(delimiter, 0) + 1, iStr.length());
	}
}
