package com.entity;

import com.manager.Bounds;

public interface Locatable
{
	public void setPos(double x, double y);

	public void setX(double x);

	public void setY(double y);

	public void setDims(double w, double h);

	public void setWidth(double w);

	public void setHeight(double h);
	
	public double getX();

	public double getY();

	public double getWidth();

	public double getHeight();
	
	public Bounds getBounds();
}
