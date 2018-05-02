package com.entity.mobile.ammo.alien.types;

import com.animations.types.ConstantAnimation;
import com.entity.mobile.ammo.alien.Missile;
import com.utils.Reference;
import com.utils.Resource;

public class Red extends Missile
{	
	public Red(double x, double y, double angdeg)
	{
		super(x, y, angdeg);
		setDims(14, 14);
		setDamage(1);
		setAnim(new ConstantAnimation(4, new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 1, 1, 14),
				new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 2, 1, 14),
				new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 3, 1, 14),
				new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 4, 1, 14)));
	}

	@Override
	public String getName() {
		return "RED";
	}
}
