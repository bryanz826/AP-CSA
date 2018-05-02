package com.entity.mobile.powerups.types;

import com.entity.mobile.powerups.PowerUp;

public class LegendaryUp extends PowerUp
{
	public LegendaryUp(double x, double y)
	{
		super(x, y);
		setImage("legendary_powerup.png");
	}

	@Override
	public String getName() {
		return "LEGENDARYUP";
	}
}
