package io.github.praeluceantboreus.theshipitems.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

public class TheShipItemMeta implements ItemMeta
{

	private String displayName, description;
	private HashSet<ItemFlag> flags;
	private HashMap<TheShipItemKey, String> additionalData;

	public TheShipItemMeta(String displayName, String description)
	{
		this.displayName = displayName;
		this.description = description;
		flags = new HashSet<>();
		additionalData = new HashMap<>();
	}

	public HashMap<TheShipItemKey, String> getAddData()
	{
		return additionalData;
	}

	private TheShipItemMeta(String displayName, String description, HashSet<ItemFlag> flags, HashMap<TheShipItemKey, String> additionalData)
	{
		super();
		this.displayName = displayName;
		this.description = description;
		this.flags = flags;
		this.additionalData = additionalData;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getDescription()
	{
		return description;
	}

	public String getAdditionalData(String key)
	{
		TheShipItemKey argKe = new TheShipItemKey(key);
		for (TheShipItemKey itemkey : additionalData.keySet())
			if (itemkey.equals(argKe))
				return additionalData.get(itemkey);
		return "NULL";
	}

	public boolean hasAdditionalData(String key)
	{
		return additionalData.containsKey(new TheShipItemKey(key));
	}

	public void setAdditionalData(String key, String value)
	{
		remove(key);
		additionalData.put(new TheShipItemKey(key), value);
	}

	public void setAdditionalData(TheShipItemKey key, String value)
	{
		additionalData.put(key, value);
	}

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

	@SuppressWarnings("unchecked")
	@Override
	public ItemMeta clone()
	{
		return new TheShipItemMeta(displayName, description, (HashSet<ItemFlag>) flags.clone(), (HashMap<TheShipItemKey, String>) additionalData.clone());
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
		ArrayList<String> ret = new ArrayList<>();
		if (getDescription() != null)
			ret.add(getDescription());
		for (TheShipItemKey tsi : additionalData.keySet())
			ret.add(tsi.getName() + ": " + additionalData.get(tsi));
		return ret;
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

	@Override
	public String toString()
	{
		return "TheShipItemMeta [displayName=" + displayName + ", description=" + description + ", flags=" + flags + ", additionalData=" + additionalData + "]";
	}

	public void remove(String id)
	{
		for (Iterator<Map.Entry<TheShipItemKey, String>> it = additionalData.entrySet().iterator(); it.hasNext();)
			if (it.next().getKey().getId().equalsIgnoreCase(id))
				it.remove();
	}
}
