

package info.plugmania.EduMania;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor {
	EduMania plugin;
	public CommandHandler(EduMania instance) {
		plugin = instance;
		}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
				return false;
			}
}
