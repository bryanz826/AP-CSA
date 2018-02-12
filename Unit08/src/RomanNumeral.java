//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/02/09
//Class - APCSA
//Lab  - 14i

import static java.lang.System.*;

public class RomanNumeral
{
	private Integer number;
	private String roman;

	private final static int[] NUMBERS= {1000,900,500,400,100,90,
													50,40,10,9,5,4,1};

	private final static String[] LETTERS = {"M","CM","D","CD","C","XC",
												  "L","XL","X","IX","V","IV","I"};

	public RomanNumeral(String str)
	{
		setRoman(str);
	}

	public RomanNumeral(Integer orig)
	{
		setNumber(orig);
	}

	public void setNumber(Integer num)
	{
		number = num;
	}

	public void setRoman(String rom)
	{
		roman = rom;
	}

	public Integer getNumber()
	{
		Integer output = 0;
		while (roman.length() > 0) {
			for (int i = 0; i < LETTERS.length; i++) {
				if(roman.startsWith(LETTERS[i])) {
					output+=NUMBERS[i];
					roman = roman.substring(LETTERS[i].length());
				}
			}
		}
		return output;
	}
	
	public String toString()
	{
		String output = "";
		for (int i = 0; i < NUMBERS.length; i++) {
			while(number >= NUMBERS[i]) {
				output+=LETTERS[i];
				number-= NUMBERS[i];
			}
		}
		return output + "\n";
	}
}