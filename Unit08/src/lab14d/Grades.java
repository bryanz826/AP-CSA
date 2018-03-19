package lab14d;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/09
//Class - APCSA
//Lab  - 14d

//import java.lang.System;
//import java.lang.Math;
//import java.util.Scanner;

public class Grades
{
	//instance variables
	private int number;
	private double[] grades;

	//constructor
	public Grades(int num, double[] grade) {
		setNumber(num);
		setGrades(grade);
	}

	//set methods
	public void setNumber(int num) {
		number = num;
	}
	
	public void setGrades(double[] grade) {
		grades = grade;
	}


	private double getSum()
	{
		double sum=0.0;
		for (int i = 0; i < number; i++) {
			sum += grades[i];
		}
		return sum;
	}

	public double getAverage()
	{
		double average=0.0;
		average+=getSum()/number;
		return average;
	}


	//toString method
	public String toString() {
		String output = "";
		for (int i = 0; i < number; i++) {
			String d = String.format("%.2f", grades[i]);
			output+="Grade "+i+" :: "+d+"\n";
		}
		output+="\naverage = "+String.format("%.2f", getAverage());
		return output+"\n\n";
	}


}