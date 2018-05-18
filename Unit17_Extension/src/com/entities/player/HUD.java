package com.entities.player;

import java.awt.Color;
import java.awt.Graphics2D;

import com.main.GamePanel;
import com.state.Play;
import com.text.Text;
import com.utils.Reference;
import com.utils.Resource;

public class HUD
{
	private Resource	bg;
	private Resource	bgFPS;
	private Resource	bgSkills;
	private Resource	bgSkillsLaserPic;

	public HUD()
	{
		bg = new Resource(Reference.HUD_LOC + "bg_hud.png");
		bgFPS = new Resource(Reference.HUD_LOC + "FPS_area.png");
		bgSkills = new Resource(Reference.HUD_LOC + "skill_hud.png");
		bgSkillsLaserPic = new Resource(Reference.POWERUP_LOC + "laser_powerup.png");
	}

	public void render(Graphics2D g, Player ship) {
		bg.render(g, 10, 10);
		if (GamePanel.getShowFPS()) bgFPS.render(g, Reference.WIDTH - 176, 102);

		// set up HP area
		new Text("HP", 24, 24, 0.5f).drawString(g);
		int hpX = 86, hpY = 24, hpWidth = 300, hpHeight = 28;
		g.setColor(new Color(128, 128, 128, 128));
		g.fillRect(hpX, hpY, hpWidth, hpHeight);
		g.setColor(new Color(255, 98, 89));
		for (int i = 0; i < ship.getHp(); i++) {
			g.fillRect((int) (hpX + i * (float) hpWidth / ship.getInitialHp()), hpY,
					Math.round((float) hpWidth / ship.getInitialHp()), hpHeight);
		}

		// set up SCORE area
		String str = Integer.toString(Play.getScore());
		new Text(str, Reference.WIDTH - 392, 24, 1.2f).drawStringFixed(g, 6, "0");

		bgSkills.render(g, 16, 96);
		bgSkillsLaserPic.render(g, 16, 108);
		new Text("R", 48, 128, 0.4f).drawString(g);
		new Text("" + ship.getMagazine().getLaserCount(), 4, 128, 0.4f).drawString(g);
	}
}
