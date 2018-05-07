package com.entities;

import com.utils.Reference;

public abstract class Living extends Entity
{
	private int hp;
	private int initialHp;

	public Living(double x, double y, double terminal_dx, double terminal_dy, double d2x, double d2y, int hp,
			String fileName)
	{
		this(x, y, 25, 25, terminal_dx, terminal_dy, d2x, d2y, hp, fileName);
	}

	public Living(double x, double y, double width, double height, double terminal_dx, double terminal_dy, double d2x,
			double d2y, int hp, String fileName)
	{
		super(x, y, width, height, terminal_dx, terminal_dy, fileName);
		setHp(hp);
		initialHp = hp;
	}
	
	public void heal(int hp) {
		this.hp += hp;
		if (this.hp > initialHp) this.hp = initialHp;
	}
	
	public void damage(int damage) {
		hp -= damage;
	}
	
	public boolean isDead() {
		return hp <= 0;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getHp() {
		return hp;
	}
	
	@Override
	public void setImage(String fileName) {
		super.setImage(Reference.ENTITY_LOC + fileName);
	}
}
