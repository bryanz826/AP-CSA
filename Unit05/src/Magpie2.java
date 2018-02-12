/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if(statement.trim().length()==1)
		{
				response = "Say something more than just '"+statement+"', please.";
		}
		else if(statement.trim().length()==0)
		{
			response = "...";
		}
		else if(statement.indexOf("wow") >= 0)
		{
			response = "I too, am amused.";
		}
		else if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if(statement.indexOf("yes") >= 0)
		{
			response = "Yes!";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if(statement.indexOf("dog") >= 0
				|| statement.indexOf("cat") >= 0)
		{
			response = "Tell me more about your pets.";
		}
		else if(statement.indexOf("Mauro") >= 0) {
			response = "I've heard of him. He's awesome.";
		}
		else if(statement.indexOf("because") >= 0
				|| statement.indexOf("cuz") >= 0
				|| statement.indexOf("cus ") >= 0)
		{
			response = "I don't need an explanation.";
		}
		else if(statement.indexOf("hi") >= 0
				|| statement.indexOf("ello") >= 0
				|| statement.indexOf("sup") >= 0
				|| statement.indexOf("ni hao") >= 0) 
		{
			response = "Greetings, earthling.";
		}
		else if(statement.length() >= 15)
		{
			response = "Slow down, please.";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}

		return response;
	}
}
