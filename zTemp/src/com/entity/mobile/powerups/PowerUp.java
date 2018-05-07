package com.entity.mobile.powerups;

import com.entity.mobile.Mobile;

import coc.utils.Reference;

public abstract class PowerUp extends Mobile
{
	private boolean pickedUp;
	
	public PowerUp(double x, double y)
	{
		this(x, y, 36, 36);
	}

	public PowerUp(double x, double y, double width, double height)
	{
		super(x, y, width, height, 0, 0.5);
	}

	@Override
	public void setImage(String fileName) {
		super.setImage(Reference.POWERUP_LOC + fileName);
	}
	
	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}
	
	public boolean isPickedUp() {
		return pickedUp;
	}
}
