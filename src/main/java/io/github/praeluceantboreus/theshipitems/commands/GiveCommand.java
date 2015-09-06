package io.github.praeluceantboreus.theshipitems.commands;

import io.github.praeluceantboreus.theshipitems.items.ItemFactory;
import io.github.praeluceantboreus.theshipitems.main.TheShipItemsPlugin;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
		if (arguments == null || arguments.size() < 2)
			return false;
		ItemStack stack;
		if (arguments.get(0).contains("."))
			stack = factory.getItemStackFromID(arguments.get(1).split(".")[0], arguments.get(1).split(".")[1]);
		else
			stack = factory.getItemStackFromID(arguments.get(1));
		Player player = Bukkit.getPlayer(arguments.get(0));
		if (player == null)
			return false;
		player.getInventory().addItem(stack);
		return true;
	}

}
