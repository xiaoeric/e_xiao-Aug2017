package fracCalc;

import java.util.Scanner;

/**
 * @author Eric Xiao
 * @date 11/15/2017
 * @class APCS 2
 * @pseudocode
 * main(){
 * 	create scanner object
 * 	do while true loop{
 * 		take user input;
 * 		if input is "quit" break loop;
 * 		pass input to produceAnswer() and print;
 * 	}
 * }
 * produceAnswer(){
 * 	create array of terms by splitting at spaces;
 * 	first term is String at first index;
 * 	operator is String at second index;
 * 	second term is String at third index;
 * 	pass first and second terms to parse();
 * 	create return String and result numerator
 * 	and denominator ints;
 * 	switch checks operator String{
 * 		addition
 * 			convert both to improper frac and 
 * 			multiply for common denominator;
 * 			add numerators;
 * 		subtraction
 * 			convert both to improper frac and 
 * 			multiply for common denominator;
 * 			subtract numerators;
 * 		multiplication
 * 			convert both to improper frac; 
 * 			multiply numerators together;
 * 			multiply denominators together;
 * 		division
 * 			convert both to improper frac; 
 * 			multiply first numerator and second denominator;
 * 			multiply second numerator and first denominator;
 * 	}
 * 	pass result String to reduce() and reassign to result;
 * 	pass result String to reformat() and reassign to result;
 * 	return result String;
 * }
 * parse(){
 * 	create and initialize ints for whole, numerator, and
 * 	denominator;
 * 	if input contains "_"
 * 		input is mixed, parse around "_" and "/";
 * 	else if input contains "/" but not "_"
 * 		input is a fraction, parse around "/";
 * 	else
 * 		parse input as whole number;
 * 	create return int[] and initialize with whole, numerator, and
 * 	denominator ints;
 * 	return int[];
 * }
 * reduce(){
 * 	parse String around "/" into numerator and denominator ints;
 * 	if denominator is negative
 * 		make denominator positive and invert numerator;
 * 	int whole is numerator / denominator;
 * 	numerator is reassigned as remainder of numerator / denominator;
 * 	find gcf by passing numerator and denominator to gcf();
 * 	divide both numerator and denominator by gcf and reassign;
 * 	if both whole and numerator are negative
 * 		invert numerator;
 * 	return whole, numerator, and denominator as mixed number;
 * }
 * reformat(){
 * 	if input starts with "0_"
 * 		remove "0_";
 * 	if input contains but does not start with "_0/"
 * 		remove "_0/" and everything following;
 * 	else if starts with "0/"
 * 		reassign input to "0";
 * 	if input ends with "/1"
 * 		remove "/1";
 * 	return input String;
 * }
 * gcf and isDivisibleBy copied from Calculate Library
 */
