//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/08
//Class - APCSA
//Lab  - 08i

//import static java.lang.System.*;
import java.lang.Math;

public class Prime
{
	private int number;

	public Prime()
	{
		setPrime(0);
	}

	public Prime(int num)
	{
		setPrime(num);
	}

	public void setPrime(int num)
	{
		number = num;
	}

	public boolean isPrime()
	{
		for(int i = 2; i < Math.pow(number, 0.5); i++) {
			if(number % i == 0) return false;
		}
		return true;
	}

	public String toString()
	{
		String output="";
		if(isPrime()) output+=number+" is prime.\n";
		else output+=number+" is not prime.\n";
		return output;
	}
}