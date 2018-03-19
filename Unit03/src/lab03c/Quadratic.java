package lab03c;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/06
//Class - APCSA
//Lab - 03c

//import java.util.Scanner;
//import static java.lang.System.*;
//import static java.lang.Math.*;

public class Quadratic
{
	private int a, b, c;
	private Double rootOne;
	private Double rootTwo;

	public Quadratic()
	{
		a = 1;
		b = 2;
		c = 1;
	}

	public Quadratic(int quadA, int quadB, int quadC)
	{
		setEquation(quadA, quadB, quadC);
	}

	public void setEquation(int quadA, int quadB, int quadC)
	{
		a = quadA;
		b = quadB;
		c = quadC;
 	}

	public void calcRoots( )
	{
		rootOne = (-b+(Math.sqrt(Math.pow(b, 2)-4.0*a*c)))/2.0/a;
		rootTwo = (-b-(Math.sqrt(Math.pow(b, 2)-4.0*a*c)))/2.0/a;
	}

	public void print( )
	{
		String r1 = String.format("%.2f", rootOne);
		String r2 = String.format("%.2f", rootTwo);
		if(rootOne.isNaN()) System.out.println("\nComplex roots involved...\n\n");
		else{
			System.out.println("\nroot one :: "+r1);
			System.out.println("root two :: "+r2+"\n\n");
		}
	}
}