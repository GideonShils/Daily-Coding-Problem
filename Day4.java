/*
*  DAY 4:
* 
*  Given an unsorted integer array nums, find the smallest missing positive integer.
*
*  For example, if our input was [1,2,0], the expected output would be 3.
*  If our input was [3,4,-1,1], the expected output would be 2
*/


public class Day4 {
  public static void main(String[] args) {
    int[] values = {1, 2, 0};
    int[] valuesTwo = {3, 4, -1, 1};
    int[] valuesThree = {1};

    System.out.println(firstMissingPositive(values));
    System.out.println(firstMissingPositive(valuesTwo));
    System.out.println(firstMissingPositive(valuesThree));
  }

  public static int firstMissingPositive(int[] nums) {
    boolean hasOne = false;
    // Clean up array
    for (int i = 0; i < nums.length; i++) {
        int currNum = nums[i];
        if (currNum <= 0 || currNum > nums.length) {
            nums[i] = 1;
        } else if (!hasOne && currNum == 1) {
            hasOne = true;
        }
    }
    
    if (!hasOne) {
        return 1;
    }
    
    // Mark indices
    for (int i = 0; i < nums.length; i++) {
        int currNum = Math.abs(nums[i]);
        int valAtIndex = nums[currNum - 1];
        
        // If we've already flipped, don't flip again
        if (valAtIndex > 0) {
            nums[currNum-1] *= -1;   
        }
    }
    
    // Look for first non negative
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > 0) {
            return i + 1;
        }
    }
    
    return nums.length + 1;
  }
}