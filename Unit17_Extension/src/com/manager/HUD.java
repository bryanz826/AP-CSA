package com.manager;

import java.awt.Color;
import java.awt.Graphics2D;

import com.entity.mobile.ammo.player.Magazine;
import com.entity.mobile.live.player.Ship;
import com.main.OuterSpace;
import com.state.levels.LevelManager;
import com.utils.Reference;
import com.utils.Resource;

public class HUD
{
	private Resource	bg;
	private Resource	bgFPS;
	private Skills		skills;

	private int			iHp;

	public HUD(Ship ship)
	{
		bg = new Resource(Reference.HUD_LOC + "bg_hud.png");
		bgFPS = new Resource(Reference.HUD_LOC + "FPS_area.png");
		skills = new Skills();

		iHp = ship.getHp();
	}
	
	public void processInput(LevelManager lm) {
		skills.processInput(lm);
	}

	public void update(Magazine magazine, Ship ship) {
		skills.update(magazine, ship);
	}

	public void render(Graphics2D g, Ship ship, LevelManager lm) {
		bg.render(g, 10, 10);
		if (OuterSpace.getShowFPS()) bgFPS.render(g, Reference.WIDTH - 176, 102);

		// set up HP area
		new Text("HP", 24, 24, 0.5).drawString(g);
		int hpX = 86, hpY = 24, hpWidth = 300, hpHeight = 28;
		g.setColor(new Color(128, 128, 128, 128));
		g.fillRect(hpX, hpY, hpWidth, hpHeight);
		g.setColor(new Color(255, 98, 89));
		for (int i = 0; i < ship.getHp(); i++) {
			g.fillRect(hpX + i * hpWidth / iHp, hpY, hpWidth / iHp, hpHeight);
		}

		// set up SCORE area
		String str = Integer.toString(LevelManager.getScore());
		new Text(str, Reference.WIDTH - 392, 24, 1.2).drawStringFixed(g, 6, "0");
		
		// set up skillbar
		skills.render(g, lm);
	}
	
	public boolean isUsingSkill() {
		return skills.isUsingSkill();
	}
}
