package gradebook;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date -2018/3/13
//Class - APCSA
//Lab  - 19b

import java.util.ArrayList;
//import java.util.Scanner;
//import static java.lang.System.*;
//import static java.util.Arrays.*;

public class Grades
{
	private ArrayList<Double> grades;
	
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
		gradeList = gradeList.substring(4);
		grades = new ArrayList<Double>();
		String[] temp = gradeList.split(" ");
		for(String item : temp) grades.add(Double.parseDouble(item));
	}
	
	public void setGrade(int spot, double grade)
	{
		grades.set(spot, grade);
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
		return grades.size();
	}
	
	public String toString()
	{
		String output="";
		for(double item : grades) output+= item + " ";
		return output;
	}	
}