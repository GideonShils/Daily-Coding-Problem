/*
*  DAY 1:
* 
*  Given an array of numbers, return whether any two sums to K.
*
*  For example, given [10, 15, 3, 7] and K of 17, return true since 10 + 7 is 17.
*/

import java.util.*;

public class Day1 {
	public static void main(String[] args) {
		int[] arr = {10, 15, 3, 7};

		System.out.println(twoSum(arr, 17));
	}

	public static boolean twoSum(int[] nums, int k) {
		HashSet<Integer> map = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (map.contains(k - nums[i])) {
                return true;
			} else {
                map.add(nums[i]);
			}
		}
        
        return false;
	}
}