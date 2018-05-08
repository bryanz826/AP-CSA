package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import managers.StateManager;
import utils.Keys;
import utils.Reference;

public class GameOver implements State
{
	@Override
	public void init() {}

	@Override
	public void processInput() {
		if (Keys.wasPressed(Keys.ENTER)) {
			StateManager.setState("PLAY");
			StateManager.getCurrentState().init();
		}
	}

	@Override
	public void update() {}

	@Override
	public void render(Graphics2D g) {
		g.clearRect(0, 0, Reference.WIDTH, Reference.HEIGHT);
		g.setColor(new Color(192, 255, 192));
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 110));
		g.drawString("YOU WIN!", 160, Reference.CENTER_Y - 80);
		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
		g.drawString("PRESS <ENTER> TO", Reference.CENTER_X - 250, Reference.CENTER_Y + 50);
		g.drawString("PLAY AGAIN", Reference.CENTER_X - 150, Reference.CENTER_Y + 110);
	}

	@Override
	public String getName() {
		return "GAMEOVER";
	}

}
