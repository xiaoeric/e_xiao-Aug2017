import java.util.Arrays;

/**
 * @author Eric Xiao
 * @date 11/1/2017
 * @class APCS 2
 * Contains and runs methods that manipulate arrays
 */
public class ArraysLab3 {
	public static int[] sum(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length];
		for(int i = 0; i < result.length; i++) {
			result[i] = arr1[i] + arr2[i];
		}
		return result;
	}
	
	public static int[] append(int[] arr, int num) {
		int[] result = new int[arr.length + 1];
		for(int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		result[result.length - 1] = num;
		return result;
	}
	
	public static int[] remove(int[] arr, int idx) {
		int[] result = new int[arr.length - 1];
		int counter = 0;
		for(int i = 0; i < arr.length; i++) {
			if(i != idx) {
				result[counter] = arr[i];
				counter++;
			}
		}
		return result;
	}
	
	public static int sumEven(int[] arr) {
		int result = 0;
		for(int i = 0; i < arr.length; i += 2) {
			result += arr[i];
		}
		return result;
	}
	
	public static void rotateRight(int[] arr) {
		int temp = arr[arr.length - 1];
		for(int i = arr.length - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;
	}
	
	public static void main(String[] args) {
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		
		int[] sumArr = sum(a1, a2);
		
		int appendNum = 200;
		int[] appendArr = append(a1, appendNum);
		
		int removeIdx = 5;
		int[] removeArr = remove(a2, removeIdx);
		
		int sumOfEvens = sumEven(appendArr);
		
		rotateRight(a1);
		
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		System.out.println(Arrays.toString(a1));
	}
}
