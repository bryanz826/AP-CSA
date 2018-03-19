package lab02f;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/06
//Class - APCSA
//Lab  - 02f

public class Lab02f
{
	public static void main( String[] args )
   {
		Line l = new Line(0,0,0,0);
		
		//add test cases
		l.setCoordinates(1,2,3,4);
		l.calculateSlope();
		l.print();
		
		l.setCoordinates(1,9,14,2);
		l.calculateSlope();
		l.print();
		
		l.setCoordinates(19,686,354,23);
		l.calculateSlope();
		l.print();
		
		l.setCoordinates(4,894894,38486,21);
		l.calculateSlope();
		l.print();
		
		l.setCoordinates(51,7,56436,7);
		l.calculateSlope();
		l.print();
	}
}