public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner console = new Scanner(System.in);
    	do
    	{
    	System.out.println("Please enter the expression to be resolved:");
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
        String firstString = terms[0];
        String operator = terms[1];
        String secondString = terms[2];
        
        boolean multiOp = false;
        if (terms.length > 3)
        	multiOp = true;
        
        int[] firstTerm = parse(firstString);
        int[] secondTerm = parse(secondString);
        
        if (firstTerm[2] == 0 || secondTerm[2] == 0)
        	return "Umm... why are you trying to divide by zero...?";
        
        int[] result = {0, 0, 1};
        int numer;
        int denom;
        switch (operator)
        {
        	case "+":
        		if (firstTerm[0] < 0)
        			numer = (firstTerm[0] * firstTerm[2] - firstTerm[1]) * secondTerm[2];
        		else
        			numer = (firstTerm[0] * firstTerm[2] + firstTerm[1]) * secondTerm[2];
        		
        		if (secondTerm[0] < 0)
        			numer += (secondTerm[0] * secondTerm[2] - secondTerm[1]) * firstTerm[2];
        		else
        			numer += (secondTerm[0] * secondTerm[2] + secondTerm[1]) * firstTerm[2];
        		
        		denom = firstTerm[2] * secondTerm[2];
        		
        		result[1] = numer;
        		result[2] = denom;
        		break;
        	case "-":
        		if (firstTerm[0] < 0)
        			numer = (firstTerm[0] * firstTerm[2] - firstTerm[1]) * secondTerm[2];
        		else
        			numer = (firstTerm[0] * firstTerm[2] + firstTerm[1]) * secondTerm[2];
        		
        		if (secondTerm[0] < 0)
        			numer -= (secondTerm[0] * secondTerm[2] - secondTerm[1]) * firstTerm[2];
        		else
        			numer -= (secondTerm[0] * secondTerm[2] + secondTerm[1]) * firstTerm[2];
        		
        		denom = firstTerm[2] * secondTerm[2];
        		
        		result[1] = numer;
        		result[2] = denom;
        		break;
        	case "*":
        		if (firstTerm[0] < 0)
        			numer = firstTerm[0] * firstTerm[2] - firstTerm[1];
        		else
        			numer = firstTerm[0] * firstTerm[2] + firstTerm[1];
        		
        		if (secondTerm[0] < 0)
        			numer *= secondTerm[0] * secondTerm[2] - secondTerm[1];
        		else
        			numer *= secondTerm[0] * secondTerm[2] + secondTerm[1];
        		
        		denom = firstTerm[2] * secondTerm[2];
        		
        		result[1] = numer;
        		result[2] = denom;
        		break;
        	case "/":
        		if (firstTerm[0] < 0)
        			numer = (firstTerm[0] * firstTerm[2] - firstTerm[1]) * secondTerm[2];
        		else
        			numer = (firstTerm[0] * firstTerm[2] + firstTerm[1]) * secondTerm[2];
        		
        		if (secondTerm[0] < 0)
        			denom = (secondTerm[0] * secondTerm[2] - secondTerm[1]) * firstTerm[2];
        		else
        			denom = (secondTerm[0] * secondTerm[2] + secondTerm[1]) * firstTerm[2];

        		result[1] = numer;
        		result[2] = denom;
        		break;
        	default:
        		return "Hey! That's an invalid format! Did you even pass elementary school math?!";
        }
        
        reduce(result);
        String resultString = reformat(result);
        
        if (multiOp) {
        	String temp = resultString;
        	for(int i = 4; i < terms.length; i += 2)
        		temp += " " + terms[i - 1] + " " + terms[i];
        	resultString = produceAnswer(temp);
        }
        
        return resultString;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static int[] parse(String input)
    {
    	int whole = 0;
        int numer = 0;
        int denom = 1;
        if (input.indexOf('_') >= 0)
        {
        	whole = Integer.parseInt(input.substring(0, input.indexOf('_')));
        	numer = Integer.parseInt(input.substring(input.indexOf('_') + 1, input.indexOf('/')));
        	denom = Integer.parseInt(input.substring(input.indexOf('/') + 1));
        }
        else if (input.indexOf('/') >= 0)
        {
        	numer = Integer.parseInt(input.substring(0, input.indexOf('/')));
        	denom = Integer.parseInt(input.substring(input.indexOf('/') + 1));
        }
        else
        {
        	whole = Integer.parseInt(input);
        }
        int[] arr = {whole, numer, denom};
        return arr;
    }
    
    public static void reduce(int[] arr)
    {
    	if (arr[2] < 0)
    	{
    		arr[1] *= -1;
    		arr[2] *= -1;
    	}
    	
    	arr[0] = arr[1] / arr[2];
    	arr[1] %= arr[2];
    	
    	int gcf = gcf(arr[1], arr[2]);
    	arr[1] /= gcf;
    	arr[2] /= gcf;
    	
    	if (arr[0] < 0 && arr[1] < 0)
    		arr[1] *= -1;
    }
    
    public static String reformat(int[] arr)
    {
    	String input = arr[0] + "_" + arr[1] + "/" + arr[2];

    	if (input.startsWith("0_"))
        	input = input.substring(2);
    	
    	if (input.indexOf("_0/") > 0)
    		input = input.substring(0, input.indexOf("_0/"));
    	else if (input.indexOf("0/") == 0)
    		input = "0";
    	
    	if (input.endsWith("/1"))
    		input = input.substring(0, input.length() - 2);
    	
    	return input;
    }

    public static int gcf(int num1, int num2) {
		/* i is declared before the for loop because
		 * it must be returned after the loop.
		 */
		int i;
		/* i can be initialized as either of
		 * the two inputs because any number
		 * greater than the smaller of the two
		 * is inherently invalid. The for loop
		 * continues while one of the numbers
		 * is not divisible by i.
		 */
		num1 = Math.abs(num1);
		num2 = Math.abs(num2);
		for(i = num2; !(isDivisibleBy(num2, i) && isDivisibleBy(num1, i)); i--) {}
		return i;
	}
    
    public static boolean isDivisibleBy(int dividend, int divisor) {
		/* An IllegalArgumentException will be thrown when the divisor
		 * is 0 because you cannot divide by 0.
		 */
		if(divisor == 0) {
			throw new IllegalArgumentException();
		}
		if(dividend % divisor == 0) {
			return true;
		} else {
			return false;
		}
	}
}
