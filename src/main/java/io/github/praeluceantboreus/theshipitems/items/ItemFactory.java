package io.github.praeluceantboreus.theshipitems.items;

import io.github.praeluceantboreus.theshipitems.main.TheShipItemsPlugin;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemFactory
{
	private TheShipItemsPlugin plugin;

	public ItemFactory(TheShipItemsPlugin plugin)
	{
		this.plugin = plugin;
	}

	public ItemStack getItemStackFromID(String id)
	{
		ItemStack ret = new ItemStack(Material.AIR);
		String call = "items." + id + ".";
		ret.setType(Material.valueOf(plugin.getConfig().getString(call+"material")));
		return ret;
	}
}
