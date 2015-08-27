package io.github.praeluceantboreus.theshipitems.items;

public class ShotWeapon implements TheShipItem
{
	private double damageCause;
	private String name;
	private int munition;

	@Override
	public double getDamageCause()
	{
		return damageCause;
	}

	@Override
	public String getName()
	{
		return name;
	}

	public int getMunition()
	{
		return munition;
	}
}
