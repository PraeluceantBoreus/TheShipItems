package io.github.praeluceantboreus.theshipitems.items;

public class HealItem implements TheShipItem
{
	private double damageCause;
	private String name;

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
}
