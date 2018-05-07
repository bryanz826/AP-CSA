public class Test {
	
	private static boolean noob = false;
	
	public static void main(String[] args) {
		AnotherTest at = new AnotherTest();
		at.nigerian(noob);
		System.out.println(noob);
		/**
		 * passed by value idiot
		 */
	}
}

class AnotherTest {
	
	public void nigerian(boolean noob) {
		noob = true;
	}
}