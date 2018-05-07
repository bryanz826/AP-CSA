package com.animations.types;

import java.awt.Graphics2D;

import com.utils.Resource;

public class StillAnime extends Animation
{
	private double	x;
	private double	y;
	private double	width;
	private double	height;

	public StillAnime(double x, double y, double width, double height, int speed, Resource... frames)
	{
		super(speed, frames);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	private boolean nextFrame() {
		setCurrentFrame(getFrames()[getIndex()]);
		setIndex(getIndex() + 1);
		if (getIndex() >= getNumFrames()) return true;
		return false;
	}

	public boolean update() {
		setCount(getCount() + 1);
		if (getCount() > getSpeed()) {
			setCount(0);
			return nextFrame();
		}
		return false;
	}

	public void render(Graphics2D g) {
		if (getCurrentFrame() != null) getCurrentFrame().render(g, x, y, width, height);
	}
}
