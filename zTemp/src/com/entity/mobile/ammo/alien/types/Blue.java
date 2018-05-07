package com.entity.mobile.ammo.alien.types;

import com.animations.types.ConstantAnimation;
import com.entity.mobile.ammo.alien.Missile;

import coc.utils.Reference;
import coc.utils.Resource;

public class Blue extends Missile
{
	public Blue(double x, double y, double angdeg)
	{
		super(x, y, angdeg);
		setDims(24, 24);
		setDamage(5);
		setAnim(new ConstantAnimation(4, new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 1, 4, 14),
				new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 2, 4, 14),
				new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 3, 4, 14),
				new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 4, 4, 14)));
	}

	@Override
	public String getName() {
		return "BLUE";
	}
}
