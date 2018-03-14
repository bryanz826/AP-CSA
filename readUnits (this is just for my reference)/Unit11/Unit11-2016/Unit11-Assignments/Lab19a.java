//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

public class Lab19a {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(in);

		out.print("How many monsters are in the herd? :: ");
		int size = keyboard.nextInt();
		Monsters herd = new Monsters(size);

		for (int i = 0; i < size; i++) {
			// read in monster values
			// ask for ht
			out.print("\n Enter the ht :: ");
			int ht = keyboard.nextInt();

			// ask for wt
			out.print("\n Enter the wt :: ");
			int wt = keyboard.nextInt();

			// ask for age
			out.print("\n Enter the age :: ");
			int age = keyboard.nextInt();

			// instantiate a new Monster() and add it to the herd
			herd.add(i, new Monster(ht, wt, age));
			out.println("\n");

		}

		System.out.println("HERD :: " + herd + "\n");
		// print out the other stats
		out.println("SMALLEST :: " + herd.getSmallest());
		out.println("LARGEST :: " + herd.getLargest());

	}
}