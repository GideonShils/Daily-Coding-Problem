/*
*  DAY 18:
* 
*  Given an array of integers and a number k, where 1 <= k <= length of the array,
*  compute the maximum values of each subarray of length k.
* 
*  For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
*
*/

import java.util.*;

public class Day18 {
  public static void main(String[] args) {
    int[] initialArray = { 10, 5, 2, 7, 8, 7 };
    int k = 3;

    int[] resultArray = getMaximums(initialArray, k);

    System.out.print("[");

    for (int i : resultArray) {
      System.out.print(i + ", ");
    }

    System.out.print("]");
  }

  public static int[] getMaximums(int[] nums, int k) {
    int[] result = new int[nums.length - k + 1];
    int windowNum = 0;

    // Max value on left.
    // Add new values on right
    // Need to clear when:
    // - no longer in window
    // - not max
    Deque<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < nums.length; i++) {
      int currNum = nums[i];

      // If the left value is out of range, remove it
      while (!queue.isEmpty() && queue.peekFirst() < i - k + 1) {
        queue.pollFirst();
      }

      // If the right value is smaller than the curr, remove it
      while (!queue.isEmpty() && nums[queue.peekLast()] < currNum) {
        queue.pollLast();
      }

      queue.offerLast(i);

      // Dont start setting max until we hit first k elmenets
      if (i >= k - 1) {
        result[windowNum] = nums[queue.peekFirst()];
        windowNum++;
      }

    }

    return result;
  }
}