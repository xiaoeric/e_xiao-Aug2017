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
		System.out.println("strMain is: " + strMain + " according to main before changeMe");
		System.out.println("First number of the array is: " + arrMain[0] + " according to main before changeMe");
		System.out.println();
		
		changeMe(num, strMain, arrMain);
		
		System.out.println("num is: " + num + " according to changeMe");
		System.out.println("strMain is: " + strMain + " according to changeMe");
		System.out.println("First number of the array is: " + arrMain[0] + " according to main after changeMe");
	}
	
	/**
	 * Only arrMain[] changes in the main method when it is passed through
	 * changeMe because, in contrast to num and strMain, the reference to
	 * arrMain is passed to the method. With num and strMain, only the value
	 * of the variable is passed to the method, not the reference to the location
	 * of the data in memory. 
	 */
	public static void changeMe(int x, String str, int[] arr) {
		System.out.println("Changing...!");
		
		x++;
		System.out.println("num is: " + x + " according to changeMe");
		
		str += " period 2";
		System.out.println("strMain is: " + str + " according to changeMe");
		
		arr[0] = 6;
		System.out.println("First number of the array is: " + arr[0] + " according to changeMe");
		System.out.println();
	}
}
