package com.animations;

import java.awt.Graphics2D;

import com.animations.types.Animation;
import com.utils.Resource;

public class DynamicAnimation extends Animation
{
	private String tag;
	
	public DynamicAnimation()
	{
		super();
	}

	public DynamicAnimation(int speed, Resource... frames)
	{
		super(speed, frames);
	}

	public DynamicAnimation(float radians, int speed, Resource... frames)
	{
		super(radians, speed, frames);
	}

	public DynamicAnimation(float radians, int speed, String tag, Resource... frames)
	{
		super(radians, speed, frames);
		this.tag = tag;
	}

	@Override
	public boolean nextFrame() {
		setCurrentFrame(getFrames()[getIndex()]);
		setIndex(getIndex() + 1);
		if (getIndex() >= getNumFrames()) {
			setIndex(0);
		}
		return false;
	}

	@Override
	public boolean update() {
		setCount(getCount() + 1);
		if (getCount() > getSpeed()) {
			setCount(0);
			return nextFrame();
		}
		return false;
	}

	public void render(Graphics2D g, float x, float y) {
		if (getCurrentFrame() != null) g.drawImage(getCurrentFrame().getImage(), (int) x, (int) y, null);
	}

	public void render(Graphics2D g, float x, float y, float width, float height) {
		if (getCurrentFrame() != null)
			g.drawImage(getCurrentFrame().getImage(), (int) x, (int) y, (int) width, (int) height, null);
	}
	
	public String getTag() {
		return tag;
	}
}
