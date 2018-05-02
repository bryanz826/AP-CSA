import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture()
	{
		/*
		 * not needed but use it to show students the implicit call to super() child
		 * constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName)
	{
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width)
	{
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture)
	{
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image)
	{
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName, height
	 *         and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of the
	 * picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple() {
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++) {

				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in the
	 * current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++)
		{
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++)
			{
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/** Method to create a collage of several pictures */
	public void createCollage() {
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		for (int row = 0; row < pixels.length - 1; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				if (leftPixel.colorDistance(rightPixel.getColor()) > edgeDist) leftPixel.setColor(Color.BLACK);
				else leftPixel.setColor(Color.WHITE);
			}
		}
	}

	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args) {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

	public void keepOnlyBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}
	}

	public void keepOnlyRed() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setGreen(0);
				pixelObj.setBlue(0);
			}
		}
	}

	public void keepOnlyGreen() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(0);
				pixelObj.setBlue(0);
			}
		}
	}

	public void negate() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setRed(255 - pixelObj.getRed());
				pixelObj.setGreen(255 - pixelObj.getGreen());
				pixelObj.setBlue(255 - pixelObj.getBlue());
			}
		}
	}

	public void grayscale() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				double avg = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3.0;
				pixelObj.setRed((int) avg);
				pixelObj.setGreen((int) avg);
				pixelObj.setBlue((int) avg);
			}
		}
	}

	public void fixUnderwater() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				if (pixelObj.getBlue() > pixelObj.getGreen() && pixelObj.getBlue() > pixelObj.getRed())
					pixelObj.setGreen(255);
			}
		}
	}

	public void mirrorArms() {
		int mirror = 220;
		Pixel origUpperPixel = null;
		Pixel newLowerPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		for (int row = 159; row < 194; row++) {
			for (int col = 104; col < 170; col++) {
				origUpperPixel = pixels[row][col];
				newLowerPixel = pixels[mirror - row + mirror][col];
				newLowerPixel.setColor(origUpperPixel.getColor());
			}

			for (int col = 239; col < 295; col++) {
				origUpperPixel = pixels[row][col];
				newLowerPixel = pixels[mirror - row + mirror][col];
				newLowerPixel.setColor(origUpperPixel.getColor());
			}
		}
	}

	public void mirrorGull() {
		int mirror = 350;
		Pixel origLeftPixel = null;
		Pixel newRightPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		for (int row = 230; row < 327; row++) {
			for (int col = 230; col < 348; col++) {
				origLeftPixel = pixels[row][col];
				newRightPixel = pixels[row][mirror - col + mirror];
				newRightPixel.setColor(origLeftPixel.getColor());
			}
		}
	}

	public void mirrorDiagonal() {
		Pixel origPixel = null;
		Pixel newPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				if (col < pixels.length) {
					origPixel = pixels[col][row];
					newPixel = pixels[row][col];
					newPixel.setColor(origPixel.getColor());
				}
			}
		}
	}

	public void edgeDetection2(int edgeDist) {
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		for (int row = 0; row < pixels.length - 1; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				topPixel = pixels[row][col];
				bottomPixel = pixels[row + 1][col];
				if (leftPixel.colorDistance(rightPixel.getColor()) > edgeDist
						|| topPixel.colorDistance(bottomPixel.getColor()) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else leftPixel.setColor(Color.WHITE);
			}
		}
	}

	public void chromakey(Picture newPic, Color color, int allowance) {
		Pixel[][] pixels = this.getPixels2D();
		Pixel[][] newPixels = newPic.getPixels2D();
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				if ((Math.abs(pixels[row][col].getRed() - color.getRed()) < allowance)
						&& (Math.abs(pixels[row][col].getGreen() - color.getGreen()) < allowance)
						&& (Math.abs(pixels[row][col].getBlue() - color.getBlue()) < allowance))
				{
					pixels[row][col].setColor(newPixels[row][col].getColor());
				}
			}
		}
	}

	public void encodeAndDecode(String imagePath) {
		String base64Image = "";
		File file = new File("./images/" + imagePath);
		try (FileInputStream imageInFile = new FileInputStream(file)) {
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);
			System.out.println(base64Image);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageByteArray));
			setBufferedImage(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getCountRedOverValue(int n) {
		Pixel[][] pixels = this.getPixels2D();
		int count = 0;
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				if (pixelObj.getRed() > n) count++;
			}
		}
		return count;
	}

	public void setRedToHalfValueInTopHalf() {
		Pixel[][] pixels = this.getPixels2D();
		for (int row = 0; row < pixels.length / 2; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				pixels[row][col].setRed(pixels[row][col].getRed() / 2);
			}
		}
	}

	public void clearBlueOverValue(int n) {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				if (pixelObj.getBlue() > n) pixelObj.setBlue(0);
			}
		}
	}

	public String getAverageForColumn(int n) {
		Pixel[][] pixels = this.getPixels2D();
		int totalRed = 0;
		int totalBlue = 0;
		int totalGreen = 0;
		for (int i = 0; i < pixels.length; i++) {
			totalRed += pixels[i][n].getRed();
			totalGreen += pixels[i][n].getGreen();
			totalBlue += pixels[i][n].getBlue();
		}
		return String.format("(%s, %s, %s)", totalRed / pixels.length, totalGreen / pixels.length,
				totalBlue / pixels.length);
	}

	public void sharpen(int x, int y, int w, int h) {
		System.out.println("Bryan Zhang\nPeriod 2\n2018/4/24\n38");

		if (x == 0) x += 1;
		if (y == 0) y += 1;

		Pixel[][] pixels = this.getPixels2D();
		for (int row = y; row < h; row++) {
			for (int col = x; col < w; col++) {
				System.out.println(row + ", " + col);
				Pixel currPixel = pixels[row][col];
				Pixel newPixel = pixels[row - 1][col - 1];

				currPixel.setRed(currPixel.getRed() + (currPixel.getRed() - newPixel.getRed()) / 2);
				if (currPixel.getRed() > 255) currPixel.setRed(255);
				else if (currPixel.getRed() < 0) currPixel.setRed(0);

				currPixel.setBlue(currPixel.getBlue() + (currPixel.getBlue() - newPixel.getBlue()) / 2);
				if (currPixel.getBlue() > 255) currPixel.setBlue(255);
				else if (currPixel.getBlue() < 0) currPixel.setBlue(0);

				currPixel.setGreen(currPixel.getGreen() + (currPixel.getGreen() - newPixel.getGreen()) / 2);
				if (currPixel.getGreen() > 255) currPixel.setGreen(255);
				else if (currPixel.getGreen() < 0) currPixel.setGreen(255);
			}
		}
	}

	public void transparenify() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				int i = 30;
				if (pixelObj.getRed() < i && pixelObj.getBlue() < i && pixelObj.getGreen() < i) {
					pixelObj.setRed(255 - pixelObj.getRed());
					pixelObj.setBlue(255 - pixelObj.getBlue());
					pixelObj.setGreen(255 - pixelObj.getGreen());
					pixelObj.setAlpha((pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen()) / 3);
				}
			}
		}
	}

} // this is the end of class Picture, put all new methods before this
