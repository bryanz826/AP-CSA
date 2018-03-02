//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/07
//Class - APCSA
//Lab  - 04d

//import static java.lang.System.*;

public class Name
{
	private String name;

	public Name()
	{
		setName("");
	}

	public Name(String s)
	{
		setName(s);
	}

	public void setName(String s)
	{
		name = s;
	}

	public String getFirst()
	{
		return name.substring(0, name.indexOf(" "));
	}

	public String getLast()
	{
		return name.substring(name.indexOf(" ")+1);
	}

 	public String toString()
 	{
 		String output = "";
 		output+=name+"\n\n";
 		return output;
	}
}