package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import managers.EntityManager;
import managers.StateManager;
import utils.Reference;

public class Play implements State
{
	private EntityManager	em;
	private int				level;
	
	@Override
	public void init() {
		em = new EntityManager();
		em.addBlocks(1);
		level = 1;
	}

	@Override
	public void processInput() {
		em.processInput();
	}

	@Override
	public void update() {
		em.update();
		if (EntityManager.getBlocks().isEmpty()) {
			if (++level > 2) StateManager.setState("GAMEOVER");
			else {
				em.restart();
				if (level == 2) em.addBlocks(2);
			}
		}
	}

	@Override
	public void render(Graphics2D g) {
		g.clearRect(0, 0, Reference.WIDTH, Reference.HEIGHT);
		em.render(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		g.drawString("Level " + level, 30, 17);
	}

	@Override
	public String getName() {
		return "PLAY";
	}
}
