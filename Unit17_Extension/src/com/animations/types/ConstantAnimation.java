package com.animations.types;

import java.awt.Graphics2D;

import com.utils.Resource;

public class ConstantAnimation extends Animation
{
	public ConstantAnimation(int speed, Resource... frames)
	{
		this.speed = speed;
		this.frames = frames;
		this.numFrames = frames.length;
	}

	protected boolean nextFrame() {
		currentFrame = frames[index++];
		if (index >= numFrames) index = 0;
		return false;
	}

	public boolean update() {
		if (++count > speed) {
			count = 0;
			nextFrame();
		}
		return false;
	}

	public void render(Graphics2D g, double x, double y) {
		if (currentFrame != null) g.drawImage(currentFrame.getImage(), (int) x, (int) y, null);
	}

	public void render(Graphics2D g, double x, double y, double width, double height) {
		if (currentFrame != null)
			g.drawImage(currentFrame.getImage(), (int) x, (int) y, (int) width, (int) height, null);
	}
}
