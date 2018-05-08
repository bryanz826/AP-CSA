package entities;

import java.awt.Color;
import java.awt.Graphics2D;

public class Block extends Entity
{
	private int hp;

	public Block(double x, double y, double width, double height, int hp)
	{
		super(x, y, width, height, 0, 0);
		setHp(hp);
	}

	@Override
	public void render(Graphics2D g) {
		if (hp > 1) g.setColor(new Color(192, 192, 255));
		else g.setColor(new Color(255, 192, 192));
		g.fillRect((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
		double sides = getWidth() / 5;
		g.setColor(Color.BLACK);
		g.fillRect((int) (getX() + sides), (int) (getY() + sides), (int) (getWidth() - sides * 2),
				(int) (getHeight() - sides * 2));
		debug(g);
	}

	public boolean isDead() {
		return hp <= 0;
	}

	public void damage(int damage) {
		hp -= damage;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHp() {
		return hp;
	}
}
