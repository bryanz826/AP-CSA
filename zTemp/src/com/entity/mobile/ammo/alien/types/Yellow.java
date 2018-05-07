package com.entity.mobile.ammo.alien.types;

import com.animations.types.ConstantAnimation;
import com.entity.mobile.ammo.alien.Missile;

import coc.utils.Reference;
import coc.utils.Resource;

public class Yellow extends Missile
{
	public Yellow(double x, double y, double angdeg)
	{
		super(x, y, angdeg);
		setDims(21, 21);
		setDamage(3);
		setAnim(new ConstantAnimation(4, new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 1, 3, 14),
				new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 2, 3, 14),
				new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 3, 3, 14),
				new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 4, 3, 14)));
	}

	@Override
	public String getName() {
		return "YELLOW";
	}
}
