package com.animations.types;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import com.utils.Resource;

public abstract class Animation
{
	private int			count;
	private int			index;

	private int			speed;
	private int			numFrames;
	private Resource	currentFrame;
	private Resource[]	frames;

	public Animation() {
		this(0, 0, (Resource[]) null);
		System.err.println("Override the default constructor by specifying the frames.");
	}
	
	public Animation(int speed, Resource... frames)
	{
		this(0, speed, frames);
	}

	public Animation(float radians, int speed, Resource... frames)
	{
		this.speed = speed;
		this.numFrames = frames.length;
		this.frames = frames;
		rotate(radians);
	}

	private void rotate(float radians) {
		if (radians == 0) return;
		for (Resource frame : frames) {
			AffineTransform details = AffineTransform.getRotateInstance(radians, frame.getWidth() / 2, frame.getHeight() / 2);
			frame.setImage(
					new AffineTransformOp(details, AffineTransformOp.TYPE_BILINEAR).filter(frame.getImage(), null));
		}
	}

	public boolean nextFrame() {
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
