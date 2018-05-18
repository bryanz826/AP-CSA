package com.entities.player.powerups;

import com.animations.DynamicAnimation;
import com.entities.Entity;
import com.entities.player.Player;

public abstract class PowerUp extends Entity
{
	private boolean pickedUp;

	public PowerUp(float x, float y, DynamicAnimation anim)
	{
		super(x, y, 36, 36, 0, 0.5f, 0, 0.05f, anim);
	}

	public abstract void actionOnPickUp(Player ship);
	
	@Override
	public void update() {
		accelPosY();
		super.update();
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}
}
