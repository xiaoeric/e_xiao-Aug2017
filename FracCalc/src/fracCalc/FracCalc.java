package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	do {
    	Scanner console = new Scanner(System.in);
    	String input = console.nextLine();
    	if (input.equals("quit"))
    		break;
    	System.out.println(produceAnswer(input));
    	} while(true);
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
        String[] terms = input.split(" ");
        String first = terms[0];
        String operator = terms[1];
        String second = terms[2];
        
        int firstWhole = 0;
        int firstNumer = 0;
        int firstDenom = 1;
        if (first.indexOf('_') >= 0) {
        	firstWhole = Integer.parseInt(first.substring(0, first.indexOf('_')));
        	firstNumer = Integer.parseInt(first.substring(first.indexOf('_') + 1, first.indexOf('/')));
        	firstDenom = Integer.parseInt(first.substring(first.indexOf('/') + 1));
        } else if (first.indexOf('/') >= 0) {
        	firstNumer = Integer.parseInt(first.substring(0, first.indexOf('/')));
        	firstDenom = Integer.parseInt(first.substring(first.indexOf('/') + 1));
        } else {
        	firstWhole = Integer.parseInt(first);
        }
        String firstParsed = "whole:" + firstWhole
        					+ " numerator:" + firstNumer
        					+ " denominator:" + firstDenom;
        
        int secondWhole = 0;
        int secondNumer = 0;
        int secondDenom = 1;
        if (second.indexOf('_') >= 0) {
        	secondWhole = Integer.parseInt(second.substring(0, second.indexOf('_')));
        	secondNumer = Integer.parseInt(second.substring(second.indexOf('_') + 1, second.indexOf('/')));
        	secondDenom = Integer.parseInt(second.substring(second.indexOf('/') + 1));
        } else if (second.indexOf('/') >= 0) {
        	secondNumer = Integer.parseInt(second.substring(0, second.indexOf('/')));
        	secondDenom = Integer.parseInt(second.substring(second.indexOf('/') + 1));
        } else {
        	secondWhole = Integer.parseInt(second);
        }
        String secondParsed = "whole:" + secondWhole
        					+ " numerator:" + secondNumer
        					+ " denominator:" + secondDenom;
        
        return secondParsed;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
