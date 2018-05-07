package com.entity.mobile.live.alien.types;

import com.entity.mobile.ammo.alien.Storage;
import com.entity.mobile.live.alien.Alien;

public class Hard extends Alien
{
	public Hard(double x, double y, double terminal_dx, double terminal_dy, int tag)
	{
		this(x, y, 40, 40, terminal_dx, terminal_dy, tag);
	}

	public Hard(double x, double y, double w, double h, double terminal_dx, double terminal_dy, int tag)
	{
		super(x, y, w, h, terminal_dx, terminal_dy, 10, 3, 1000, tag);
		setImage("alien.png");
		setFrequency(60);
	}

	@Override
	public void shoot(Storage storage, int timer) {
		storage.yellowMissile(this, timer);
	}

	@Override
	public String getName() {
		return "HARD";
	}
}
