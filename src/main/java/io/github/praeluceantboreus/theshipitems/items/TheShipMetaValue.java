package io.github.praeluceantboreus.theshipitems.items;

import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class TheShipMetaValue implements MetadataValue
{
	private TheShipItemMeta meta;
	private Plugin plugin;
	private ItemStack item;

	public ItemStack getItem()
	{
		return item;
	}

	public void setItem(ItemStack item)
	{
		this.item = item;
	}

	public TheShipMetaValue(TheShipItemMeta meta, ItemStack item, Plugin plugin)
	{
		this.meta = meta;
		this.plugin = plugin;
		this.item = item;
	}

	@Override
	public boolean asBoolean()
	{
		return false;
	}

	@Override
	public byte asByte()
	{
		return 0;
	}

	@Override
	public double asDouble()
	{
		return 0;
	}

	@Override
	public float asFloat()
	{
		return 0;
	}

	@Override
	public int asInt()
	{
		return 0;
	}

	@Override
	public long asLong()
	{
		return 0;
	}

	@Override
	public short asShort()
	{
		return 0;
	}

	@Override
	public String asString()
	{
		return meta.toString();
	}

	@Override
	public Plugin getOwningPlugin()
	{
		return plugin;
	}

	@Override
	public void invalidate()
	{

	}

	@Override
	public TheShipItemMeta value()
	{
		return meta;
	}

}
