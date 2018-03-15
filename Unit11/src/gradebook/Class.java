package gradebook;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date -2018/3/14
//Class - APCSA
//Lab  - 19b

//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Scanner;
//import static java.lang.System.*;
//import static java.util.Arrays.*;
import java.util.ArrayList;
import java.util.Collections;

public class Class
{
	private String name;
	private ArrayList<Student> studentList;
	
	public Class()
	{
		name = "";
		studentList = new ArrayList<Student>();
	}
	
	public Class(String name, int stuCount)
	{
		this.name = name;
		studentList = new ArrayList<Student>(stuCount);
	}
	
	public void addStudent(int stuNum, Student s)
	{
		studentList.add(stuNum, s);
	}
	
	public String getClassName()
	{
	   return this.name;
	}
	
	public double getClassAverage()
	{
		double classAverage=0.0;
		for(int i = 0; i < studentList.size(); i++) classAverage+=getStudentAverage(i);
		return classAverage/studentList.size();
	}
	
	public double getStudentAverage(int stuNum)
	{
		return studentList.get(stuNum).getAverage();
	}

	public double getStudentAverage(String stuName)
	{
		for(int i = 0; i < studentList.size(); i++) {
			if (getStudentName(i) == stuName) return studentList.get(i).getAverage();
		}
		return 0.0;
	}
	
	public String getStudentName(int stuNum)
	{
		return studentList.get(stuNum).getName();
	}

	public String getStudentWithHighestAverage()
	{
		double high = Double.MIN_VALUE;
		String hName ="";
		for (int i = 0; i < studentList.size(); i++){
			if (getStudentAverage(i) > high){
				high = getStudentAverage(i);
				hName = getStudentName(i);
			}
		}
		return hName;
	}

	public String getStudentWithLowestAverage()
	{
		double low = Double.MAX_VALUE;
		String lName ="";
		for (int i = 0; i < studentList.size(); i++){
			if (getStudentAverage(i) < low){
				low = getStudentAverage(i);
				lName = getStudentName(i);
			}
		}
		return lName;
	}
	
	public String getFailureList(double failingGrade)
	{
		String output="";
		for(int i = 0; i < studentList.size(); i++)
			if(getStudentAverage(i) < failingGrade) output+=getStudentName(i)+" ";
		return output;
	}
	
	public String toString()
	{
		String output=""+getClassName()+"\n";
		for(int i = 0; i < studentList.size(); i++) 
			output+=studentList.get(i) + "\t" + String.format("%.2f", getStudentAverage(i))+"\n";
		return output;
	}  	
	public void sort(){
		Collections.sort(studentList);
	}
}