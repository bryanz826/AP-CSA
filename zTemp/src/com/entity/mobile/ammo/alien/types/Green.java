package com.entity.mobile.ammo.alien.types;

import com.animations.types.ConstantAnimation;
import com.entity.mobile.ammo.alien.Missile;

import coc.utils.Reference;
import coc.utils.Resource;

public class Green extends Missile
{
	public Green(double x, double y, double angdeg)
	{
		super(x, y, angdeg);
		setDims(28, 28);
		setDamage(7);
		setAnim(new ConstantAnimation(4, new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 1, 5, 14),
				new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 2, 5, 14),
				new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 3, 5, 14),
				new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 4, 5, 14)));
	}

	@Override
	public String getName() {
		return "GREEN";
	}
}
