package com.entity.mobile.ammo.alien.types;

import com.animations.types.ConstantAnimation;
import com.entity.mobile.ammo.alien.Missile;

import coc.utils.Reference;
import coc.utils.Resource;

public class Orange extends Missile
{
	public Orange(double x, double y, double angdeg)
	{
		super(x, y, angdeg);
		setDims(21, 21);
		setDamage(2);
		setAnim(new ConstantAnimation(4, new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 1, 2, 14),
				new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 2, 2, 14),
				new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 3, 2, 14),
				new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 4, 2, 14)));
	}

	@Override
	public String getName() {
		return "ORANGE";
	}
}
