
public class Magpie2 {

	//Get a default greeting and return a greeting	
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * takes in a user statement
	 * returns a response based on given rules
	 */
	public String getResponse(String statement) {
		String response = "";
		if (statement.trim().length() == 0) {
			response = "... Are you gonna say something?";
		} else if (statement.indexOf("no") >= 0) {
			response = "Why so negative?";
		} else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0) {
			response = "Tell me more about your family.";
		} else if (statement.indexOf("Louie") >= 0
				|| statement.indexOf("Dreyer") >= 0
				|| statement.indexOf("Cotter") >= 0
				|| statement.indexOf("Battaglini") >= 0) {
			response = "Wow she sounds like a great teacher!";
		} else if (statement.indexOf("Jackson") >= 0
				|| statement.indexOf("Phillips") >= 0) {
			response = "Wow he sounds like a great teacher!";
		} else if (statement.indexOf("happy") >= 0) {
			response = ":)";
		} else if (statement.indexOf("sad") >= 0) {
			response = ":(";
		} else if (statement.indexOf("angry") >= 0) {
			response = ">:O";
		} else {
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * returns a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		} else if (whichResponse == 4) {
			response = "Ok.";
		} else if (whichResponse == 5) {
			response = "Alright.";
		}

		return response;
	}
}
