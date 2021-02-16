/*
*  DAY 12:
* 
*  There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
*  Given N, write a function that returns the number of unique ways you can climb the staircase.
*  The order of the steps matters.
*
*  For example, if N is 4, then there are 5 unique ways:

*  1, 1, 1, 1
*  2, 1, 1
*  1, 2, 1
*  1, 1, 2
*  2, 2
*
*
*/

public class Day12 {
  public static void main(String[] args) {
    System.out.println(recursiveApproach(4));
    System.out.println(dynamicProgrammingApproach(4));
  }

  public static int recursiveApproach(int n) {
    int[] memo = new int[n];
    return recursiveApproach(n, memo);
  }

  public static int recursiveApproach(int n, int[] memo) {
    if (memo[n-1] != 0) {
      return memo[n-1];
    }
    
    if (n <= 0) {
        return 0;
    }
    
    if (n == 1 || n == 2) {
        return n;
    }
    
    int result = recursiveApproach(n - 1, memo) + recursiveApproach(n - 2, memo);
    memo[n-1] = result;
    return result;
  }

  public static int dynamicProgrammingApproach(int n) {
    int[] memo = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == 2) {
                memo[i] = i;
            } else {
                memo[i] = memo[i - 1] + memo[i - 2];
            }
        }
        
        return memo[n];
  }
}