package io.github.praeluceantboreus.theshipitems.main;

import io.github.praeluceantboreus.theshipitems.items.TheShipItem;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class TheShipItemsPlugin extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		genConfig();
		super.onEnable();
	}

	private void genConfig()
	{
		getConfig().addDefault("items.pistol.type", TheShipItem.Type.SHOT_WEAPON.toString());
		getConfig().addDefault("items.pistol.name", "Revolver");
		getConfig().addDefault("items.pistol.damage", 10);
		getConfig().addDefault("items.pistol.material", Material.ARROW.toString());

		getConfig().options().copyDefaults(true);
		saveConfig();
	}
}
