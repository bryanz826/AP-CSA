package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import main.GamePanel;
import utils.Loopable;

public abstract class Entity implements Loopable
{
	public final int	TOP_LEFT		= 0;
	public final int	TOP_MIDDLE		= 1;
	public final int	TOP_RIGHT		= 2;
	public final int	LEFT_MIDDLE		= 3;
	public final int	RIGHT_MIDDLE	= 4;
	public final int	BOTTOM_LEFT		= 5;
	public final int	BOTTOM_MIDDLE	= 6;
	public final int	BOTTOM_RIGHT	= 7;

	private double		x;
	private double		y;
	private double		width;
	private double		height;
	private double		dx;
	private double		dy;
	private double		terminalDx;
	private double		terminalDy;
	private double		d2x;
	private double		d2y;

	public Entity()
	{
		this(400, 400, 25, 25);
	}

	public Entity(double x, double y, double width, double height)
	{
		this(x, y, width, height, 5, 5);
	}

	public Entity(double x, double y, double width, double height, double terminalDx, double terminalDy)
	{
		this(x, y, width, height, terminalDx, terminalDy, 0, 0);
	}

	public Entity(double x, double y, double width, double height, double terminalDx, double terminalDy, double d2x,
			double d2y)
	{
		setPosition(x - width / 2, y - height / 2);
		setDimensions(width, height);
		setTerminalVelocities(terminalDx, terminalDy);
		setAccelerations(d2x, d2y);
	}

	public void accelPosX() {
		accelPosX(getD2x());
	}
	
	public void accelPosX(double d2x) {
		setDx(getDx() + d2x);
		double ratio = d2x / getD2x();
		if (getDx() >= getTerminalDx() * ratio) setDx(getTerminalDx() * ratio);
	}

	public void decelPosX() {
		decelPosX(getD2x());
	}
	
	public void decelPosX(double d2x) {
		if (getDx() > 0) {
			setDx(getDx() - d2x);
			if (getDx() <= 0) setDx(0);
		}
	}
	
	public void accelNegX() {
		accelNegX(getD2x());
	}

	public void accelNegX(double d2x) {
		setDx(getDx() - d2x);
		double ratio = d2x / getD2x();
		if (getDx() <= -getTerminalDx() * ratio) setDx(-getTerminalDx() * ratio);
	}
	
	public void decelNegX() {
		decelNegX(getD2x());
	}

	public void decelNegX(double d2x) {
		if (getDx() < 0) {
			setDx(getDx() + d2x);
			if (getDx() >= 0) setDx(0);
		}
	}
	
	public void accelPosY() {
		accelPosY(getD2y());
	}

	public void accelPosY(double d2y) {
		setDy(getDy() + d2y);
		double ratio = d2y / getD2y();
		if (getDy() >= getTerminalDy() * ratio) setDy(getTerminalDy() * ratio);
	}
	
	public void decelPosY() {
		decelPosY(getD2y());
	}

	public void decelPosY(double d2y) {
		if (getDy() > 0) {
			setDy(getDy() - d2y);
			if (getDy() <= 0) setDy(0);
		}
	}
	
	public void accelNegY() {
		accelNegY(getD2y());
	}

	public void accelNegY(double d2y) {
		setDy(getDy() - d2y);
		double ratio = d2y / getD2y();
		if (getDy() <= -getTerminalDy() * ratio) setDy(-getTerminalDy() * ratio);
	}
	
	public void decelNegY() {
		decelNegY(getD2y());
	}

	public void decelNegY(double d2y) {
		if (getDy() < 0) {
			setDy(getDy() + d2y);
			if (getDy() >= 0) setDy(0);
		}
	}

	@Override
	public void update() {
		setX(getX() + getDx());
		setY(getY() + getDy());
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
		double sides = getWidth() / 5;
		g.setColor(Color.BLACK);
		g.fillRect((int) (getX() + sides), (int) (getY() + sides), (int) (getWidth() - sides * 2),
				(int) (getHeight() - sides * 2));
		debug(g);
	}
	
	public void debug(Graphics2D g) {
		if (GamePanel.DEBUGGING) {
			for (int i = 0; i < getFullBounds().size(); i++) {
				g.setColor(new Color(32 * i, 32 * i, 32 * i, 128));
				g.fill(getFullBounds().get(i));
			}
			g.setColor(new Color(255, 0, 255, 96));
			g.fill(getBounds());
		}
	}

	public void setPosition(double x, double y) {
		setX(x);
		setY(y);
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setDimensions(double width, double height) {
		setWidth(width);
		setHeight(height);
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setVelocities(double dx, double dy) {
		setDx(dx);
		setDy(dy);
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public void setTerminalVelocities(double terminalDx, double terminalDy) {
		setTerminalDx(terminalDx);
		setTerminalDy(terminalDy);
	}

	public void setTerminalDx(double terminalDx) {
		this.terminalDx = terminalDx;
	}

	public void setTerminalDy(double terminalDy) {
		this.terminalDy = terminalDy;
	}

	public void setAccelerations(double d2x, double d2y) {
		setD2x(d2x);
		setD2y(d2y);
	}

	public void setD2x(double d2x) {
		this.d2x = d2x;
	}

	public void setD2y(double d2y) {
		this.d2y = d2y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double getDx() {
		return dx;
	}

	public double getDy() {
		return dy;
	}

	public double getD2x() {
		return d2x;
	}

	public double getTerminalDx() {
		return terminalDx;
	}

	public double getTerminalDy() {
		return terminalDy;
	}

	public double getD2y() {
		return d2y;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, (int) width, (int) height);
	}

	public ArrayList<Rectangle> getFullBounds() {
		ArrayList<Rectangle> fullBounds = new ArrayList<Rectangle>(8);
		fullBounds.add(new Rectangle((int) getX(), (int) getY(), (int) (getWidth() / 5), (int) (getHeight() / 5)));
		fullBounds.add(new Rectangle((int) (getX() + getWidth() / 5), (int) getY(), (int) (getWidth() * 3 / 5),
				(int) (getHeight() / 5)));
		fullBounds.add(new Rectangle((int) (getX() + getWidth() * 4 / 5), (int) getY(), (int) (getWidth() / 5),
				(int) (getHeight() / 5)));
		fullBounds.add(new Rectangle((int) getX(), (int) (getY() + getHeight() / 5), (int) (getWidth() / 5),
				(int) getHeight() * 3 / 5));
		fullBounds.add(new Rectangle((int) (getX() + getWidth() * 4 / 5), (int) (getY() + getHeight() / 5),
				(int) (getWidth() / 5), (int) getHeight() * 3 / 5));
		fullBounds.add(new Rectangle((int) getX(), (int) (getY() + getHeight() * 4 / 5), (int) (getWidth() / 5),
				(int) (getHeight() / 5)));
		fullBounds.add(new Rectangle((int) (getX() + getWidth() / 5), (int) (getY() + getHeight() * 4 / 5),
				(int) (getWidth() * 3 / 5), (int) (getHeight() / 5)));
		fullBounds.add(new Rectangle((int) (getX() + getWidth() * 4 / 5), (int) (getY() + getHeight() * 4 / 5),
				(int) (getWidth() / 5), (int) (getHeight() / 5)));
		return fullBounds;
	}

	@Override
	public String toString() {
		return "Entity [x=" + x + ", y" + y + ", width=" + width + ", height=" + height + ", dx=" + dx + ", dy=" + dy
				+ ", terminalDx=" + terminalDx + ", terminalDy=" + terminalDy + ", d2x=" + d2x + ", d2y=" + d2y + "]";
	}
}
