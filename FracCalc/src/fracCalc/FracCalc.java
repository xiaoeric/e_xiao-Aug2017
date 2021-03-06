package fracCalc;

import java.util.Scanner;

/**
 * @author Eric Xiao
 * @date 11/15/2017
 * @class APCS 2
 * @description
 * A calculator that supports mathematical operations
 * between fractions and mixed numbers
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

	/**
	 * Runs the FracCalc program and handles user input
	 */
    public static void main(String[] args) 
    {
    	Scanner console = new Scanner(System.in);
    	do
    	{
    	//Prompts user for expression
    	System.out.println("Please enter the expression to be resolved:");
    	String input = console.nextLine();
    	//Breaks loop when user types "quit"
    	if (input.equals("quit"))
    		break;
    	//Passes input to produceAnswer() and prints to console
    	System.out.println(produceAnswer(input));
    	} while(true);
    }
    
    /**
     * Performs calculations to produce an answer
     * @param input
     * The mathematical expression to be resolved
     * @return
     * The result of the mathematical expression
     */
    public static String produceAnswer(String input)
    { 
    	//Splits user input into array
        String[] terms = input.split(" ");
        String firstString = terms[0];
        String operator = terms[1];
        String secondString = terms[2];
        
        /*
         * Activates code to handle multiple operations
         * later on if multiple operations exist
         */
        boolean multiOp = false;
        if (terms.length > 3)
        	multiOp = true;
        
        //Receives output from parse()
        int[] firstTerm = parse(firstString);
        int[] secondTerm = parse(secondString);
        
        /*
         * Returns an error if the input contains a fraction
         * with a denominator of 0
         */
        if (firstTerm[2] == 0 || secondTerm[2] == 0)
        	return "Umm... why are you trying to divide by zero...?";
        
        //Initialize array to contain result of calculation
        int[] result = {0, 0, 1};
        
        /*
         * Switch statement checks operator and performs
         * corresponding calculations
         */
        switch (operator)
        {
        	case "+":
        		/*
        		 * Treats numerator as a negative number if
        		 * whole number is negative
        		 */
        		if (firstTerm[0] < 0)
        			result[1] = (firstTerm[0] * firstTerm[2] - firstTerm[1]) * secondTerm[2];
        		else
        			result[1] = (firstTerm[0] * firstTerm[2] + firstTerm[1]) * secondTerm[2];
        		
        		if (secondTerm[0] < 0)
        			result[1] += (secondTerm[0] * secondTerm[2] - secondTerm[1]) * firstTerm[2];
        		else
        			result[1] += (secondTerm[0] * secondTerm[2] + secondTerm[1]) * firstTerm[2];
        		
        		result[2] = firstTerm[2] * secondTerm[2];
        		break;
        	case "-":
        		if (firstTerm[0] < 0)
        			result[1] = (firstTerm[0] * firstTerm[2] - firstTerm[1]) * secondTerm[2];
        		else
        			result[1] = (firstTerm[0] * firstTerm[2] + firstTerm[1]) * secondTerm[2];
        		
        		if (secondTerm[0] < 0)
        			result[1] -= (secondTerm[0] * secondTerm[2] - secondTerm[1]) * firstTerm[2];
        		else
        			result[1] -= (secondTerm[0] * secondTerm[2] + secondTerm[1]) * firstTerm[2];
        		
        		result[2] = firstTerm[2] * secondTerm[2];
        		break;
        	case "*":
        		if (firstTerm[0] < 0)
        			result[1] = firstTerm[0] * firstTerm[2] - firstTerm[1];
        		else
        			result[1] = firstTerm[0] * firstTerm[2] + firstTerm[1];
        		
        		if (secondTerm[0] < 0)
        			result[1] *= secondTerm[0] * secondTerm[2] - secondTerm[1];
        		else
        			result[1] *= secondTerm[0] * secondTerm[2] + secondTerm[1];
        		
        		result[2] = firstTerm[2] * secondTerm[2];
        		break;
        	case "/":
        		if (firstTerm[0] < 0)
        			result[1] = (firstTerm[0] * firstTerm[2] - firstTerm[1]) * secondTerm[2];
        		else
        			result[1] = (firstTerm[0] * firstTerm[2] + firstTerm[1]) * secondTerm[2];
        		
        		if (secondTerm[0] < 0)
        			result[2] = (secondTerm[0] * secondTerm[2] - secondTerm[1]) * firstTerm[2];
        		else
        			result[2] = (secondTerm[0] * secondTerm[2] + secondTerm[1]) * firstTerm[2];
        		break;
        		
        	//Returns an error if user inputs an invalid operator
        	default:
        		return "Hey! That's an invalid format! Did you even pass elementary school math?!";
        }
        
        //Reduces the result of the calculations
        reduce(result);
        
        //Reformats the array into a String
        String resultString = reformat(result);
        
        /*
         * Appends the rest of the user input
         * and inserts back into produceAnswer()
         * if multiOp check passes
         */
        if (multiOp) {
        	String temp = resultString;
        	for(int i = 4; i < terms.length; i += 2)
        		temp += " " + terms[i - 1] + " " + terms[i];
        	resultString = produceAnswer(temp);
        }
        
        //Returns the final answer
        return resultString;
    }

    /**
     * Interprets user input into an array of ints
     * @param input
     * The mathematical term to be interpreted
     * @return
     * An array of integers representing the operand
     */
    public static int[] parse(String input)
    {
    	//Initializes with default values
    	int whole = 0;
        int numer = 0;
        int denom = 1;
        
        
        //Parses as a mixed number if "_" exists
        if (input.indexOf('_') >= 0)
        {
        	whole = Integer.parseInt(input.substring(0, input.indexOf('_')));
        	numer = Integer.parseInt(input.substring(input.indexOf('_') + 1, input.indexOf('/')));
        	denom = Integer.parseInt(input.substring(input.indexOf('/') + 1));
        }
        /*
         * Parses as a fraction if "/" exists
         * and does not contain "_"
         */
        else if (input.indexOf('/') >= 0)
        {
        	numer = Integer.parseInt(input.substring(0, input.indexOf('/')));
        	denom = Integer.parseInt(input.substring(input.indexOf('/') + 1));
        }
        /*
         * Parses as a whole number if neither
         * "_" nor "/" exist
         */
        else
        	whole = Integer.parseInt(input);
        
        //Initializes return array with the parse results
        int[] arr = {whole, numer, denom};
        
        //Returns array
        return arr;
    }
    
    /**
     * Manipulates an array to simplify it
     * @param arr
     * The array of ints representing a number
     * to be simplified
     */
    public static void reduce(int[] arr)
    {
    	/*
    	 * Transfers the negative sign from the
    	 * denominator to the numerator
    	 */
    	if (arr[2] < 0)
    	{
    		arr[1] *= -1;
    		arr[2] *= -1;
    	}
    	
    	/*
    	 * Reduces the improper fraction and
    	 * adds to whole number
    	 */
    	arr[0] = arr[1] / arr[2];
    	arr[1] %= arr[2];
    	
    	/*
    	 * Finds the greatest common factor
    	 * to reduce the fraction
    	 */
    	int gcf = gcf(arr[1], arr[2]);
    	arr[1] /= gcf;
    	arr[2] /= gcf;
    	
    	/*
    	 * Removes negative sign from numerator
    	 */
    	if (arr[0] < 0 && arr[1] < 0)
    		arr[1] *= -1;
    }
    
    /**
     * Builds a String and trims it for
     * formatting conventions
     * @param arr
     * The array representing a number
     * @return
     * A String representing a number
     */
    public static String reformat(int[] arr)
    {
    	/*
    	 * Constructs a String using whole number,
    	 * numerator, and denominator
    	 */
    	String input = arr[0] + "_" + arr[1] + "/" + arr[2];

    	//Delete "0_" if it exists
    	if (input.startsWith("0_"))
        	input = input.substring(2);
    	
    	//Trim off fraction part if numerator is 0
    	if (input.indexOf("_0/") > 0)
    		input = input.substring(0, input.indexOf("_0/"));
    	/*
    	 * Entire String should be 0 if number is a fraction
    	 * and numerator is 0
    	 */
    	else if (input.indexOf("0/") == 0)
    		input = "0";
    	
    	//Trim off /1 if still remaining
    	if (input.endsWith("/1"))
    		input = input.substring(0, input.length() - 2);
    	
    	//Return reformatted String
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
