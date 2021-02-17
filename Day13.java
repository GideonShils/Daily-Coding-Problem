/*
*  DAY 13:
* 
*  Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
* 
*  For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
*
*
*/

import java.util.*;

public class Day13 {
  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstringKDistinct("abcba", 2));
  }

  public static int lengthOfLongestSubstringKDistinct(String s, int k) {
    int left = 0;
    int right = 0;
    int max = 0;
    HashMap<Character, Integer> map = new LinkedHashMap<>();
    
    while (right < s.length()) {
      char c = s.charAt(right);   
      
      // Reinsertion re-orders so that this is now the end of the map again
      if (map.containsKey(c)) {
        map.remove(c);
      }
          
      map.put(c, right);
      
      if (map.size() > k) {
        Map.Entry<Character, Integer> rightMost = map.entrySet().iterator().next();
        left = rightMost.getValue() + 1;
        map.remove(rightMost.getKey());
      } else {
        max = Math.max(max, right - left + 1);
      }
      
      right++;
    }
    
    return max;
}
}