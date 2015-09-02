package io.github.praeluceantboreus.theshipitems.commands;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;

public interface Command
{
	public boolean runCommand(CommandSender sender, ArrayList<String> arguments);
}
