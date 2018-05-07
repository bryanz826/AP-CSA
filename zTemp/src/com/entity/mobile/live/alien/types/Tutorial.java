package com.entity.mobile.live.alien.types;

import com.entity.mobile.ammo.alien.Storage;
import com.entity.mobile.live.alien.Alien;

public class Tutorial extends Alien
{
	public Tutorial(double x, double y, double terminal_dx, double terminal_dy, int tag)
	{
		this(x, y, 25, 25, terminal_dx, terminal_dy, tag);
	}

	public Tutorial(double x, double y, int w, int h, double terminal_dx, double terminal_dy, int tag)
	{
		super(x, y, w, h, terminal_dx, terminal_dy, 1, 0, 100, tag);
		setImage("alien.png");
	}

	@Override
	public void shoot(Storage storage, int timer) {}

	@Override
	public String getName() {
		return "TUTORIAL";
	}
}
