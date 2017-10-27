
public class LotsOfCopies {
	public static void main(String[] args) {
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4, 5};
		
		changeMe(num, strMain, arrMain);
		System.out.println("First number of the array is: " + arrMain[0] + " according to main");
	}
	public static void changeMe(int x, String str, int[] arr) {
		arr[0] = x;
		System.out.println("First number of the array is: " + arr[0] + " according to changeMe");
	}
}
