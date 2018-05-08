package com.state;

import java.awt.Graphics2D;

import com.state.levels.LevelManager;
import com.text.Text;
import com.utils.Keys;
import com.utils.Reference;
import com.utils.Resource;

public class GameOver implements State
{
	private static boolean	win;
	private int				rand;

	private Resource		bg;
	private Resource		selectLeft;
	private Resource		selectRight;

	private int				currentOption	= 0;
	private String[]		options			= { "PLAY AGAIN", "MENU" };

	@Override
	public void init() {
		bg = new Resource(Reference.STATE_LOC + "space_gameover.jpg");
		selectLeft = new Resource(Reference.STATE_LOC + "selection_left.png");
		selectRight = new Resource(Reference.STATE_LOC + "selection_right.png");
	}

	@Override
	public void enter() {
		rand = (int) (Math.random() * 4);
	}

	@Override
	public void processInput(States sm) {
		if (Keys.wasPressed(Keys.UP)) {
			if (--currentOption < 0) currentOption = options.length - 1;
		}
		if (Keys.wasPressed(Keys.DOWN)) {
			if (++currentOption >= options.length) currentOption = 0;
		}

		if (Keys.wasPressed(Keys.ENTER)) {
			selectOption(sm);
		}
	}

	private void selectOption(States sm) {
		if (currentOption == 0) {
			LevelManager.start();
			States.setState("LEVEL00");
		}
		if (currentOption == 1) {
			States.setState("MENU");
		}
	}

	@Override
	public void update(States sm) {}

	@Override
	public void render(Graphics2D g) {
		bg.render(g, 0, 0, Reference.WIDTH, Reference.HEIGHT);

		if (win) new Text("YOU WIN", Reference.CENTER_X - 250, Reference.CENTER_Y - 250, 1.5).drawString(g);
		else {
			if (rand == 0) new Text("MAYBE NEXT TIME", 120, Reference.CENTER_Y - 250, 1.5).drawString(g);
			else if (rand == 1)
				new Text("GAME OVER", Reference.CENTER_X - 350, Reference.CENTER_Y - 250, 1.5).drawString(g);
			else if (rand == 2)
				new Text("BAD LUCK", Reference.CENTER_X - 300, Reference.CENTER_Y - 250, 1.5).drawString(g);
			else if (rand == 3) new Text("BAD COLLISION DETECTION???", 30, Reference.CENTER_Y - 210, 1).drawString(g);
		}

		new Text(options[0], Reference.CENTER_X + 150, Reference.CENTER_Y + 25, 0.85).drawString(g);
		new Text(options[1], Reference.CENTER_X + 275, Reference.CENTER_Y + 150, 0.85).drawString(g);

		if (currentOption == 0) {
			selectLeft.render(g, Reference.CENTER_X + 75, Reference.CENTER_Y + 20, 50, 50);
			selectRight.render(g, Reference.WIDTH - 90, Reference.CENTER_Y + 20, 50, 50);
		} else if (currentOption == 1) {
			selectLeft.render(g, Reference.CENTER_X + 200, Reference.CENTER_Y + 148, 50, 50);
			selectRight.render(g, Reference.WIDTH - 215, Reference.CENTER_Y + 148, 50, 50);
		}

		new Text("Stats", 170, Reference.CENTER_Y - 50).drawString(g);
		new Text("Score: ", 70, Reference.CENTER_Y + 70, 0.8).drawString(g);
		;
		new Text("" + LevelManager.getScore(), 320, Reference.CENTER_Y + 70, 0.8).drawStringFixed(g, 6, "0");
		new Text("Time: ", 70, Reference.CENTER_Y + 150, 0.8).drawString(g);
		new Text("" + LevelManager.getTimer() / 3600, 320, Reference.CENTER_Y + 150, 0.8).drawStringFixed(g, 2, "0");
		new Text(":", 400, Reference.CENTER_Y + 150, 0.8).drawString(g);
		new Text("" + ((LevelManager.getTimer() % 3600) / 60), 440, Reference.CENTER_Y + 150, 0.8).drawStringFixed(g, 2,
				"0");
	}

	@Override
	public String getName() {
		return "GAMEOVER";
	}

	public static void setWin(boolean win) {
		GameOver.win = win;
	}
}
