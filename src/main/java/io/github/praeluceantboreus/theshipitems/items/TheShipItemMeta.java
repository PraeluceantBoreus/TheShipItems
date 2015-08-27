package io.github.praeluceantboreus.theshipitems.items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import com.avaje.ebean.config.dbplatform.HsqldbPlatform;

public class TheShipItemMeta implements ItemMeta
{

	@Override
	public Map<String, Object> serialize()
	{
		throw new IllegalAccessError("not implemented!");
	}

	@Override
	public boolean addEnchant(Enchantment arg0, int arg1, boolean arg2)
	{
		throw new IllegalAccessError("not implemented!");
	}

	@Override
	public void addItemFlags(ItemFlag... arg0)
	{
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasLore()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEnchant(Enchantment arg0)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeItemFlags(ItemFlag... arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisplayName(String arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLore(List<String> arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Spigot spigot()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
