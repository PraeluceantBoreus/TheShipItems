package io.github.praeluceantboreus.theshipitems.listener.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;

public class TheShipItemEvent extends PlayerEvent
{
	private static final HandlerList handlers = new HandlerList();
	private Entity target;
	private ItemStack weapon;

	public TheShipItemEvent(Player who, Entity target, ItemStack weapon)
	{
		super(who);
		this.target = target;
		this.weapon = weapon;
	}

	@Override
	public HandlerList getHandlers()
	{
		return handlers;
	}

	public Entity getTarget()
	{
		return target;
	}

	public ItemStack getWeapon()
	{
		return weapon;
	}
}
