package com.animations.types;

import com.animations.DynamicAnimation;
import com.utils.Resource;

public class BriefDynamicAnimation extends DynamicAnimation
{
	public BriefDynamicAnimation(int speed, Resource... frames)
	{
		super(speed, frames);
	}

	public BriefDynamicAnimation(float radians, int speed, Resource... frames)
	{
		super(radians, speed, frames);
	}

	@Override
	public boolean nextFrame() {
		setCurrentFrame(getFrames()[getIndex()]);
		setIndex(getIndex() + 1);
		if (getIndex() >= getNumFrames()) return true;
		return false;
	}
}
