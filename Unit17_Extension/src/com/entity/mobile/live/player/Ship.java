package com.entity.mobile.live.player;

import java.awt.Graphics2D;

import com.animations.Animations;
import com.entity.mobile.live.Live;
import com.manager.Bounds;
import com.manager.Keys;
import com.state.States;
import com.state.levels.LevelManager;

public class Ship extends Live
{
	private boolean	pickUpHPAnimation;
	private boolean	pickUpRateAnimation;
	private boolean	pickUpAnimation;
	private boolean pass;

	public Ship(double x, double y, double terminal_dx, double terminal_dy, int hp)
	{
		this(x, y, 42, 64, terminal_dx, terminal_dy, hp);
	}

	public Ship(double x, double y, double w, double h, double terminal_dx, double terminal_dy, int hp)
	{
		super(x, y, w, h, terminal_dx, terminal_dy, hp);
		setImage("ship.png");
	}

	public void processInput(LevelManager lm) {
		double a = 0.45;

		if (Keys.isDown(Keys.LEFT)) {
			ddx(-a);
		} else if (Keys.isUp(Keys.LEFT)) {
			slowPosX(a);
		}

		if (Keys.isDown(Keys.RIGHT)) {
			ddx(a);
		} else if (Keys.isUp(Keys.RIGHT)) {
			slowNegX(-a);
		}

		if (Keys.isDown(Keys.UP)) {
			ddy(-a);
		} else if (Keys.isUp(Keys.UP)) {
			slowPosY(a);
		}

		if (Keys.isDown(Keys.DOWN)) {
			ddy(a);
		} else if (Keys.isUp(Keys.DOWN)) {
			slowNegY(-a);
		}
	}

	public void update(States sm, LevelManager lm, Animations animations) {
		super.update(animations);
		if (pickUpAnimation) {
			animations.pickUp();
			pickUpAnimation = false;
		}
		if (pickUpHPAnimation) {
			animations.pickUpHP();
			pickUpHPAnimation = false;
		}
		if (pickUpRateAnimation) {
			animations.pickUpRate();
			pickUpRateAnimation = false;
		}

		if (checkDeath()) {
			animations.explode(getX() - 10, getY(), getWidth() + 20, getHeight());
			lm.killShip();
		}
	}

	@Override
	public void render(Graphics2D g) {
		super.render(g);
		getBounds2().DEBUG(g);
	}

	public void triggerPickUp() {
		pickUpAnimation = true;
	}

	public void triggerPickUpHP() {
		pickUpHPAnimation = true;
	}

	public void triggerPickUpRate() {
		pickUpRateAnimation = true;
	}
	
	public void setPass(boolean pass) {
		this.pass = pass;
	}
	
	public boolean isPass() {
		return pass;
	}

	@Override
	public Bounds getBounds() {
		return new Bounds(getX(), getY() + getHeight() * 0.241, getWidth());
	}

	public Bounds getBounds2() {
		double smallCircleSize = getWidth() * 0.368;
		return new Bounds(getX() + getWidth() / 2 - smallCircleSize / 2, getY() + getHeight() * 0.034, smallCircleSize);
	}

	@Override
	public String getName() {
		return "SHIP";
	}
}
