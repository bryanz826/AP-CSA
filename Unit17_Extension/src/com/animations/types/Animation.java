package com.animations.types;

import java.awt.Graphics2D;

import com.utils.Resource;

public abstract class Animation
{
	protected int			count;
	protected int			index;

	protected int			speed;
	protected int			numFrames;
	protected Resource		currentFrame;
	protected Resource[]	frames;

	protected abstract boolean nextFrame();

	public abstract boolean update();

	// still
	public void render(Graphics2D g) {}

	// moving
	public void render(Graphics2D g, double x, double y) {
		if (currentFrame != null) currentFrame.render(g, (int) x, (int) y);
	}

	// moving
	public void render(Graphics2D g, double x, double y, double width, double height) {
		if (currentFrame != null) currentFrame.render(g, (int) (x - width / 2), (int) (y - width / 2),
				(int) (2 * width), (int) (height + width));
	}

	@Override
	public String toString() {
		String output = "";
		for (Resource frame : frames) {
			output += frame + " ";
		}
		return output;
	}
}
