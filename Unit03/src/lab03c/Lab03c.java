package lab03c;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/06
//Class - APCSA
//Lab - 03c

import java.util.Scanner;
//import static java.lang.System.*;
//import static java.lang.Math.*;

public class Lab03c
{
	public static void main( String[] args )
   {
		Scanner scan = new Scanner(System.in);
		Quadratic q = new Quadratic();
		
		//add test cases
		System.out.print("Enter a :: ");
		int a1 = scan.nextInt();
		System.out.print("Enter b :: ");
		int b1 = scan.nextInt();
		System.out.print("Enter c :: ");
		int c1 = scan.nextInt();

		q.setEquation(a1, b1, c1);
		q.calcRoots();
		q.print();
		
		
		System.out.print("Enter a :: ");
		int a2 = scan.nextInt();
		System.out.print("Enter b :: ");
		int b2 = scan.nextInt();
		System.out.print("Enter c :: ");
		int c2 = scan.nextInt();

		q.setEquation(a2, b2, c2);
		q.calcRoots();
		q.print();
		
		
		System.out.print("Enter a :: ");
		int a3 = scan.nextInt();
		System.out.print("Enter b :: ");
		int b3 = scan.nextInt();
		System.out.print("Enter c :: ");
		int c3 = scan.nextInt();
		
		q.setEquation(a3, b3, c3);
		q.calcRoots();
		q.print();
		
		scan.close();
   }
}