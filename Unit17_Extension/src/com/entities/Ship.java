package com.entities;

import java.awt.Graphics2D;

import com.entity.mobile.live.player.Bounds;
import com.utils.Keys;

public class Ship extends Living
{
	public Ship(double x, double y, double width, double height, double terminal_dx, double terminal_dy, double d2x,
			double d2y, int hp)
	{
		super(x, y, terminal_dx, terminal_dy, d2x, d2y, hp, "ship.png");
	}
	
	public void processInput() {
		double a = 0.45;

		if (Keys.isDown(Keys.LEFT)) {
			accelNegX();
		} else if (Keys.isUp(Keys.LEFT)) {
			decelNegX();
		}

		if (Keys.isDown(Keys.RIGHT)) {
			accelPosX();
		} else if (Keys.isUp(Keys.RIGHT)) {
			decelPosX();
		}

		if (Keys.isDown(Keys.UP)) {
			accelNegY();
		} else if (Keys.isUp(Keys.UP)) {
			decelNegY();
		}

		if (Keys.isDown(Keys.DOWN)) {
			accelPosY();
		} else if (Keys.isUp(Keys.DOWN)) {
			decelPosY();
		}
	}
	
	public void update() {
		EntityManager.
	}
	
	public void render(Graphics2D g) {
		super.render(g);
		getBounds2().DEBUG(g);
	}

	@Override
	public Bounds getBounds() {
		return new Bounds(getX(), getY() + getHeight() * 0.241, getWidth());
	}

	public Bounds getBounds2() {
		double smallCircleSize = getWidth() * 0.368;
		return new Bounds(getX() + getWidth() / 2 - smallCircleSize / 2, getY() + getHeight() * 0.034, smallCircleSize);
	}
}
