package com.entities.player.powerups.types;

import com.animations.DynamicAnimation;
import com.entities.player.Player;
import com.entities.player.powerups.PowerUp;
import com.utils.Reference;
import com.utils.Resource;

public class LaserUp extends PowerUp
{
	public LaserUp(float x, float y)
	{
		super(x, y, new DynamicAnimation(1, new Resource(Reference.POWERUP_LOC + "laser_powerup.png")));
	}

	@Override
	public void actionOnPickUp(Player ship) {
		ship.getMagazine().incLaserCount();
		ship.getAnimations().purpleSlash();
	}
}
