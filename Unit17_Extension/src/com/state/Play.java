package com.state;

import java.awt.Graphics2D;

import com.entities.EntityManager;
import com.main.GamePanel;
import com.utils.Keys;
import com.utils.Reference;
import com.utils.Resource;

public abstract class Play
{
	protected static EntityManager	em;
	
	private static int				timer;
	private static int				score;

	private int						tick;
	private int						wave;

	protected Resource				bg;

	public abstract void init();

	public static void start() {
		timer = 0;
		score = 0;
		em = new EntityManager();
		em.init();
	}

	public void enter() {
		wave = 0;
		tick = 0;
	}

	public void processInput() {
		if (Keys.wasPressed(Keys.ESCAPE)) {
			if (GamePanel.getPause()) GamePanel.setPause(false);
			else GamePanel.setPause(true);
		}
		em.processInput();
	}

	public void update() {
		timer++;
		tick++;

		em.update();
		if (em.getShip().isDead() && ++tick == 250) {
			States.setState("GAMEOVER");
		}
	}

	public void render(Graphics2D g) {
		bg.render(g, 0, 0, Reference.WIDTH, Reference.HEIGHT);
		em.render(g);
	}

	public static void incScore(int score) {
		Play.score += score;
	}

	public void setTick(int tick) {
		this.tick = tick;
	}

	public void incTick() {
		tick++;
	}

	public void incWave() {
		wave++;
	}

	public void setBg(String bg) {
		this.bg = new Resource(Reference.LEVEL_LOC + bg);
	}

	public static int getTimer() {
		return timer;
	}

	public static int getScore() {
		return score;
	}

	public int getTick() {
		return tick;
	}

	public int getWave() {
		return wave;
	}
}
