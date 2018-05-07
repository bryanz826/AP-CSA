package com.entity.mobile.models;

import com.entity.mobile.Mobile;

import coc.utils.Reference;

public class ModelAlien extends Mobile
{
	public ModelAlien(double x, double y, double dx, double dy)
	{
		this(x, y, 30, 30, dx, dy);
	}

	public ModelAlien(double x, double y, int w, int h, double dx, double dy)
	{
		super(x, y, w, h, dx, dy);
		setImage(Reference.ENTITY_LOC + "alien.png");
	}

	@Override
	public String getName() {
		return null;
	}
}