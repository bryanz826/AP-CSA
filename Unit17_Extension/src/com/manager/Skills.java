package com.manager;

import java.awt.Graphics2D;

import com.entity.mobile.ammo.player.Magazine;
import com.entity.mobile.live.player.Ship;
import com.state.levels.LevelManager;
import com.utils.Reference;
import com.utils.Resource;

public class Skills
{
	private Resource	skillHud;
	private Resource	laser;
	private int 		tick;
	
	private boolean		useSkill;

	public Skills()
	{
		skillHud = new Resource(Reference.HUD_LOC + "skill_hud.png");
		laser = new Resource(Reference.POWERUP_LOC + "laser_powerup.png");
	}

	public void processInput(LevelManager lm) {
		if (Keys.wasPressed(Keys.R) && lm.getLaserCount() > 0) {
			useSkill = true;
			lm.decLaserCount();
		}
	}

	public void update(Magazine magazine, Ship ship) {
		if (useSkill) {
			magazine.laser(ship);
			if (++tick >= 250) {
				useSkill = false;
				tick = 0;
			}
		}
	}

	public void render(Graphics2D g, LevelManager lm) {
		skillHud.render(g, 10, 90, 50, 50);
		laser.render(g, 16, 96);
		new Text("R", 48, 128, 0.4).drawString(g);
		new Text("" + lm.getLaserCount(), 4, 128, 0.4).drawString(g);
	}
	
	public boolean isUsingSkill() {
		return useSkill;
	}
}
