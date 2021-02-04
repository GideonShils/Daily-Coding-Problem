/*
*  DAY 2:
* 
*  Given an array of integers, return a new array such that each element at index i of the new array
*  is the product of all the numbers in the original array except the one at i.
*
*  For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
*  If our input was [3, 2, 1], the expected output would be [2, 3, 6].
*/

import java.util.*;

public class Day2 {
  public static void main(String[] args) {
    int[] values = new int[]{1, 2, 3, 4, 5};
    int[] valuesTwo = new int[]{3, 2, 1};

    System.out.println(Arrays.toString(getProducts(values)));
    System.out.println(Arrays.toString(getProducts(valuesTwo)));
  }
    
  public static int[] getProducts(int[] nums) {
    int[] leftProducts = new int[nums.length];
      int[] rightProducts = new int[nums.length];
      int[] result = new int[nums.length];
      
      // Calculate left products
      for (int i = 0; i < nums.length; i++) {
        if (i == 0) {
          leftProducts[i] = 1;
        } else {
          leftProducts[i] = leftProducts[i-1] * nums[i - 1];
        }
      }
      
      // Calculate right products
      for (int i = nums.length - 1; i >= 0; i--) {
        if (i == nums.length - 1) {
          rightProducts[i] = 1;
        } else {
          rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }
      }
      
      // Calculate result
      for (int i = 0; i < nums.length; i++) {
        result[i] = leftProducts[i] * rightProducts[i];
      }
      
      return result;
  }
}