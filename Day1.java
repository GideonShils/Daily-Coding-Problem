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
    int[] values = new int[]{10, 15, 3, 7};

    System.out.println(checkSum(17, values));
  }
    
  public static boolean checkSum(int sum, int[] values) {
    HashSet<Integer> valueSet = new HashSet<Integer>();

    for (int v : values ) {
      if (valueSet.contains(sum - v)) {
        return true;
      } else {
        valueSet.add(v);
      }
    }

    return false;
  }
}