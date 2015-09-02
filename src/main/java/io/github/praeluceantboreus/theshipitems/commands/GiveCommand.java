package io.github.praeluceantboreus.theshipitems.commands;

import io.github.praeluceantboreus.theshipitems.items.ItemFactory;
import io.github.praeluceantboreus.theshipitems.main.TheShipItemsPlugin;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveCommand implements Command
{
	// private TheShipItemsPlugin plugin;
	private ItemFactory factory;

	public GiveCommand(TheShipItemsPlugin plugin, ItemFactory factory)
	{
		super();
		// this.plugin = plugin;
		this.factory = factory;
	}

	@Override
	public boolean runCommand(CommandSender sender, ArrayList<String> arguments)
	{
		if (arguments == null || arguments.size() < 1)
			return false;
		((Player) sender).getInventory().addItem(factory.getItemStackFromID(arguments.get(0)));
		return true;
	}

}
