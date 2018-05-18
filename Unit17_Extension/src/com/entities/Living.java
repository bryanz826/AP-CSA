package com.entities;

import com.animations.DynamicAnimation;

public abstract class Living extends Entity
{
	private int hp;
	private int initialHp;

	public Living(float x, float y, float terminalDx, float terminalDy, float d2x, float d2y, int hp,
			DynamicAnimation anim)
	{
		this(x, y, 25, 25, terminalDx, terminalDy, d2x, d2y, hp, anim);
	}

	public Living(float x, float y, float width, float height, float terminalDx, float terminalDy, float d2x,
			float d2y, int hp, DynamicAnimation anim)
	{
		super(x, y, width, height, terminalDx, terminalDy, d2x, d2y, anim);
		setHp(hp);
		initialHp = hp;
	}
	
	public abstract void actionOnDeath();
	
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
	
	public void incHp(int hp) {
		this.hp += hp;
	}
	
	public void decHp(int hp) {
		this.hp -= hp;
	}
	
	public int getHp() {
		return hp;
	}
	
	public int getInitialHp() {
		return initialHp;
	}
}
