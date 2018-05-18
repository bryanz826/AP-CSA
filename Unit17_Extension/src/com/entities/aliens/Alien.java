package com.entities.aliens;

import com.animations.DynamicAnimation;
import com.animations.StaticAnimations;
import com.entities.Living;

public abstract class Alien extends Living
{
	private int		tick;
	private int		tag;
	private int		frequency;
	private int		collisionDamage;	// collision damage
	private int		points;

	private float	initialX;			// used for swivel

	public Alien(float x, float y, float width, float height, float terminalDx, float terminalDy, int hp,
			int collisionDamage, int points, int frequency, int tag, DynamicAnimation anim)
	{
		super(x, y, width, height, terminalDx, terminalDy, 0.25f, 0.25f, hp, anim);
		setCollisionDamage(collisionDamage);
		setPoints(points);
		setFrequency(frequency);
		this.tag = tag;
		this.initialX = x - width;
	}

	public abstract void shoot(Storage storage);

	public abstract String getName();

	@Override
	public void actionOnDeath() {
		StaticAnimations.explode(getX(), getY(), getWidth(), getHeight());
	}

	public void start(String direction, float ratio) {
		tick++;
		direction = direction.toUpperCase();
		if (direction.equals("LEFT")) setDx(-getTerminalDx() * ratio);
		else if (direction.equals("RIGHT")) setDx(getTerminalDx() * ratio);
		else if (direction.equals("UP")) setDy(-getTerminalDy() * ratio);
		else if (direction.equals("DOWN")) setDy(getTerminalDy() * ratio);
	}

	public void accel(String direction) {
		tick++;
		direction = direction.toUpperCase();
		if (direction.equals("LEFT")) accelNegX();
		else if (direction.equals("RIGHT")) accelPosX();
		else if (direction.equals("UP")) accelNegY();
		else if (direction.equals("DOWN")) accelPosY();
	}

	public void swivel() {
		tick++;
		if (getX() > initialX) accelPosX();
		else if (getX() < initialX) accelNegX();
	}

	public void decel(String direction) {
		tick++;
		direction = direction.toUpperCase();
		if (direction.equals("LEFT")) decelNegX();
		else if (direction.equals("RIGHT")) decelPosX();
		else if (direction.equals("UP")) decelNegY();
		else if (direction.equals("DOWN")) decelPosY();
	}

	public void still() {
		tick++;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public void setCollisionDamage(int collisionDamage) {
		this.collisionDamage = collisionDamage;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getTick() {
		return tick;
	}

	public int getTag() {
		return tag;
	}

	public int getFrequency() {
		return frequency;
	}

	public int getCollisionDamage() {
		return collisionDamage;
	}

	public int getPoints() {
		return points;
	}
}
