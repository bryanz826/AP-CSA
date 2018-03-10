package ElevensWithArrayList;
/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] rank = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suit = {"Spades", "Clubs", "Diamonds", "Hearts"};
		int[] pointValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		Deck d = new Deck(rank, suit, pointValue);
		
		System.out.println("Size: " + d.size());
		System.out.println("Empty Status: " + d.isEmpty());
		System.out.println("First card dealt: " + d.deal());
		System.out.println();
		System.out.println(d);
	}
}
