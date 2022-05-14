package com.greatLearning.Ques_2;

import java.util.*;

//creating binary search tree node
class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

//creating program for converting BST into right skewed BST in ascending order
class Modify_BST {

	public static Node node;
	static Node prevNode = null;
	static Node rootNode = null;

	// method to implement skewed BST
	static void skewed_BST(Node root) {

		if (root == null) {
			return;
		}

		skewed_BST(root.left);

		Node right_Node = root.right;
		Node left_Node = root.left;

		if (rootNode == null) {
			rootNode = root;
			root.left = null;
			prevNode = root;
		}

		else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		skewed_BST(right_Node);

	}

	// method to traverse the skewed tree
	static void traverse_Skewed_BST(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		traverse_Skewed_BST(root.right);
	}
}
