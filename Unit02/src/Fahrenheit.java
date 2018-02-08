//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/06
//Class - APCSA
//Lab  - 02g

public class Fahrenheit
{
	private double fahrenheit;

	public void setFahrenheit(double fahren){
		fahrenheit = fahren;
	}

	public double getCelsius(){
		double celsius = 0.0;
		//add code to convert fahrenheit to celsius
		celsius = fahrenheit * 9/5.00 + 32;
		return celsius;
	}

	public void print() {
		String r = String.format("%.2f", getCelsius());
		System.out.println(fahrenheit+" degrees Fahrenheit == "+r+" degrees Celsius");
	}
}