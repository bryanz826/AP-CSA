package com.entities.aliens.types;

import java.awt.Color;
import java.awt.Graphics2D;

import com.animations.DynamicAnimation;
import com.entities.aliens.Alien;
import com.entities.aliens.Storage;
import com.utils.Reference;
import com.utils.Resource;

public class Boss extends Alien
{
	private Resource	bossHud;

	public Boss(float x, float y, float dx, float dy, int tag)
	{
		this(x, y, 200, 200, dx, dy, tag);
	}

	public Boss(float x, float y, float width, float height, float terminalDx, float terminalDy, int tag)
	{
		super(x, y, width, height, terminalDx, terminalDy, 10000, 20, 100000, 4, tag,
				new DynamicAnimation(1, new Resource(Reference.ENTITY_LOC + "alien.png")));
		bossHud = new Resource(Reference.HUD_LOC + "boss_hud.png");
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
			g.fillRect((int) (hpX + i * (float) hpWidth / getInitialHp()), hpY, 1, hpHeight);
		}
	}

	@Override
	public void shoot(Storage storage) {
		storage.greenMissile(this, getTick());
	}

	@Override
	public String getName() {
		return "BOSS";
	}
}
