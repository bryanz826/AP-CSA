//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/09
//Class - APCSA
//Lab  - 11c

//import static java.lang.System.*;

public class TriangleThree
{
   private int size;
   private String letter;

	public TriangleThree()
	{
		this(0,"");
	}

	public TriangleThree(int count, String let)
	{
		setTriangle(count, let);
	}

	public void setTriangle( int sz, String let )
	{
		size = sz;
		letter = let;
	}

	public String getLetter()
	{
		return letter;
	}

	public String toString()
	{
		String output="";
		for (int i = size; i >= 0; i--) {
			for (int j = i; j > 0; j--) {
				output+=" ";
			}
			for (int j = size; j > i; j--) {
				output+= getLetter();
			}
			output+="\n";
		}
		return output+"\n";
	}
}