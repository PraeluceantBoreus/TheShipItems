package io.github.praeluceantboreus.theshipitems.items;

public class TheShipItemKey implements Comparable<TheShipItemKey>
{
	private String name, id;
	private boolean inDescrition;

	public TheShipItemKey(String id)
	{
		this(id, id, true);

	}

	public TheShipItemKey(String name, String id, boolean inDescrition)
	{
		super();
		if (id == null)
			throw new IllegalArgumentException("id must not be null!");
		if (name == null)
			name = id;
		this.name = name;
		this.id = id;
		this.inDescrition = inDescrition;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		if (name == null)
			name = getId();
		this.name = name;
	}

	public boolean isInDescrition()
	{
		return inDescrition;
	}

	public void setInDescrition(boolean inDescrition)
	{
		this.inDescrition = inDescrition;
	}

	public String getId()
	{
		return id;
	}

	@Override
	public int compareTo(TheShipItemKey o)
	{
		if (o == null)
			return 0;
		if (o.getId() == null)
			return 0;
		return getId().compareTo(o.getId());
	}

	@Override
	public boolean equals(Object o)
	{
		if (o == null || !(o instanceof TheShipItemKey))
			return false;
		return this.compareTo((TheShipItemKey) o) == 0;
	}

	@Override
	public String toString()
	{
		return "TheShipItemKey [name=" + name + ", id=" + id + ", inDescrition=" + inDescrition + "]";
	}
}
