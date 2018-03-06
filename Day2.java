/*
*  DAY 2:
* 
*  Given an array of integers, return a new array such that each element at index i 
*  of the new array is the product of all the numbers in the original array except 
*  the one at i. Solve it without using division and in O(n) time.
* 
*  For example, if our input was [1, 2, 3, 4, 5], the expected output would be 
*  [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be 
*  [2, 3, 6]. 
*/

public class Day2 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};

		int[] output = productOutput(arr);

		System.out.print("[");
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i]);
			if (i != output.length-1) {
				System.out.print(", ");
			}
		}
		System.out.print("]\n");

	}

	public static int[] productOutput(int[] arr) {

		int[] left = new int[arr.length + 1];
		int[] right = new int[arr.length + 1];
		left[0] = 1;
		right[arr.length-1] = 1;

		int[] output = new int[arr.length];


		for (int i = 0; i < arr.length; i++) {
			left[i + 1] = left[i] * arr[i];
		}

		for (int i = arr.length-2; i >= 0; i--) {
			right[i] = right[i+1] * arr[i+1];
		}

		for (int i = 0; i < arr.length; i++) {
			output[i] = left[i] * right[i];
		}

		return output;
	}
}