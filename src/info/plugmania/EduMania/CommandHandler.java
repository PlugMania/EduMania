

package info.plugmania.EduMania;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler{
	EduMania plugin;
	public CommandHandler(EduMania instance) {
		plugin = instance;
		}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
				if(command.getName().equalsIgnoreCase("auth")){
					if(!plugin.util.authPlayer((Player)sender, plugin.util.join(args, " ", 0)))((Player)sender).kickPlayer("");
				}
				return true;
			}
}
