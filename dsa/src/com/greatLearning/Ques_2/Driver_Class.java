package com.greatLearning.Ques_2;

public class Driver_Class {
	public static void main(String[] args) {

		Modify_BST tree = new Modify_BST();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);

		tree.skewed_BST(tree.node);
		tree.traverse_Skewed_BST(tree.rootNode);
	}

}
