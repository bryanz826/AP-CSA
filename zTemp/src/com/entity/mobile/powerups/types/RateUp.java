package com.entity.mobile.powerups.types;

import com.entity.mobile.powerups.PowerUp;

public class RateUp extends PowerUp
{
	public RateUp(double x, double y)
	{
		super(x, y);
		setImage("rate_powerup.png");
	}

	@Override
	public String getName() {
		return "RATEUP";
	}
}
