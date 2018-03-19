package lab22f;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/17
//Class - APCSA
//Lab  - 22f

public class Lab22f
{
	public static void main(String args[])
	{
		QuickSort.quickSort(new Comparable[]{9,5,3,2});
		System.out.println("\n");
		
		QuickSort.zeroPassCount();
		QuickSort.quickSort(new Comparable[]{19,52,3,2,7,21});
		System.out.println("\n");
		
		QuickSort.zeroPassCount();
		QuickSort.quickSort(new Comparable[]{68,66,11,2,42,31});
	}
}


