package com.cx;

import java.util.Comparator;


import com.cx.printer.BinaryTreeInfo;
import com.cx.printer.BinaryTrees;
import com.cx.tree.AVLTree;
import com.cx.tree.BST;
import com.cx.tree.BinaryTree;
import com.cx.tree.BinaryTree.Visitor;

public class Main {

	static void test1() {
		Integer data[] = new Integer[] {
				13,14,15,12,11,17,16,8,9,1
		};
		
		AVLTree<Integer> bst = new AVLTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		
		BinaryTrees.println(bst);
		
		
	}

	
	public static void main(String[] args) {
		test1();
	}
}
