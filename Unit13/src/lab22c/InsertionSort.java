package lab22c;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/17
//Class -  APCSA
//Lab  - 22c

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//import static java.lang.System.*;

class InsertionSort
{
	private ArrayList<String> list;

	public InsertionSort()
	{
		list = new ArrayList<String>();
	}

	//modifiers
	public void add(String  word)
	{
		int loc = Collections.binarySearch(list, word);
		if(loc < 0) list.add(Math.abs((loc+1)), word);
	}


	public void remove(String word)
	{
		for(String l : list) if(word.equals(l)) list.remove(word);
	}

	public String toString()
	{
		return Arrays.toString(list.toArray());
	}
}