package com.animations.types;

import com.utils.Resource;

public class MovingAnimation extends Animation
{
	public MovingAnimation(int speed, Resource... frames)
	{
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
}
