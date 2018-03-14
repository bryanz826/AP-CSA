//A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/14
//Class -  APCSA
//Lab  - 19a

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class Monster implements Comparable<Monster>
{
	private int weight;
	private int height;
	private int age;
	
	public Monster( int a, int h, int w )
	{
		age = a;
		height = h;
		weight = w;
	}

	public String toString()
	{
		return ""+ height + " " + weight + " " + age;
	}
	
	@Override
    public int compareTo(Monster o) {
        // usually toString should not be used,
        // instead one of the attributes or more in a comparator chain
        return toString().compareTo(o.toString());
    }
	
}