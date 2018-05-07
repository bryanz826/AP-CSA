package com.entity.mobile.live.alien.types;

import java.awt.Color;
import java.awt.Graphics2D;

import com.entity.mobile.ammo.alien.Storage;
import com.entity.mobile.live.alien.Alien;

import coc.utils.Reference;
import coc.utils.Resource;

public class Boss extends Alien
{
	private Resource	bossHud;

	private int			iHp;

	public Boss(double x, double y, double dx, double dy, int tag)
	{
		this(x, y, 200, 200, dx, dy, tag);
	}

	public Boss(double x, double y, int w, int h, double dx, double dy, int tag)
	{
		super(x, y, w, h, dx, dy, 10000, 20, 100000, tag);
		setImage("alien.png");
		bossHud = new Resource(Reference.HUD_LOC + "boss_hud.png");
		iHp = getHp();
		setFrequency(4);
	}

	@Override
	public void render(Graphics2D g) {
		super.render(g);

		bossHud.render(g, 10, Reference.HEIGHT - 107);
		int hpX = 20, hpY = Reference.HEIGHT - 76, hpWidth = 1312, hpHeight = 18;
		g.setColor(new Color(128, 128, 128, 128));
		g.fillRect(hpX, hpY, hpWidth, hpHeight);
		g.setColor(new Color(255, 98, 89));
		for (int i = 0; i < getHp(); i++) {
			g.fillRect((int) (hpX + i * (double) hpWidth / iHp), hpY, 1, hpHeight);
		}
	}

	@Override
	public void shoot(Storage storage, int timer) {
		storage.greenMissile(this, timer);
	}

	@Override
	public String getName() {
		return "BOSS";
	}
}
