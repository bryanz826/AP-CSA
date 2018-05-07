package com.entity.mobile.live.alien;

import com.entity.mobile.ammo.alien.Storage;
import com.entity.mobile.live.Live;

public abstract class Alien extends Live
{
	private int tick;
	private int tag;
	private int frequency;
	private double initialX;
	
	private int	damage;	// collision damage
	private int	points;

	public Alien(double x, double y, double terminal_dx, double terminal_dy, int hp, int damage, int tag)
	{
		this(x, y, 30, 30, terminal_dx, terminal_dy, hp, damage, 100, tag);
	}

	public Alien(double x, double y, double w, double h, double terminal_dx, double terminal_dy, int hp, int damage, int points, int tag)
	{
		super(x, y, w, h, terminal_dx, terminal_dy, hp);
		setDamage(damage);
		setPoints(points);
		this.tag = tag;
		this.initialX = x - 30;
	}
	
	public abstract void shoot(Storage storage, int timer);
	
	public void curve() {
		tick++;
		
	}
	
	public void start(String direction, double ratio) {
		tick++;
		direction = direction.toUpperCase();
		if (direction.equals("LEFT")) setDx(-getTerminal_dx() * ratio);
		else if (direction.equals("RIGHT")) setDx(getTerminal_dx() * ratio);
		else if (direction.equals("UP")) setDy(-getTerminal_dy() * ratio);
		else if (direction.equals("DOWN")) setDy(getTerminal_dy() * ratio);
	}
	
	public void endX() {
		tick++;
		setDx(0);
	}
	
	public void endY() {
		tick++;
		setDy(0);
	}
	
	public void speedUp(String direction, double accel) {
		tick++;
		direction = direction.toUpperCase();
		if (direction.equals("LEFT")) ddx(-accel);
		else if (direction.equals("RIGHT")) ddx(accel);
		else if (direction.equals("UP")) ddy(-accel);
		else if (direction.equals("DOWN")) ddy(accel);
	}
	
	public void swivel(double accel) {
		if (getX() > initialX) ddx(-accel);
		else if (getX() < initialX) ddx(accel);
	}
	
	public void slowDown(String direction, double accel) {
		tick++;
		direction = direction.toUpperCase();
		if (direction.equals("LEFT")) slowPosX(accel);
		else if (direction.equals("RIGHT")) slowNegX(-accel);
		else if (direction.equals("UP")) slowPosY(accel);
		else if (direction.equals("DOWN")) slowNegY(-accel);
	}
	
	public void still() {
		tick++;
	}
	
	
	public int getTick() {
		return tick;
	}
	
	public int getTag() {
		return tag;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public int getDamage() {
		return damage;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getPoints() {
		return points;
	}
	
	public int getFrequency() {
		return frequency;
	}
}
