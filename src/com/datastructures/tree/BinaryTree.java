package com.datastructures.tree;

/*
 * Binary Tree:  A tree whose elements have at most 2 children is called a binary tree 
 *
 * Properties:
 *
 * 1) The maximum number of nodes at level ‘l’ of a binary tree is 2^l. 
 * 2) Maximum number of nodes in a binary tree of height ‘h’ is 2^h – 1.
 * 3) In a Binary Tree with N nodes, minimum possible height or minimum number of levels is Log2(N+1)
 * 4) A Binary Tree with L leaves has at least Log2L  + 1   levels 
 * 5) In Binary tree, number of leaf nodes is always one more than nodes with two children.
 * 
 * Types:
 * 
 * 1) Full Binary Tree: A Binary Tree is a full binary tree if every node has 0 or 2 children. 
 * 2) Complete Binary Tree: A Binary Tree is a complete Binary Tree if all the levels are completely filled except possibly the last level.
 * 3) Perfect Binary Tree: A Binary tree is a Perfect Binary Tree in which all the internal nodes have two children and all leaf nodes are at the same level. 
 * 4) Balanced Binary Tree: A binary tree is balanced if the height of the tree is O(Log n) where n is the number of nodes.
 * 		Ex: a) AVL Trees b) Red-Black Trees
 * */

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTree {

	Node root;

	BinaryTree(int data) {
		root = new Node(data);
	}

	BinaryTree(Node root) {
		this.root = root;
	}

	BinaryTree() {
		root = null;
	}

	int height(Node root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(createBinaryTree());
		System.out.printf("Tree height is: %d", tree.height(tree.root));
	}

	public static Node createBinaryTree() {

		Node rootNode = new Node(40);
		Node node20 = new Node(20);
		Node node10 = new Node(10);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);

		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;

		return rootNode;
	}
}
