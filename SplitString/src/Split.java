public class Split {
	public static void main(String[] args) {
		// Your task Part 0
		//String.split();
		//It's a method that acts on a string, <StringName>.split(<String sp>);
		//Where sp is the string where the string splits
		//And it returns an array
		// Example: "I like apples!".split(" "); 
		// it will split at spaces and return an array of ["I","like","apples!"]
		// Example 2: "I really like really red apples".split("really")
		// it will split at the word "really" and return an array of ["I "," like "," red apples!"]
		//play around with String.split! 
		//What happens if you "I reallyreally likeapples".split("really") ?
		
		String mySandwich = "applespineapplesbreadlettustomatobaconmayohambreadcheese";
		System.out.println(splitSandwich(mySandwich));
		
		String mySandwichWithSpaces = "apples pineapples bread lettus tomato bacon mayo ham bread cheese";
		System.out.println(splitSpacedSandwich(mySandwichWithSpaces));
		
		String exampleSandwich = "bread tomato bacon ham lettus bread";
		System.out.println(splitSpacedSandwich(exampleSandwich));
		
		String moreBread = "bread bread bread bread bread";
		System.out.println(splitSpacedSandwich(moreBread));
	}

	//Your task Part 1:
	/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
	* use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
	* What if it's a fancy sandwich with multiple pieces of bread?
	*/
	public static String splitSandwich(String sandwich) {
		String[] sansBread = sandwich.split("bread");
		String contents = "";
		for(int i = 1; i < sansBread.length - 1; i++) {
			contents += sansBread[i];
		}
		return contents;
	}

	//Your task Part 2:
	/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
	* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
	* Again, what if it's a fancy sandwich with multiple pieces of bread?
	*/
	public static String splitSpacedSandwich(String sandwich) {
		String[] items = sandwich.split(" ");
		int firstBread = 0;
		for(int i = 0; i < items.length; i++) {
			if(items[i].equals("bread")) {
				firstBread = i;
				break;
			}
		}
		int lastBread = 0;
		for(int i = items.length - 1; i > -1; i--) {
			if(items[i].equals("bread")) {
				lastBread = i;
				break;
			}
		}
		String contents = "";
		for(int i = firstBread + 1; i < lastBread; i++) {
			contents += items[i] + " ";
		}
		return contents;
	}
}