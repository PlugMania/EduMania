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
	public util util = new util(this);

	public void onEnable() {
		if(!getConfig().isSet("keys")) getConfig().createSection("keys", authKeys);
		for (String s:getConfig().getConfigurationSection("keys").getKeys(false)){
			authKeys.put(s, getConfig().getConfigurationSection("keys").getString(s));
		}
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerListener(this), this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (command.getName().equalsIgnoreCase("auth")) {
		}

		return true;

	}

	public void onDisable() {
		getConfig().createSection("keys", authKeys);
		saveConfig();
	}
}
