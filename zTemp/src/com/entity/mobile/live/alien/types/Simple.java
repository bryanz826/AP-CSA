package com.entity.mobile.live.alien.types;

import com.entity.mobile.ammo.alien.Storage;
import com.entity.mobile.live.alien.Alien;

public class Simple extends Alien
{
	public Simple(double x, double y, double terminal_dx, double terminal_dy, int tag)
	{
		this(x, y, 25, 25, terminal_dx, terminal_dy, tag);
	}

	public Simple(double x, double y, int w, int h, double terminal_dx, double terminal_dy, int tag)
	{
		super(x, y, w, h, terminal_dx, terminal_dy, 1, 1, 100, tag);
		setImage("alien.png");
		setFrequency(100);
	}

	@Override
	public void shoot(Storage storage, int timer) {
		storage.redMissile(this, timer);
	}

	@Override
	public String getName() {
		return "SIMPLE";
	}
}
