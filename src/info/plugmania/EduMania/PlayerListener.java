package info.plugmania.EduMania;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.block.*;

public class PlayerListener implements Listener {
	EduMania plugin;

	public PlayerListener(EduMania instance) {
		plugin = instance;
	}

	@EventHandler()
	public void onBlockBreak(BlockBreakEvent event) {
		if (!plugin.util.isPlayerAuthed(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler()
	public void onBlockPlace(BlockPlaceEvent event) {
		if (!plugin.util.isPlayerAuthed(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler()
	public void onEntityDamage(EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player))
			return;
		if (!plugin.util.isPlayerAuthed((Player) event.getEntity()))
			event.setCancelled(true);
	}

	@EventHandler()
	public void onEntityTarget(EntityTargetEvent event) {
		if (!(event.getTarget() instanceof Player))
			return;
		if (!plugin.util.isPlayerAuthed((Player) event.getEntity()))
			event.setCancelled(true);
	}

	@EventHandler()
	public void onPlayerHungerChange(FoodLevelChangeEvent event) {
		if (!(event.getEntity() instanceof Player))
			return;
		if (!plugin.util.isPlayerAuthed((Player) event.getEntity()))
			event.setCancelled(true);
	}

	@EventHandler()
	public void onPlayerChat(PlayerChatEvent event) {
		if (!plugin.util.isPlayerAuthed(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler()
	public void onPlayerCommandPreprocessEvent(
			PlayerCommandPreprocessEvent event) {
		if (plugin.util.sit(event.getMessage(), ' ', 0).equalsIgnoreCase(
				"/auth")) {

			if (!plugin.util.authPlayer(event.getPlayer(),
					plugin.util.sit(event.getMessage(), ' ', 1)))
				event.getPlayer().sendMessage(
						"[EduMania]Authentication failed.");
			else
				event.getPlayer().sendMessage(
						"[EduMania]Authentication succeeded.");

			return;
		}

		if (!plugin.util.isPlayerAuthed(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler()
	public void onPlayerBucketEmpty(
			org.bukkit.event.player.PlayerCommandPreprocessEvent event) {
		if (!plugin.util.isPlayerAuthed(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler()
	public void onPlayerBucketFill(PlayerBucketFillEvent event) {
		if (!plugin.util.isPlayerAuthed(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler()
	public void onPlayerDropItem(PlayerDropItemEvent event) {
		if (!plugin.util.isPlayerAuthed(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler()
	public void onPlayerPickupItem(PlayerPickupItemEvent event) {
		if (!plugin.util.isPlayerAuthed(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler()
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (!plugin.util.isPlayerAuthed(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler()
	public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
		if (!plugin.util.isPlayerAuthed(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler()
	public void onPlayerMoveEvent(PlayerMoveEvent event) {
		if (!plugin.util.isPlayerAuthed(event.getPlayer()))
			if (event.getFrom().getBlockX() != event.getTo().getBlockX()
					|| event.getFrom().getBlockY() != event.getTo().getBlockY()
					|| event.getFrom().getBlockZ() != event.getTo().getBlockZ()) 
			{
				event.setTo(event.getFrom());
			}
	}

	@EventHandler()
	public void onPlayerBedEnter(PlayerBedEnterEvent event) {
		if (!plugin.util.isPlayerAuthed(event.getPlayer()))
			event.setCancelled(true);
	}

	@EventHandler()
	public void onPlayerLogin(PlayerLoginEvent event) {
		// event.
	}

	@EventHandler()
	public void onPlayerKickEvent(PlayerKickEvent event) {
		plugin.util.deAuthPlayer(event.getPlayer());
	}

	@EventHandler()
	public void onPlayerQuitEvent(PlayerQuitEvent event) {
		plugin.util.deAuthPlayer(event.getPlayer());
	}

}
