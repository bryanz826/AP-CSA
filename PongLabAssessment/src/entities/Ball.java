package entities;

import java.awt.Color;
import java.awt.Graphics2D;

public class Ball extends Entity
{
	private int damage;
	
	public Ball(double x, double y, double terminalDx, double terminalDy)
	{
		super(x, y, 10, 10, terminalDx, terminalDy, 10, 10);
		setDamage(1);
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillOval((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
		double sides = getWidth() / 5;
		g.setColor(Color.BLACK);
		g.fillOval((int) (getX() + sides), (int) (getY() + sides), (int) (getWidth() - sides * 2),
				(int) (getHeight() - sides * 2));
		debug(g);
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getDamage() {
		return damage;
	}
}
