/*
*  DAY 4:
* 
*  Given an array of integers, find the first missing positive integer 
*  in linear time (O(n)) and constant space (O(1)). In other words, find the 
*  lowest positive integer that does not exist in the array. The array can
*  contain duplicates and negative numbers as well.
*
*  For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should 
*  give 3.
*
*  You can modify the input array in-place.
*/

import java.util.*;

public class Day4 {
	public static void main(String[] args) {
		int[] arr = {1, 1};

		System.out.println(lowestMissing(arr));
	}

	
	public static int lowestMissing(int[] arr) {
		// Seperate positive and negative numbers so positive are at front
		int endFree = arr.length-1;
		int temp;
		for  (int i = 0; i < arr.length; i++) {

			if (arr[i] <= 0) {
				// Find positive val closest to end
				while (arr[endFree] <= 0 && endFree > i+1) {
					endFree--;
				} 
				// Swap the positive and non positive
				temp = arr[i]; // -1
				arr[i] = arr[endFree]; // arr[2] = 1
				arr[endFree] = temp; // arr[3] = -1
			}
		}

		// Find number of positives
		int numPositives = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= 0) {
				break;
			}
			numPositives++;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("\n" + numPositives);

		// Iterate through list, making index value negative to show that it is present
		for (int i = 0; i < numPositives; i++) {
			int value = Math.abs(arr[i]);

			// Make index of value negative
			if (value - 1 < numPositives) {
				arr[value - 1] = - Math.abs(arr[value - 1]);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("\n");

		// Find the lowest non negative
		for (int i = 0; i < numPositives; i++) {
			if (arr[i] > 0) {
				return i+1;
			}
		}

		return numPositives + 1;
	}
}