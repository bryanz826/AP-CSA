package test;

import java.util.Arrays;
import java.util.ArrayList;
import static java.lang.System.*;

public class Test {
	
	public void run(int x)
	{
		if(x>=1) {
			out.print(x);
			run(x-1);
		}
	}
	
	public int noob(int x, int y) {
		if(y==2)
			return x;
		else
			return noob(x, y-1) + x;
	}
	
	public String recur(String s) {    
		int len = s.length();    
		if(len>0)  
			return recur(s.substring(0,len-1)) +
					s.charAt(len-1);    
		return "";
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.run(5);
		out.println();
		out.println(t.noob(4,6));
	}
}
