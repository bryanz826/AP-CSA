package lab22f;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/17
//Class - APCSA
//Lab  - 22f

import static java.lang.System.*;
import java.util.Arrays;		//use Arrays.toString() to help print out the array

public class QuickSort
{
	private static int passCount;

	public static void zeroPassCount() {passCount = 0;}
	
	@SuppressWarnings("rawtypes")
	public static void quickSort(Comparable[] list)
	{
		quickSort(list, 0, list.length-1);
	}


	@SuppressWarnings("rawtypes")
	private static void quickSort(Comparable[] list, int low, int high)
	{
		if(low < high) {
			int split = partition(list, low, high);
			quickSort(list, low, split);
			quickSort(list, split+1, high);
			out.println("pass " + passCount++ + " " + Arrays.toString(list));
		}
	}


	@SuppressWarnings({"rawtypes", "unchecked"})
	private static int partition(Comparable[] list, int low, int high)
	{
		Comparable<?> pivot = list[low];
		int bot = low-1;
		int top = high+1;
		while(bot < top) {
			while(list[--top].compareTo(pivot) > 0);
			while(list[++bot].compareTo(pivot) < 0);
			if(bot>=top)
				return top;
			Comparable<?> temp = list[bot];
			list[bot] = list[top];
			list[top] = temp;
		} return 0;
	}
}