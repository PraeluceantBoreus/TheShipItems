package io.github.praeluceantboreus.theshipitems.items.properties;

public enum TheShipWeaponOption implements TheShipOption
{
	NAME("Name"), DESCRIPTION("Beschreibung"), DAMAGE("Schaden"), MATERIAL("Material"), TYPE("Itemart"), ID("Identifikation"), MUNITION("Schüsse"), THROW_DAMAGE("Wurfschaden");

	private TheShipWeaponOption(String displayName)
	{
		this.displayName = displayName;
	}

	private String displayName;

	@Override
	public String toString()
	{
		return super.toString().toLowerCase();
	}

	@Override
	public String getDisplayName()
	{
		return displayName;
	}
}
