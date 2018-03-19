package lab02f;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/06
//Class - APCSA
//Lab  - 02f

public class Line
{
	private double xOne,yOne, xTwo, yTwo;
	private double slope;

	public Line(int x1, int y1, int x2, int y2){
		setCoordinates(x1, y1, x2, y2);
	}

	public void setCoordinates(int x1, int y1, int x2, int y2){
		xOne = x1;
		yOne = y1;
		xTwo = x2;
		yTwo = y2;
	}

	public void calculateSlope( ){
		slope = (yTwo-yOne)/(xTwo-xOne);
	}

	public void print( ){
		String r = String.format("%.3f",slope);
		System.out.println("The slope is "+r);
	}
}