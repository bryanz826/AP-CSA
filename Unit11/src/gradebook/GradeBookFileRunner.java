package gradebook;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/14
//Class - APCSA
//Lab  - 19b

//import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
//import static java.util.Arrays.*;
import java.io.File;

public class GradeBookFileRunner
{
   public static void main( String args[] ) throws Exception
   {
		out.println("Welcome to the Class Stats program!\n\n");
		
		Scanner file = new Scanner(new File("D:\\Program Files\\csa\\readUnits (this is just for my reference)\\Unit11\\Unit11-2016\\Unit11-Assignments\\Lab19b\\gradebook.dat"));

		String className = file.nextLine();
		int classSize = Integer.parseInt(file.nextLine());

		Class test = new Class(className, classSize);
		for(int i = 0; i < classSize; i++) {
			String name = file.nextLine();
			String gradeList = file.nextLine();
			Student stu = new Student(name, gradeList);
			test.addStudent(i, stu);
		}
		
		out.println(test + "\n");
		test.sort();
		out.println(test + "\n");
		out.println("Failure List = " + test.getFailureList(70));
		out.println("Highest Average = " + test.getStudentWithHighestAverage());
		out.println("Lowest Average = " + test.getStudentWithLowestAverage());
		out.println("Class average = " + test.getClassAverage());
		file.close();
	}		
}