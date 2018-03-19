package lab08g;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/08
//Class - APCSA
//Lab  - 08g

//import static java.lang.System.*;

public class LoopStats
{
	private int start, stop;

	public LoopStats()
	{
		setNums(0, 0);
	}

	public LoopStats(int beg, int end)
	{
		setNums(beg, end);
	}

	public void setNums(int beg, int end)
	{
		start = beg;
		stop = end;
	}

	public int getEvenCount()
	{
		int evenCount=0;
		for(int i = start; i < stop+1; i++) {
			if(i % 2 == 0) evenCount++;
		}
		return evenCount;
	}

	public int getOddCount()
	{
		int oddCount=0;
		for(int i = start; i < stop+1; i++) {
			if(i % 2 == 1) oddCount++;
		}
		return oddCount;
	}

	public int getTotal()
	{
		int total=0;
		for(int i = start; i < stop+1; i++) total+=i;
		return total;
	}
	
	public String toString()
	{
		return start + " " + stop;
	}
}