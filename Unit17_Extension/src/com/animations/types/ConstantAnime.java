package com.animations.types;

import java.awt.Graphics2D;

import com.utils.Resource;

public class ConstantAnime extends Animation
{
	public ConstantAnime(int speed, Resource... frames)
	{
		super(speed, frames);
	}

	private void nextFrame() {
		setCurrentFrame(getFrames()[getIndex()]);
		setIndex(getIndex() + 1);
		if (getIndex() >= getNumFrames()) setIndex(0);
	}

	public void update() {
		setCount(getCount() + 1);
		if (getCount() > getSpeed()) {
			setCount(0);
			nextFrame();
		}
	}

	public void render(Graphics2D g, double x, double y) {
		if (getCurrentFrame() != null) g.drawImage(getCurrentFrame().getImage(), (int) x, (int) y, null);
	}

	public void render(Graphics2D g, double x, double y, double width, double height) {
		if (getCurrentFrame() != null)
			g.drawImage(getCurrentFrame().getImage(), (int) x, (int) y, (int) width, (int) height, null);
	}
}
