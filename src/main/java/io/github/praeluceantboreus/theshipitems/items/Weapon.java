package io.github.praeluceantboreus.theshipitems.items;

public class Weapon implements TheShipItem
{
	private String name;
	private double damageCause;

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public double getDamageCause()
	{
		return damageCause;
	}

}
