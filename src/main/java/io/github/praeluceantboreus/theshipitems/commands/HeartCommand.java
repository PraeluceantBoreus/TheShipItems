package io.github.praeluceantboreus.theshipitems.commands;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HeartCommand implements Command
{

	@Override
	public boolean runCommand(CommandSender sender, ArrayList<String> arguments)
	{
		if (arguments == null)
			return false;
		if (arguments.size() < 1)
			return false;
		Player player = (Player) sender;
		double modifier = Double.parseDouble(arguments.get(0));
		player.setHealthScale(modifier);
		return true;
	}

}
