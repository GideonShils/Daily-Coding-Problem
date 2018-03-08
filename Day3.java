/*
*  DAY 3:
* 
*  Given the root to a binary tree, implement serialize(root), which 
*  serializes the tree into a string, and deserialize(s), which deserializes 
*  the string back into the tree.
*/

import java.util.*;

public class Day3 {
	public static void main(String[] args) {
		int[] tree = {3, 8, 1, 4, 2, 3, 0};
		Node root = createTree(tree);

		// Print original tree
		System.out.println("Original tree:");
		printTree(root);
		System.out.println();

		String serialized = serialize(root);

		// Print serialized string
		System.out.println("Serialized string:");
		System.out.println(serialized);

		Node deserialized = deserialize(serialized);

		// Print deserialized tree
		System.out.println("End tree:");
		printTree(deserialized);
		System.out.println();

	}

	// Preorder serialize
	public static String serialize(Node root) {
		return serializeRecurse(root, new StringBuilder()).toString();
	}

	public static StringBuilder serializeRecurse(Node root, StringBuilder str) {
		if (root == null) {
			str.append("null,");
			return str;
		}

		str.append(root.value + ",");
		serializeRecurse(root.left, str);
		serializeRecurse(root.right, str);

		return str;
	}

	// Preorder deserialize
	public static Node deserialize(String data) {
		String[] nodes = data.split(",");
		Queue<String> queue = new LinkedList<String>();

		for (int i = 0; i < nodes.length; i++) {
			queue.add(nodes[i]);
		}

		return deserializeRecurse(queue);

	}

	public static Node deserializeRecurse(Queue<String> queue) {
		String curr = queue.remove();

		if (curr.equals("null")) {
			return null;
		} else {
			Node newNode = new Node(Integer.parseInt(curr));
			newNode.left = deserializeRecurse(queue);
			newNode.right = deserializeRecurse(queue);
			return newNode;
		}
	}

	// Preorder traversal of tree
	public static void printTree(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.value);
		printTree(root.left);
		printTree(root.right);
	}

	// Hack together a tree
	public static Node createTree(int[] tree) {
		/* Generate tree
		*       3
		*      / \
		*     8   3
		*    / \   \
		*   1   4   0
		*      /
		*     2
		*/

		Node root = new Node(tree[0]);
		root.left = new Node(tree[1]);
		root.left.left = new Node(tree[2]);
		root.left.right = new Node(tree[3]);
		root.left.right.left = new Node(tree[4]);
		root.right = new Node(tree[5]);
		root.right.right = new Node(tree[6]);

		return root;
	}

	// Node class
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node (int val) {
			value = val;
		}
	}
}