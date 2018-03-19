package lab03d;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/06
//Class - APCSA
//Lab - 03d

import java.util.Scanner;
//import static java.lang.System.*;
//import static java.lang.Math.*;

public class Lab03d
{
	public static void main( String[] args )
	{
		Scanner scan = new Scanner(System.in);
		Distance d = new Distance();
		
		//add test cases
		System.out.print("Enter X1 :: ");
		int x11 = scan.nextInt();
		System.out.print("Enter Y1 :: ");
		int y11 = scan.nextInt();
		System.out.print("Enter X2 :: ");
		int x21 = scan.nextInt();
		System.out.print("Enter Y2 :: ");
		int y21 = scan.nextInt();

		d.setCoordinates(x11, y11, x21, y21);
		d.calcDistance();
		d.print();
		
		
		System.out.print("Enter X1 :: ");
		int x12 = scan.nextInt();
		System.out.print("Enter Y1 :: ");
		int y12 = scan.nextInt();
		System.out.print("Enter X2 :: ");
		int x22 = scan.nextInt();
		System.out.print("Enter Y2 :: ");
		int y22 = scan.nextInt();

		d.setCoordinates(x12, y12, x22, y22);
		d.calcDistance();
		d.print();
		
		System.out.print("Enter X1 :: ");
		int x13 = scan.nextInt();
		System.out.print("Enter Y1 :: ");
		int y13 = scan.nextInt();
		System.out.print("Enter X2 :: ");
		int x23 = scan.nextInt();
		System.out.print("Enter Y2 :: ");
		int y23 = scan.nextInt();

		d.setCoordinates(x13, y13, x23, y23);
		d.calcDistance();
		d.print();
		
		scan.close();
	}
}