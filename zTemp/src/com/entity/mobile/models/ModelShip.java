package com.entity.mobile.models;

import com.entity.mobile.Mobile;

import coc.utils.Reference;

public class ModelShip extends Mobile
{
	public ModelShip(double x, double y, double dx, double dy)
	{
		this(x, y, 35, 53, dx, dy);
	}

	public ModelShip(double x, double y, int w, int h, double dx, double dy)
	{
		super(x, y, w, h, dx, dy);
		setImage(Reference.ENTITY_LOC + "ship.png");
	}

	@Override
	public String getName() {
		return null;
	}
}