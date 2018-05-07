package com.animations.types;

import java.awt.Graphics2D;

import com.utils.Resource;

public class BriefAnime extends Animation
{
	public BriefAnime(int speed, Resource[] frames)
	{
		super(speed, frames);
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

	public void render(Graphics2D g, double x, double y) {
		if (getCurrentFrame() != null) getCurrentFrame().render(g, x, y);
	}

	public void render(Graphics2D g, double x, double y, double width, double height) {
		if (getCurrentFrame() != null) getCurrentFrame().render(g, x, y, width, height);
	}
}
