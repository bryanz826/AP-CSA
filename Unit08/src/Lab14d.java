//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/09
//Class - APCSA
//Lab  - 14d

public class Lab14d
{
	public static void main( String args[] )
	{
		//add test cases;
		double[] a = {100,90,85,72.5,95.6};
		Grades g = new Grades(5, a);
		System.out.println(g);
		
		double[] b = {50.0,100.0,80.0};
		g.setNumber(3);
		g.setGrades(b);
		System.out.println(g);
		
		double[] c = {93.4,-90.0,90.0};
		g.setNumber(3);
		g.setGrades(c);
		System.out.println(g);
		
		double[] d = {1,2,3,4,5,6,7,8,9};
		g.setNumber(9);
		g.setGrades(d);
		System.out.println(g);		
	}
}