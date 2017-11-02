/**
 * @author Eric Xiao
 * @date 11/1/2017
 * @class APCS 2
 * Experimenting with passing by value and passing by reference
 */
public class LotsOfCopies {
	public static void main(String[] args) {
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4, 5};
		
		System.out.println("num is: " + num + " according to main before changeMe");
		System.out.println("strMain is: \"" + strMain + "\" according to main before changeMe");
		System.out.println("First number of the array is: " + arrMain[0] + " according to main before changeMe");
		System.out.println();
		/*
		 * num is: 7 according to main before changeMe
		 * strMain is: "APCS" according to main before changeMe
		 * First number of the array is: 1 according to main before changeMe
		 */
		
		changeMe(num, strMain, arrMain);
		/*
		 * Changing...!
		 * num is: 8 according to changeMe
		 * strMain is: "APCS period 2" according to changeMe
		 * First number of the array is: 6 according to changeMe
		 */
		
		System.out.println("num is: " + num + " according to main after changeMe");
		System.out.println("strMain is: \"" + strMain + "\" according to main after changeMe");
		System.out.println("First number of the array is: " + arrMain[0] + " according to main after changeMe");
		/*
		 * num is: 7 according to main after changeMe
		 * strMain is: "APCS" according to main after changeMe
		 * First number of the array is: 6 according to main after changeMe
		 */
	}
	
	/**
	 * Only arrMain[] changes in the main method when it is passed through
	 * changeMe because, in contrast to num and strMain, the reference to
	 * arrMain is passed to the method. With num and strMain, only the value
	 * of the variable is passed to the method, not the reference to the location
	 * of the data in memory. 
	 */
	public static void changeMe(int x, String str, int[] arr) {
		//Part 1
		System.out.println("Changing...!");
		
		x++;
		System.out.println("num is: " + x + " according to changeMe");
		
		str += " period 2";
		System.out.println("strMain is: \"" + str + "\" according to changeMe");
		
		arr[0] = 6;
		System.out.println("First number of the array is: " + arr[0] + " according to changeMe");
		System.out.println();
		
		//Part 2
		x = 3;
		int bInt = x;
		x = 23;
		System.out.println("The value of bInt is: " + bInt);
		
		str = "Hello";
		String bString = str;
		str = "World";
		System.out.println("The value of bString is: \"" + bString + "\"");
		
		arr[0] = 2;
		int[] bArr = arr;
		arr[0] = 3;
		System.out.println("The value of the first number of bArr is: " + bArr[0]);
		System.out.println();
	}
}
