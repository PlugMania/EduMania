package info.plugmania.EduMania;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class EduMania extends JavaPlugin {
	public Logger log = Logger.getLogger("Minecraft");
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerListener(this), this);
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return false;
	}
	
	public void onDisable() {
		saveConfig();
	}
}
