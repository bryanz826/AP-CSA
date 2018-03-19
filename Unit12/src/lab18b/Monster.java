package lab18b;


//import static java.lang.System.*;

public class Monster implements Comparable<Object>
{
	private int myHeight;
	private int myWeight;
	private int myAge;

	//write a default Constructor
	public Monster() {
		setHeight(0);
		setWeight(0);
		setAge(0);
	}


	//write an initialization constructor with an int parameter ht
	public Monster(int height) {
		setHeight(height);
	}


	//write an initialization constructor with int parameters ht and wt
	public Monster(int height, int weight) {
		setHeight(height);
		setWeight(weight);
	}
	



	//write an initialization constructor with int parameters ht, wt, and age
	public Monster(int height, int weight, int age) {
		setHeight(height);
		setWeight(weight);
		setAge(age);
	}


	//modifiers - write set methods for height, weight, and age
	public void setHeight(int height) {
		myHeight = height;
	}
	public void setWeight(int weight) {
		myWeight = weight;
	}
	public void setAge(int age) {
		myAge = age;
	}
	
	//accessors - write get methods for height, weight, and age
	public int getHeight() {
		return myHeight;
	}
	public int getWeight() {
		return myWeight;
	}
	public int getAge() {
		return myAge;
	}
	
	//creates a new copy of this Object
	public Object clone()
	{
	   return new Monster(myHeight, myWeight, myAge);
	}

	public boolean equals( Object obj )
	{
		Monster other = (Monster)obj;
		return myHeight == other.getHeight() && myWeight == other.getWeight() && myAge == other.getAge();
	}

	public int compareTo( Object obj )
	{
		Monster other = (Monster)obj;
		if(myHeight > other.getHeight()) return 1;
		else if(myHeight < other.getHeight()) return -1;
		
		if(myWeight > other.getWeight()) return 1;
		else if(myWeight < other.getWeight()) return -1;
		
		if(myAge > other.getAge()) return 1;
		else if(myAge < other.getAge()) return -1;
		
		return 0;
	}

	//write a toString() method
	public String toString() {
		return myHeight + " " + myWeight + " " + myAge;
	}
	
}