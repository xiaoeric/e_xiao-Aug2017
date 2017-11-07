package fracCalc;

import java.util.Scanner;

/**
 * @author Eric Xiao
 * 
 */
public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	do
    	{
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
        if (first.indexOf('_') >= 0)
        {
        	firstWhole = Integer.parseInt(first.substring(0, first.indexOf('_')));
        	firstNumer = Integer.parseInt(first.substring(first.indexOf('_') + 1, first.indexOf('/')));
        	firstDenom = Integer.parseInt(first.substring(first.indexOf('/') + 1));
        }
        else if (first.indexOf('/') >= 0)
        {
        	firstNumer = Integer.parseInt(first.substring(0, first.indexOf('/')));
        	firstDenom = Integer.parseInt(first.substring(first.indexOf('/') + 1));
        }
        else
        {
        	firstWhole = Integer.parseInt(first);
        }
        
        int secondWhole = 0;
        int secondNumer = 0;
        int secondDenom = 1;
        if (second.indexOf('_') >= 0)
        {
        	secondWhole = Integer.parseInt(second.substring(0, second.indexOf('_')));
        	secondNumer = Integer.parseInt(second.substring(second.indexOf('_') + 1, second.indexOf('/')));
        	secondDenom = Integer.parseInt(second.substring(second.indexOf('/') + 1));
        }
        else if (second.indexOf('/') >= 0)
        {
        	secondNumer = Integer.parseInt(second.substring(0, second.indexOf('/')));
        	secondDenom = Integer.parseInt(second.substring(second.indexOf('/') + 1));
        }
        else
        {
        	secondWhole = Integer.parseInt(second);
        }
        
        String result = "";
        boolean hasFrac = firstNumer + secondNumer != 0;
        switch (operator)
        {
        	case "+":
        		result += (firstWhole + secondWhole);
        		if (hasFrac)
        		{
        			if(!isImproperFrac(addFrac(firstWhole, firstNumer, firstDenom, secondWhole, secondNumer, secondDenom)))
        				result += "_" + addFrac(firstWhole, firstNumer, firstDenom, secondWhole, secondNumer, secondDenom);
        			else
        			{
        				result += " + " + toMixedNum(addFrac(firstWhole, firstNumer, firstDenom, secondWhole, secondNumer, secondDenom));
        				result = produceAnswer(result);
        			}
        		}
        		break;
        	case "-":
        		result += (firstWhole - secondWhole);
        		if (hasFrac)
        		{
        			if(!isImproperFrac(subtractFrac(firstWhole, firstNumer, firstDenom, secondWhole, secondNumer, secondDenom)))
        				result += "_" + subtractFrac(firstWhole, firstNumer, firstDenom, secondWhole, secondNumer, secondDenom);
        			else
        			{
        				result += " - " + toMixedNum(subtractFrac(firstWhole, firstNumer, firstDenom, secondWhole, secondNumer, secondDenom));
        				result = produceAnswer(result);
        			}
        		}
        		break;
        	case "*":
        		if (!hasFrac)
        		{
        			result += (firstWhole * secondWhole);
        		}
        		else
        		{
        			if(!isImproperFrac(multiplyFrac(firstWhole, firstNumer, firstDenom, secondWhole, secondNumer, secondDenom)))
        				result += multiplyFrac(firstWhole, firstNumer, firstDenom, secondWhole, secondNumer, secondDenom);
        			else
        				result += toMixedNum(multiplyFrac(firstWhole, firstNumer, firstDenom, secondWhole, secondNumer, secondDenom));
        		}
        		break;
        	case "/":
        		if(!isImproperFrac(divideFrac(firstWhole, firstNumer, firstDenom, secondWhole, secondNumer, secondDenom)))
    				result += divideFrac(firstWhole, firstNumer, firstDenom, secondWhole, secondNumer, secondDenom);
    			else
    				result += toMixedNum(divideFrac(firstWhole, firstNumer, firstDenom, secondWhole, secondNumer, secondDenom));
        		break;
        }
        
        if (result.startsWith("0_"))
        	result = result.substring(2);
        
        return result;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String addFrac(int firstWhole, int firstNumer, int firstDenom, int secondWhole, int secondNumer, int secondDenom)
    {
    	int numer;
    	if (firstWhole < 0)
    		numer = -firstNumer * secondDenom;
    	else
    		numer = firstNumer * secondDenom;
    	if (secondWhole < 0)
    		numer += -secondNumer * firstDenom;
    	else
    		numer += secondNumer * firstDenom;
    	
    	int denom = (firstDenom * secondDenom);
    	
    	return reduce(Math.abs(numer), denom);
    }
    
    public static String subtractFrac(int firstWhole, int firstNumer, int firstDenom, int secondWhole, int secondNumer, int secondDenom)
    {
    	int numer;
    	if (firstWhole < 0)
    		numer = -firstNumer * secondDenom;
    	else
    		numer = firstNumer * secondDenom;
    	if (secondWhole < 0)
    		numer -= -secondNumer * firstDenom;
    	else
    		numer -= secondNumer * firstDenom;
    	
    	int denom = (firstDenom * secondDenom);
    	
    	return reduce(Math.abs(numer), denom);
    }
    
    public static String multiplyFrac(int firstWhole, int firstNumer, int firstDenom, int secondWhole, int secondNumer, int secondDenom)
    {
    	int numer;
    	if (firstWhole < 0)
    		numer = -firstNumer + firstWhole * firstDenom;
    	else
    		numer = firstNumer + firstWhole * firstDenom;
    	if (secondWhole < 0)
    		numer *= -secondNumer + secondWhole * secondDenom;
    	else
    		numer *= secondNumer + secondWhole * secondDenom;
    	
    	int denom = (firstDenom * secondDenom);
    	
    	return reduce(numer, denom);
    }
    
    public static String divideFrac(int firstWhole, int firstNumer, int firstDenom, int secondWhole, int secondNumer, int secondDenom)
    {
    	int numer;
    	if (firstWhole < 0)
    		numer = -firstNumer + firstWhole * firstDenom;
    	else
    		numer = firstNumer + firstWhole * firstDenom;
    	numer *= secondDenom;
    	
    	int denom;
    	if (secondWhole < 0)
    		denom = -secondNumer + secondWhole * secondDenom;
    	else
    		denom = secondNumer + secondWhole * secondDenom;
    	denom *= firstDenom;
    	
    	return reduce(numer, denom);
    }
    
    public static String reduce(int numer, int denom)
    {
    	if (denom < 0)
    	{
    		numer *= -1;
    		denom *= -1;
    	}
    	if (numer % denom != 0)
    	{
    		int gcf = gcf(numer, denom);
    		return (numer / gcf) + "/" + (denom / gcf);
    	}
    	else
    		return (numer / denom) + "";
    }
    
    public static String toMixedNum(String frac)
    {
    	String[] nums = frac.split("/");
    	int numer = Integer.parseInt(nums[0]);
    	int denom = Integer.parseInt(nums[1]);
    	
    	return (numer / denom) + "_" + numer % denom + "/" + denom;
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

    public static boolean isImproperFrac(String frac) {
    	String[] nums = frac.split("/");
    	if (nums.length > 1)
    	{
    		int numer = Integer.parseInt(nums[0]);
    		int denom = Integer.parseInt(nums[1]);
    	
    		if (numer > denom)
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	}
    	else
    		return false;
    }
}
