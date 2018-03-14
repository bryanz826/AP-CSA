package gradebook;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date -2018/3/13
//Class - APCSA
//Lab  - 19b

//import java.util.Arrays;
import java.util.Scanner;
//import static java.lang.System.*;
//import static java.util.Arrays.*;

public class Grades
{
	private double[] grades;
	
	public Grades()
	{
		setGrades("");
	}
	
	public Grades(String gradeList)
	{
		setGrades(gradeList);
	}
	
	public void setGrades(String gradeList)
	{
		Scanner scan = new Scanner(gradeList);
		grades = new double[scan.nextInt()];
		scan.next();
		for(int i = 0; i < grades.length; i++) {
			grades[i] = scan.nextDouble();
		}
		scan.close();
	}
	
	public void setGrade(int spot, double grade)
	{
		grades[spot] = grade;
	}
	
	public double getSum()
	{
		double sum=0.0;
		for(double item : grades) sum += item;
		return sum;
	}
	
	public double getLowGrade()
	{
		double low = Double.MAX_VALUE;
		for(double item : grades) {
			if(item < low) low = item;
		}
		return low;
	}
	
	public double getHighGrade()
	{
		double high = Double.MIN_VALUE;
		for(double item : grades) {
			if(item > high) high = item;
		}
		return high;
	}
	
	public int getNumGrades()
	{
		return grades.length;
	}
	
	public String toString()
	{
		String output="";
		for(double item : grades) output+= item + " ";
		return output;
	}	
}