/*
*  DAY 3:
* 
*  Given the root to a binary tree, implement serialize(root),
*  which serializes the tree into a string, and deserialize(s),
*  which deserializes the string back into the tree.
*
*/

import java.util.*;

public class Day3 {
  public static void main(String[] args) {
    /*          1
               / \
              2   3
                 / \
                4   5  
    */


    // [1,2,3,null,null,4,5]
    TreeNode rootNode = new TreeNode(1);
    rootNode.left = new TreeNode(2);
    rootNode.right = new TreeNode(3);
    rootNode.right.left = new TreeNode(4);
    rootNode.right.right = new TreeNode(5);

    System.out.println(serialize(rootNode));
    System.out.println(serialize(deserialize(serialize(rootNode))));
  }

  public static String serialize(TreeNode root) {
    StringBuilder serializedString = new StringBuilder();
    return serialize(root, serializedString).toString();
  }

  public static StringBuilder serialize(TreeNode root, StringBuilder stringBuilder) {
    if (root == null) {
      stringBuilder.append("#,");
    } else {
      stringBuilder.append(root.val + ",");
      serialize(root.left, stringBuilder);
      serialize(root.right, stringBuilder);
    }

    return stringBuilder;
  }

  // Decodes your encoded data to tree.
  public static TreeNode deserialize(String data) {
    LinkedList<String> values = new LinkedList<String>();
    values.addAll(Arrays.asList(data.split(",")));
    return deserialize(values);
  }

  public static TreeNode deserialize(LinkedList<String> values) {

    String currValue = values.pop();

    if (currValue.equals("#")) {
      return null;
    } else {
      int numValue = Integer.valueOf(currValue);
      TreeNode root = new TreeNode(numValue);
      root.left = deserialize(values);
      root.right = deserialize(values);
      return root;
    }
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