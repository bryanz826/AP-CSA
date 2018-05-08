package entities;

import java.awt.Color;
import java.awt.Graphics2D;

public class Wall extends Entity
{
	public Wall(double x, double y, double width, double height) {
		super(x, y, width, height, 0, 0);
	}
	
	@Override
	public void update() {
		
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
		debug(g);
	}
}
