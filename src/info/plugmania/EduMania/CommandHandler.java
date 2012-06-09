

package info.plugmania.EduMania;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandHandler{
	EduMania plugin;
	public CommandHandler(EduMania instance) {
		plugin = instance;
		}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
				if(command.getName().equalsIgnoreCase("auth")){
					
				}
				return true;
			}
}
