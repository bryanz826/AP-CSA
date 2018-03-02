//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/09
//Class - APCSA
//Lab  - 11j

//import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{
		setNum(num);
	}

	public void setNum(int num)
	{
		number = num;
	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		while(b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public String toString()
	{
		String output="";
		for (int a = 0; a < number; a++) {
			for (int b = 0; b < number; b++) {
				for (int c = 0; c < number; c++) {
					if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
						if(a % 2 == 0 && b % 2 == 1 || a % 2 == 1 && b % 2 == 0) {
							if(greatestCommonFactor(a,b,c) == 1) {
								if(a <= b && b < c) {
									output+= a +" "+ b +" "+ c + "\n";
								}
							}
						}
					}
				}				
			}
		}
		return output+"\n";
	}
}