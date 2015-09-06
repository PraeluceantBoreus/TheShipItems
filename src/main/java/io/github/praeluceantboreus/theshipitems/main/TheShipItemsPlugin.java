package io.github.praeluceantboreus.theshipitems.main;

import java.util.ArrayList;
import java.util.Arrays;

import io.github.praeluceantboreus.theshipitems.commands.GiveCommand;
import io.github.praeluceantboreus.theshipitems.commands.HeartCommand;
import io.github.praeluceantboreus.theshipitems.items.ItemFactory;
import io.github.praeluceantboreus.theshipitems.items.TheShipItem;
import io.github.praeluceantboreus.theshipitems.items.properties.TheShipWeaponOption;
import io.github.praeluceantboreus.theshipitems.listener.TheShipWeaponUseListener;
import io.github.praeluceantboreus.theshipitems.manager.ItemMetaTagManager;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class TheShipItemsPlugin extends JavaPlugin
{
	private io.github.praeluceantboreus.theshipitems.commands.Command giveCommand;
	private ItemFactory factory;
	private ItemMetaTagManager manager;

	@Override
	public void onEnable()
	{
		genConfig();

		manager = new ItemMetaTagManager();
		factory = new ItemFactory(this, manager);
		giveCommand = new GiveCommand(this, factory);

		getServer().getPluginManager().registerEvents(new TheShipWeaponUseListener(manager, this, factory), this);

		super.onEnable();
	}

	private void genConfig()
	{
		getConfig().options().header("generated by " + this.getDescription().getName() + " " + this.getDescription().getVersion());
		getConfig().options().copyHeader(true);

		getConfig().addDefault("standardsection", "standard");
		
		getConfig().addDefault("items.standard.pistol." + TheShipWeaponOption.TYPE, TheShipItem.Type.SHOT_WEAPON.toString());
		getConfig().addDefault("items.standard.pistol." + TheShipWeaponOption.NAME, "Revolver");
		getConfig().addDefault("items.standard.pistol." + TheShipWeaponOption.DESCRIPTION, "Das ist ein Revolver");
		getConfig().addDefault("items.standard.pistol." + TheShipWeaponOption.DAMAGE, 10);
		getConfig().addDefault("items.standard.pistol." + TheShipWeaponOption.MATERIAL, Material.ARROW.toString());
		getConfig().addDefault("items.standard.pistol." + TheShipWeaponOption.MUNITION, 20);
		getConfig().addDefault("items.standard.pistol." + TheShipWeaponOption.THROW_DAMAGE, 30);

		getConfig().addDefault("items.standard.dolch." + TheShipWeaponOption.TYPE, TheShipItem.Type.WEAPON.toString());
		getConfig().addDefault("items.standard.dolch." + TheShipWeaponOption.NAME, "Dolch");
		getConfig().addDefault("items.standard.dolch." + TheShipWeaponOption.DESCRIPTION, "Das ist ein Dolch");
		getConfig().addDefault("items.standard.dolch." + TheShipWeaponOption.DAMAGE, 10);
		getConfig().addDefault("items.standard.dolch." + TheShipWeaponOption.MATERIAL, Material.REDSTONE_TORCH_ON.toString());
		getConfig().addDefault("items.standard.dolch." + TheShipWeaponOption.THROW_DAMAGE, 30);

		for (TheShipWeaponOption tswo : TheShipWeaponOption.values())
		{
			getConfig().addDefault("lang." + tswo.toString(), tswo.getDisplayName());
			getConfig().addDefault("types." + tswo.toString() + ".shown", true);
		}
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		ArrayList<String> arguments = new ArrayList<>(Arrays.asList(args));
		if (!label.equalsIgnoreCase("tsi"))
			return super.onCommand(sender, command, label, args);
		if (arguments.size() < 1)
			return false;
		switch (arguments.get(0))
		{
		case "give":
		{
			return giveCommand.runCommand(sender, removeElemts(arguments, 1));
		}
		case "heart":
		{
			return new HeartCommand().runCommand(sender, removeElemts(arguments, 1));
		}
		default:
		{
			return false;
		}
		}
	}

	public static ArrayList<String> removeElemts(ArrayList<String> arguments, int amount)
	{
		@SuppressWarnings("unchecked")
		ArrayList<String> ret = (ArrayList<String>) arguments.clone();
		for (int i = 0; i < amount; i++)
			ret.remove(0);
		return ret;
	}

	public ItemFactory getItemFactory()
	{
		return factory;
	}
}
