//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;

public class Monsters {
	// use an ArrayList for extra credit!!!
	// private ArrayList<Monster> myMonsters;

	private Monster[] myMonsters;

	public Monsters() {
		setMonsters(0);
	}

	public Monsters(int size) {
		setMonsters(size);

	}

	public void setMonsters(int size) {
		// size the array
		myMonsters = new Monster[size];

	}

	public void add(int spot, Monster m) {
		// put m in the Monster array at [spot]
		if (spot < myMonsters.length)
			myMonsters[spot] = m;
	}

	public Monster get(int spot) {
		return myMonsters[spot];
	}

	public Monster getLargest() {
		// Arrays.sort() might be handy
		Arrays.sort(myMonsters);
		return myMonsters[myMonsters.length - 1];
	}

	public Monster getSmallest() {
		// Arrays.sort() might be handy
		Arrays.sort(myMonsters);
		return myMonsters[0];
	}

	@Override
	public String toString() {
		return "" + Arrays.toString(myMonsters);
	}
}