package lab02e;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/06
//Class - APCSA
//Lab  - 02e

public class Circle
{
	private double radius;
	private double area;

	public void setRadius(double rad){
		radius = rad;
	}

	public void calculateArea( ){
		area = radius * radius * 3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706793;
	}

	public void print( ) {
		String r = String.format("%.3f",area);
		System.out.println("The area is :: "+r);
	}
}