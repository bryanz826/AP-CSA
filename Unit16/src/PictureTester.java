import java.awt.Color;

/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Barbara Ericson
 */
public class PictureTester {
	/** Method to test zeroBlue */
	public static void testZeroBlue() {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

	/** Method to test mirrorVertical */
	public static void testMirrorVertical() {
		Picture caterpillar = new Picture("caterpillar.jpg");
		caterpillar.explore();
		caterpillar.mirrorVertical();
		caterpillar.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple() {
		Picture temple = new Picture("temple.jpg");
		temple.explore();
		temple.mirrorTemple();
		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage() {
		Picture canvas = new Picture("640x480.jpg");
		canvas.createCollage();
		canvas.explore();
	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection() {
		Picture swan = new Picture("swan.jpg");
		swan.explore();
		swan.edgeDetection(10);
		swan.explore();
	}

	/**
	 * Main method for testing. Every class can have a main method in Java
	 */
	public static void main(String[] args) {
		// uncomment a call here to run a test
		// and comment out the ones you don't want
		// to run
//		testZeroBlue();
//		testKeepOnlyBlue();
//		testKeepOnlyRed();
//		testKeepOnlyGreen();
//		testNegate();
//		testGrayscale();
//		testFixUnderwater();
//		testMirrorVertical();
//		testMirrorTemple();
//		testMirrorArms();
//		testMirrorGull();
//		testMirrorDiagonal();
//		testCollage();
//		testCopy();
//		testEdgeDetection();
//		testEdgeDetection2();
//		testChromakey();
		testEncodeAndDecode();
//		testGetCountRedOverValue(250);
//		testSetRedToHalfValueInTopHalf();
//		testClearBlueOverValue(200);
//		testGetAverageForColumn(0);
	}

	public static void testKeepOnlyBlue() {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.keepOnlyBlue();
		beach.explore();
	}

	public static void testKeepOnlyRed() {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.keepOnlyRed();
		beach.explore();
	}

	public static void testKeepOnlyGreen() {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.keepOnlyGreen();
		beach.explore();
	}

	public static void testNegate() {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.negate();
		beach.explore();
	}

	public static void testGrayscale() {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.grayscale();
		beach.explore();
	}

	public static void testFixUnderwater() {
		Picture water = new Picture("water.jpg");
		water.explore();
		water.fixUnderwater();
		water.explore();
	}

	public static void testMirrorArms() {
		Picture snowman = new Picture("snowman.jpg");
		snowman.explore();
		snowman.mirrorArms();
		snowman.explore();
	}

	public static void testMirrorGull() {
		Picture seagull = new Picture("seagull.jpg");
		seagull.explore();
		seagull.mirrorGull();
		seagull.explore();
	}

	public static void testMirrorDiagonal() {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.mirrorDiagonal();
		beach.explore();
	}

	public static void testCopy() {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.copy(beach, 0, 320);
		beach.explore();
	}

	public static void testEdgeDetection2() {
		Picture swan = new Picture("swan.jpg");
		swan.explore();
		swan.edgeDetection2(10);
		swan.explore();
	}

	public static void testChromakey() {
		Picture cat = new Picture("caterpillar.jpg");
		cat.explore();
		cat.chromakey(new Picture("koala.jpg"), new Color(255, 255 ,255), 100);
		cat.explore();		
	}
	
	public static void testEncodeAndDecode() {
		Picture beach = new Picture("beach.jpg");
		beach.encodeAndDecode("seagull.jpg");
		
//		after encoding and decoding 'seagull.jpg', beach's image 'beach.jpg' is
//		set to newly decoded seagull image to show that the decoding works
		
		beach.explore();
	}

	public static void testGetCountRedOverValue(int n) {
		Picture beach = new Picture("beach.jpg");
		System.out.println(beach.getCountRedOverValue(n));
	}

	public static void testSetRedToHalfValueInTopHalf() {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.setRedToHalfValueInTopHalf();
		beach.explore();
	}

	public static void testClearBlueOverValue(int n) {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.clearBlueOverValue(n);
		beach.explore();
	}

	public static void testGetAverageForColumn(int n) {
		Picture beach = new Picture("beach.jpg");
		System.out.println(beach.getAverageForColumn(n));
	}
}