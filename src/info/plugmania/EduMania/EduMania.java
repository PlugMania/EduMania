package info.plugmania.EduMania;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class EduMania extends JavaPlugin {
	public Logger log = Logger.getLogger("Minecraft");
	public Map<String, String> authKeys = new HashMap<String, String>();
    public List<Player> authedPlayers = new ArrayList<Player>();
    public util util=new util(this);
	CommandHandler ch;
	public void onEnable() {
		ch=new CommandHandler(this);
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
