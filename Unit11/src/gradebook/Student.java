package gradebook;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date -2018/3/14
//Class - APCSA
//Lab  - 19b

//import java.util.Arrays;
//import java.util.Scanner;
//import static java.lang.System.*;
//import static java.util.Arrays.*;

public class Student implements Comparable<Student>
{
	private String myName;
	private Grades myGrades;
	
	public Student()
	{
		setName("");
		setGrades("");
	}
	
	public Student(String name, String gradeList)
	{
		setName(name);
		setGrades(gradeList);
	}
	
	public void setName(String name)
	{
		myName = name;
	}	
	
	public void setGrades(String gradeList)
	{
		myGrades = new Grades(gradeList);
	}
	
	public void setGrade(int spot, double grade)
	{
		myGrades.setGrade(spot, grade);
	}

	public String getName()
	{
		return myName;
	}
	
	public int getNumGrades()
	{
		return myGrades.getNumGrades();
	}

	public double getSum()
	{
		return myGrades.getSum();
	}
	
	public double getAverage()
	{
		return myGrades.getSum()/myGrades.getNumGrades();
	}

	public double getAverageMinusLow()
	{
		return (getSum() - getLowGrade())/(getNumGrades()-1);
	}
	
	public double getHighGrade()
	{
		return myGrades.getHighGrade();		
	}
	
	public double getLowGrade()
	{
		return myGrades.getLowGrade();	
	}
	
	public String toString()
	{
		return myName + " = " + myGrades;
	}

	@Override
	public int compareTo(Student stu) {
		return Integer.compare((int) this.getAverage(), (int) stu.getAverage());
	}
	public boolean equals(Student stu) {
		return this.getAverage() == stu.getAverage();
	}
}