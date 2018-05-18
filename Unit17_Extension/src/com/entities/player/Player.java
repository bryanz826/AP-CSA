package com.entities.player;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.animations.DynamicAnimation;
import com.animations.StaticAnimations;
import com.entities.Bounds;
import com.entities.Living;
import com.entities.player.ammo.Magazine;
import com.entities.player.powerups.PowerUps;
import com.utils.Keys;
import com.utils.Reference;
import com.utils.Resource;

public class Player extends Living
{
	private int					tick;

	private boolean				allowedToPass;

	private PlayerAnimations	animations;
	private Magazine			magazine;
	private PowerUps			powerups;
	private HUD					hud;

	public Player(float x, float y, float terminalDx, float terminalDy)
	{
		super(x, y, 42, 64, terminalDx, terminalDy, 0.45f, 0.45f, 20,
				new DynamicAnimation(1, new Resource(Reference.ENTITY_LOC + "ship.png")));
		animations = new PlayerAnimations();
		magazine = new Magazine();
		powerups = new PowerUps();
		hud = new HUD();
	}

	@Override
	public void actionOnDeath() {
		StaticAnimations.explode(getX(), getY(), getWidth(), getHeight());
	}

	public void processInput() {
		if (!isDead()) {
			if (Keys.isDown(Keys.LEFT) || Keys.isDown(Keys.A)) {
				accelNegX();
			} else if (Keys.isUp(Keys.LEFT) || Keys.isDown(Keys.A)) {
				decelNegX();
			}

			if (Keys.isDown(Keys.RIGHT) || Keys.isDown(Keys.D)) {
				accelPosX();
			} else if (Keys.isUp(Keys.RIGHT) || Keys.isDown(Keys.D)) {
				decelPosX();
			}

			if (Keys.isDown(Keys.UP) || Keys.isDown(Keys.W)) {
				accelNegY();
			} else if (Keys.isUp(Keys.UP) || Keys.isDown(Keys.W)) {
				decelNegY();
			}

			if (Keys.isDown(Keys.DOWN) || Keys.isDown(Keys.S)) {
				accelPosY();
			} else if (Keys.isUp(Keys.DOWN) || Keys.isDown(Keys.S)) {
				decelPosY();
			}

			if (Keys.isDown(Keys.R) && magazine.getLaserCount() > 0) {
				if (magazine.isUsingLaser()) return;
				magazine.setUsingLaser(true);
				magazine.decLaserCount();
			}
		}
	}

	@Override
	public void update() {
		tick++;
		if (!isDead()) {
			powerups.update(this);
			super.update();
			animations.update();
		}
		magazine.update(this);
	}

	@Override
	public void render(Graphics2D g) {
		powerups.render(g);
		if (!isDead()) {
			super.render(g);
			animations.render(g, this);
		}
		magazine.render(g);
		hud.render(g, this);
	}

	@Override
	public ArrayList<Bounds> getBounds() {
		ArrayList<Bounds> list = new ArrayList<Bounds>();
		list.add(new Bounds(getX(), getY() + getHeight() * 0.241f, getWidth()));
		float smallCircleSize = getWidth() * 0.368f;
		list.add(new Bounds(getX() + getWidth() / 2 - smallCircleSize / 2, getY() + getHeight() * 0.034f,
				smallCircleSize));
		return list;
	}

	public void setAllowedToPass(boolean allowedToPass) {
		this.allowedToPass = allowedToPass;
	}

	public int getTick() {
		return tick;
	}

	public boolean isAllowedToPass() {
		return allowedToPass;
	}

	public PlayerAnimations getAnimations() {
		return animations;
	}

	public Magazine getMagazine() {
		return magazine;
	}

	public PowerUps getPowerups() {
		return powerups;
	}
}
