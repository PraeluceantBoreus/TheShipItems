package io.github.praeluceantboreus.theshipitems.manager;

import io.github.praeluceantboreus.theshipitems.items.TheShipItemMeta;

import java.util.HashMap;

import org.bukkit.inventory.ItemStack;

public class ItemMetaTagManager
{
	private HashMap<ItemStack, TheShipItemMeta> items;

	public ItemMetaTagManager()
	{
		items = new HashMap<>();
	}

	public TheShipItemMeta registerItemStack(ItemStack itemstack, TheShipItemMeta meta)
	{
		return items.put(itemstack, meta);
	}

	public TheShipItemMeta deregisterItemStack(ItemStack itemstack)
	{
		return items.remove(itemstack);
	}

	public boolean isTheShipItem(ItemStack itemstack)
	{
		return items.keySet().contains(itemstack);
	}

	public TheShipItemMeta getMeta(ItemStack itemstack)
	{
		return items.get(itemstack);
	}

	@Override
	public String toString()
	{
		return "ItemMetaTagManager [items=" + items + "]";
	}
}
