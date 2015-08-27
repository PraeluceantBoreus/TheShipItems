package io.github.praeluceantboreus.theshipitems.items;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

public class TheShipItemMeta implements ItemMeta
{

	private String displayName;
	private HashSet<ItemFlag> flags;

	@Override
	public Map<String, Object> serialize()
	{
		return new HashMap<>();
	}

	@Override
	public boolean addEnchant(Enchantment arg0, int arg1, boolean arg2)
	{
		throw new IllegalAccessError("not implemented!");
	}

	@Override
	public void addItemFlags(ItemFlag... arg0)
	{
		if (arg0 == null)
			return;
		for (ItemFlag itf : arg0)
			flags.add(itf);
	}

	@Override
	public ItemMeta clone()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDisplayName()
	{
		return displayName;
	}

	@Override
	public int getEnchantLevel(Enchantment arg0)
	{
		return 0;
	}

	@Override
	public Map<Enchantment, Integer> getEnchants()
	{
		return new HashMap<Enchantment, Integer>();
	}

	@Override
	public Set<ItemFlag> getItemFlags()
	{
		return flags;
	}

	@Override
	public List<String> getLore()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasConflictingEnchant(Enchantment arg0)
	{
		throw new IllegalAccessError("not implemented!");
	}

	@Override
	public boolean hasDisplayName()
	{
		return true;
	}

	@Override
	public boolean hasEnchant(Enchantment arg0)
	{
		return false;
	}

	@Override
	public boolean hasEnchants()
	{
		return true;
	}

	@Override
	public boolean hasItemFlag(ItemFlag arg0)
	{
		return flags.contains(arg0);
	}

	@Override
	public boolean hasLore()
	{
		return true;
	}

	@Override
	public boolean removeEnchant(Enchantment arg0)
	{
		throw new IllegalAccessError("not implemented!");
	}

	@Override
	public void removeItemFlags(ItemFlag... arg0)
	{
		if (arg0 != null)
			for (ItemFlag itf : arg0)
				flags.remove(itf);
	}

	@Override
	public void setDisplayName(String arg0)
	{
		this.displayName = arg0;
	}

	@Override
	public void setLore(List<String> arg0)
	{
	}

	@Override
	public Spigot spigot()
	{
		return null;
	}

}
