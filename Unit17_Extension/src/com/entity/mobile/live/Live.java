package com.entity.mobile.live;

import java.awt.Graphics2D;

import com.animations.Animations;
import com.entity.mobile.Mobile;
import com.utils.Reference;

public abstract class Live extends Mobile
{
	private int		hp;
	private int		iHp;

	private double	terminal_dx;
	private double	terminal_dy;

	public Live(double x, double y, double terminal_dx, double terminal_dy, int hp)
	{
		this(x, y, 35, 35, terminal_dx, terminal_dy, hp);
	}

	public Live(double x, double y, double w, double h, double terminal_dx, double terminal_dy, int hp)
	{
		super(x, y, w, h, 0, 0);
		setHp(hp);
		setTerminal_dx(terminal_dx);
		setTerminal_dy(terminal_dy);
		iHp = hp;
	}

	@Override
	public void ddx(double ddx) {
		super.ddx(ddx);
		if (getDx() <= -getTerminal_dx()) setDx(-getTerminal_dx());
		else if (getDx() >= getTerminal_dx()) setDx(getTerminal_dx());
	}

	@Override
	public void ddy(double ddy) {
		super.ddy(ddy);
		if (getDy() <= -getTerminal_dy()) setDy(-getTerminal_dy());
		else if (getDy() >= getTerminal_dy()) setDy(getTerminal_dy());
	}

	public void slowNegX(double ddx) {
		if (getDx() > 0) {
			super.ddx(ddx);
			if (getDx() <= 0) setDx(0);
		}
	}

	public void slowPosX(double ddx) {
		if (getDx() < 0) {
			super.ddx(ddx);
			if (getDx() >= 0) setDx(0);
		}
	}

	public void slowNegY(double ddy) {
		if (getDy() > 0) {
			super.ddy(ddy);
			if (getDy() <= 0) setDy(0);
		}
	}

	public void slowPosY(double ddy) {
		if (getDy() < 0) {
			super.ddy(ddy);
			if (getDy() >= 0) setDy(0);
		}
	}

	public void update(Animations animations) {
		super.update();
	}

	@Override
	public void render(Graphics2D g) {
		super.render(g);
		getBounds().DEBUG(g);
	}

	@Override
	public void setImage(String fileName) {
		super.setImage(Reference.ENTITY_LOC + fileName);
	}

	public void setTerminal_dx(double terminal_dx) {
		this.terminal_dx = terminal_dx;
	}

	public void setTerminal_dy(double terminal_dy) {
		this.terminal_dy = terminal_dy;
	}

	public double getTerminal_dx() {
		return terminal_dx;
	}

	public double getTerminal_dy() {
		return terminal_dy;
	}

	public boolean checkDeath() {
		return hp <= 0;
	}

	public void decHp(int damage) {
		hp -= damage;
	}

	public void incHp(int hp) {
		this.hp += hp;
		if (this.hp > iHp) this.hp = iHp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHp() {
		return hp;
	}
}
