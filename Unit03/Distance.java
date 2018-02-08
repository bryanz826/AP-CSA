//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/06
//Class - APCSA
//Lab - 03d

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Distance
{
	private int xOne,yOne,xTwo,yTwo;
	private double distance;

	public Distance()
	{
		xOne = 1;
		yOne = 1;
		xTwo = 2;
		yTwo = 1;
	}

	public Distance(int x1, int y1, int x2, int y2)
	{
		setCoordinates(x1, y1, x2, y2);
	}

	public void setCoordinates(int x1, int y1, int x2, int y2)
	{
		xOne = x1;
		yOne = y1;
		xTwo = x2;
		yTwo = y2;
	}

	public void calcDistance()
	{
		distance = Math.sqrt(Math.pow(xTwo-xOne, 2)+Math.pow(yTwo-yOne, 2));
	}

	public void print( )
	{
		String r = String.format("%.2f", distance);
		System.out.println("distance == "+r+"\n");
	}
}