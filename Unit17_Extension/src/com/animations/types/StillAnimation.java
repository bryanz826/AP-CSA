package com.animations.types;

import java.awt.Graphics2D;

import com.utils.Resource;

public class StillAnimation extends Animation
{
	private double	x;
	private double	y;
	private double	width;
	private double	height;

	public StillAnimation(double x, double y, int speed, Resource... frames)
	{
		this(x, y, 0, 0, speed, frames);
	}

	public StillAnimation(double x, double y, double width, double height, int speed, Resource... frames)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.frames = frames;
		this.numFrames = frames.length;
	}

	protected boolean nextFrame() {
		currentFrame = frames[index++];
		if (index >= numFrames) return true;
		return false;
	}

	public boolean update() {
		if (++count > speed) {
			count = 0;
			return nextFrame();
		}
		return false;
	}

	public void render(Graphics2D g) {
		if (currentFrame != null)
			currentFrame.render(g, (int) x, (int) y, (int) width, (int) height);
	}
}
