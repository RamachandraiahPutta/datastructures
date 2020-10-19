package com.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversal {

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	/*
	 * Create empty queue and pust root node to it
	 * 
	 * while(queue is not empty) a) Pop a node from queue and print it b) Push left
	 * child of popped node to queue if not null c) Push right child of popped node
	 * to queue if not null
	 * 
	 */
	public static void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();
			System.out.printf("%d ", tempNode.data);
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)
				queue.add(tempNode.right);
		}
	}

	public static void preOrderTraversal(TreeNode root) {
		if (root == null)
			return;

		// first deal with the node
		System.out.printf("%d ", root.data);
		// then recur on left subtree
		preOrderTraversal(root.left);
		// then recur on right subtree
		preOrderTraversal(root.right);
	}

	public static void postOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		// first recur on left subtree
		postOrderTraversal(root.left);
		// then recur on right subtree
		postOrderTraversal(root.right);
		// now deal with the node
		System.out.printf("%d ", root.data);
	}

	public static void inOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		// first recur on left subtree
		inOrderTraversal(root.left);
		// now deal with the node
		System.out.printf("%d ", root.data);
		// then recur on right subtree
		inOrderTraversal(root.right);
	}

	/* Print nodes at the given level */
	public static void printGivenLevel(TreeNode root, int level) {
		if (root == null)
			return;
		if (level == 0)
			System.out.printf("%d ", root.data);
		else if (level > 0) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {

		// Creating a binary tree
		TreeNode rootNode = createBinaryTree();
		System.out.println("Level Order traversal of binary tree will be:");
		levelOrderTraversal(rootNode);
		System.out.println();
		
		System.out.println("Pre Order traversal of binary tree will be:");
		preOrderTraversal(rootNode);
		System.out.println();
		
		System.out.println("In Order traversal of binary tree will be:");
		inOrderTraversal(rootNode);
		System.out.println();
		
		System.out.println("Post Order traversal of binary tree will be:");
		postOrderTraversal(rootNode);
		System.out.println();

		int level = 2;
		System.out.printf("Nodes in Level: %d \n", level);
		printGivenLevel(rootNode, level);
	}

	
	/*
	 * create a tree
	 * 
	 * 					40
	 * 				   /  \
	 * 				 20    60
	 *              / \    / \
	 *             10  30 50  70
	 * */
	public static TreeNode createBinaryTree() {

		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);

		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;

		return rootNode;
	}
}
