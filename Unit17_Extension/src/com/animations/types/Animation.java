package com.animations.types;

import com.utils.Resource;

public abstract class Animation
{
	private int			count;
	private int			index;

	private int			speed;
	private int			numFrames;
	private Resource	currentFrame;
	private Resource[]	frames;

	public Animation(int speed, Resource... frames) {
		this.speed = speed;
		this.numFrames = frames.length;
		this.frames = frames;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public void setCurrentFrame(Resource currentFrame) {
		this.currentFrame = currentFrame;
	}
	
	public int getCount() {
		return count;
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getNumFrames() {
		return numFrames;
	}
	
	public Resource getCurrentFrame() {
		return currentFrame;
	}
	
	public Resource[] getFrames() {
		return frames;
	}

	@Override
	public String toString() {
		String output = "Animation [";
		for (int i = 0; i < frames.length - 1; i++)
			output += frames[i] + ", ";
		return output + frames[frames.length - 1] + "]";
	}
}
