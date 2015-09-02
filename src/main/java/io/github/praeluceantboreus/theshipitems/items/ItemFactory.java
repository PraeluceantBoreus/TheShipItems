package io.github.praeluceantboreus.theshipitems.items;

import io.github.praeluceantboreus.theshipitems.items.properties.TheShipWeaponOption;
import io.github.praeluceantboreus.theshipitems.main.TheShipItemsPlugin;
import io.github.praeluceantboreus.theshipitems.manager.ItemMetaTagManager;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemFactory
{
	private TheShipItemsPlugin plugin;
	private ItemMetaTagManager manager;

	public ItemFactory(TheShipItemsPlugin plugin, ItemMetaTagManager manager)
	{
		this.plugin = plugin;
		this.manager = manager;
	}

	public ItemStack getItemStackFromID(String id)
	{
		ItemStack ret = new ItemStack(Material.AIR);
		String call = "items." + id + ".";
		ConfigurationSection itemConf = plugin.getConfig().getConfigurationSection(call);
		ret.setType(Material.valueOf(itemConf.getString(TheShipWeaponOption.MATERIAL.toString())));
		TheShipItemMeta meta = new TheShipItemMeta(itemConf.getString(TheShipWeaponOption.NAME.toString()), itemConf.getString(TheShipWeaponOption.DESCRIPTION.toString()));
		meta.setAdditionalData(TheShipWeaponOption.DAMAGE.toString(), itemConf.getString(TheShipWeaponOption.DAMAGE.toString()));
		meta.setAdditionalData(TheShipWeaponOption.TYPE.toString(), itemConf.getString(TheShipWeaponOption.TYPE.toString()));
		meta.setAdditionalData(TheShipWeaponOption.MATERIAL.toString(), itemConf.getString(TheShipWeaponOption.MATERIAL.toString()));
		meta.setAdditionalData(TheShipWeaponOption.ID.toString(), id);
		meta.setAdditionalData(TheShipWeaponOption.MUNITION.toString(), itemConf.getString(TheShipWeaponOption.MUNITION.toString()));
		// ret.setItemMeta(meta);
		ItemMeta itemmeta = Bukkit.getItemFactory().getItemMeta(ret.getType());
		itemmeta.setDisplayName(itemConf.getString(TheShipWeaponOption.NAME.toString()));
		ret.setItemMeta(itemmeta);
		manager.registerItemStack(ret, meta);
		updateLore(ret, null);
		return ret;
	}

	public void updateLore(ItemStack item, Player player)
	{
		TheShipItemMeta meta = manager.getMeta(item);
		manager.deregisterItemStack(item);
		String call = "items." + meta.getAdditionalData(TheShipWeaponOption.ID.toString()) + ".";
		ConfigurationSection itemConf = plugin.getConfig().getConfigurationSection(call);
		ItemMeta itemmeta = item.getItemMeta();
		ArrayList<String> lore = new ArrayList<>();
		lore.add(itemConf.getString(TheShipWeaponOption.DESCRIPTION.toString()));
		for (TheShipItemKey key : meta.getAddData().keySet())
			if (plugin.getConfig().getBoolean("types." + key.getId() + ".shown"))
				lore.add(plugin.getConfig().getString("lang." + key.getId()) + ": " + meta.getAdditionalData(key.getId()));
		itemmeta.setLore(lore);
		if (player != null)
			player.closeInventory();
		item.setItemMeta(itemmeta);
		if (player != null)
			player.updateInventory();
		manager.registerItemStack(item, meta);
	}
}
