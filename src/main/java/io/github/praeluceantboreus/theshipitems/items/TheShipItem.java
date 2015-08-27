package io.github.praeluceantboreus.theshipitems.items;

public interface TheShipItem
{
	public String getName();

	public double getDamageCause();

	public static enum Type
	{
		WEAPON, SHOT_WEAPON, HEAL_ITEM
	}
}
