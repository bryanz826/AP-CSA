package com.entity.mobile.live.alien.types;

import com.entity.mobile.ammo.alien.Storage;
import com.entity.mobile.live.alien.Alien;

public class Extreme extends Alien
{
	public Extreme(double x, double y, double terminal_dx, double terminal_dy, int tag)
	{
		this(x, y, 55, 55, terminal_dx, terminal_dy, tag);
	}

	public Extreme(double x, double y, double w, double h, double terminal_dx, double terminal_dy, int tag)
	{
		super(x, y, w, h, terminal_dx, terminal_dy, 50, 10, 5000, tag);
		setImage("alien.png");
		setFrequency(62);
	}

	@Override
	public void shoot(Storage storage, int timer) {
		storage.greenMissile(this, timer);
	}

	@Override
	public String getName() {
		return "EXTREME";
	}
}
