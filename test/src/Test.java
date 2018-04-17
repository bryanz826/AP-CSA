

import static java.lang.System.out;

public class Test {
	
	
	public void run(int x)
	{
		out.println(1000/60);
	}
	
	public int noob(int x) {
		return x/2;
	}
	
	public String recur(String s) {    
		int len = s.length();    
		if(len>0)  
			return recur(s.substring(0,len-1)) +
					s.charAt(len-1);    
		return "";
	}
	
	public static void main(String[] args) {
		int x = 50;
		
		Test t = new Test();
		t.run(5);
		out.println();
		out.println(t.noob(x));
		out.println(x);
	}
}
