/*
*  DAY 8:
* 
*  A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
* 
*  Given the root to a binary tree, count the number of unival subtrees.
*
* For example, the following tree has 5 unival subtrees:
*    0
*   / \
*  1   0
*     / \
*    1   0
*   / \
*  1   1
*/

public class Day8 {
  public static void main(String[] args) {
    /*
    *    0
    *   / \
    *  1   0
    *     / \
    *    1   0
    *   / \
    *  1   1
    */

    TreeNode rootNode = new TreeNode(0);
    rootNode.left = new TreeNode(1);
    rootNode.right = new TreeNode(0);
    rootNode.right.left = new TreeNode(1);
    rootNode.right.right = new TreeNode(0);
    rootNode.right.left.left = new TreeNode(1);
    rootNode.right.left.right = new TreeNode(1);

    System.out.println(countUnivalSubtrees(rootNode));
  }

  public static int countUnivalSubtrees(TreeNode root) {
    int[] count = {0};
    isUnival(root, count);
    return count[0];
  }

  public static boolean isUnival(TreeNode root, int[] count) {
    if (root == null) {
      return true;
    }
    
    if (root.left == null && root.right == null) {
      count[0]++;
      return true;
    }
    
    boolean isLeftUni = isUnival(root.left, count);
    boolean isRightUni = isUnival(root.right, count);
    
    if (isLeftUni && isRightUni) {
      boolean leftNullRightMatches = root.left == null && root.right != null && root.right.val == root.val;
      boolean rightNullLeftMatches = root.right == null && root.left != null && root.left.val == root.val;
      boolean bothMatch = root.left != null && root.right != null && root.left.val == root.val && root.right.val == root.val;
      
      if (leftNullRightMatches || rightNullLeftMatches || bothMatch) {
        count[0]++;
        return true;
      } else {
        return false;
      }
    }

    return false;
} 

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}