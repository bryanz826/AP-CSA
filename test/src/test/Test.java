package test;

import java.util.ArrayList;
import static java.lang.System.*;

public class Test {
	
	public void run(int x)
	{
		if(x<5) run(x+1);
		out.println(x);
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
		out.println(t.recur("abc"));
	}
}
