package com.animations.types;

import java.awt.Graphics2D;

import com.utils.Resource;

public class StaticAnimation extends Animation
{
	private float	x;
	private float	y;
	private float	width;
	private float	height;

	public StaticAnimation(float x, float y, float width, float height, int speed, Resource... frames)
	{
		super(speed, frames);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void render(Graphics2D g) {
		if (getCurrentFrame() != null) getCurrentFrame().render(g, x, y, width, height);
	}
}
