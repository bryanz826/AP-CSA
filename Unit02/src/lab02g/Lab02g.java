package lab02g;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/06
//Class - APCSA
//Lab  - 02g

public class Lab02g
{
	public static void main( String[] args )
	{
		Fahrenheit x = new Fahrenheit();
		//add test cases		
		x.setFahrenheit(72.00);
		x.getCelsius();
		x.print();
		
		x.setFahrenheit(354.00);
		x.getCelsius();
		x.print();
		
		x.setFahrenheit(0.00);
		x.getCelsius();
		x.print();
		
		x.setFahrenheit(75.00);
		x.getCelsius();
		x.print();
		
		x.setFahrenheit(46.68);
		x.getCelsius();
		x.print();
	}
}