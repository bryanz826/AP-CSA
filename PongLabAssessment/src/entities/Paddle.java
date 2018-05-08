package entities;

import java.awt.Color;
import java.awt.Graphics2D;

import utils.Keys;
import utils.Playable;

public class Paddle extends Entity implements Playable
{
	public Paddle(double x, double y, double terminalDx, double terminalDy)
	{
		super(x, y, 40, 40, terminalDx, terminalDy, 0.45, 0.45);
	}

	@Override
	public void processInput() {
		if (Keys.isDown(Keys.LEFT)) {
			accelNegX();
		} else if (Keys.isUp(Keys.LEFT)) {
			decelNegX();
		}

		if (Keys.isDown(Keys.RIGHT)) {
			accelPosX();
		} else if (Keys.isUp(Keys.RIGHT)) {
			decelPosX();
		}

		if (Keys.isDown(Keys.UP)) {
			accelNegY();
		} else if (Keys.isUp(Keys.UP)) {
			decelNegY();
		}

		if (Keys.isDown(Keys.DOWN)) {
			accelPosY();
		} else if (Keys.isUp(Keys.DOWN)) {
			decelPosY();
		}
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(new Color(192, 192, 192));
		g.fillRect((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
		double sides = getWidth() / 5;
		g.setColor(Color.BLACK);
		g.fillRect((int) (getX() + sides), (int) (getY() + sides), (int) (getWidth() - sides * 2),
				(int) (getHeight() - sides * 2));
		debug(g);
	}
}
