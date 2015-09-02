package io.github.praeluceantboreus.theshipitems.items;

public interface TheShipItem
{
	public String getName();

	public static enum Type
	{
		WEAPON, SHOT_WEAPON, HEAL_ITEM
	}
}
