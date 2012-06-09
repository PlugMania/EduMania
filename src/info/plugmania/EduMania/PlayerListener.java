package info.plugmania.EduMania;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
public class PlayerListener implements Listener{
	EduMania plugin;
	public PlayerListener(EduMania instance) {
		plugin = instance;
		}
	@EventHandler()
	public void onBlockBreak(org.bukkit.event.block.BlockBreakEvent event){
	
	}
	
}
