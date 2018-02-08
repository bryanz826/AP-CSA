//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/06
//Class - APCSA
//Lab  - 02e

public class Lab02e
{
	public static void main( String[] args )
   {		
		Circle c = new Circle();
		
		//add test cases
		c.setRadius(1);
		c.calculateArea();
		c.print();
		
		c.setRadius(22.7);
		c.calculateArea();
		c.print();
		
		c.setRadius(3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706793);
		c.calculateArea();
		c.print();
		
		c.setRadius(69);
		c.calculateArea();
		c.print();
		
		c.setRadius(183.58);
		c.calculateArea();
		c.print();
	}
}