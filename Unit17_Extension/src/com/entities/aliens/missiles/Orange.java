package com.entities.aliens.missiles;

import com.animations.DynamicAnimation;
import com.animations.StaticAnimations;
import com.utils.Reference;
import com.utils.Resource;

public class Orange extends Missile
{
	public Orange(float x, float y, float angdeg)
	{
		super(x, y, 21, 21, 5, 5, 2, angdeg,
				new DynamicAnimation(4, new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 1, 2, 14),
						new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 2, 2, 14),
						new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 3, 2, 14),
						new Resource(new Resource(Reference.BULLET_LOC + "missile.png"), 4, 2, 14)));
	}
	
	@Override
	public void actionOnLanding() {
		StaticAnimations.orangeHit(getX(), getY(), getWidth(), getHeight());
	}
}
