package com.cx;

import com.cx.printer.BinaryTreeInfo;
import com.cx.printer.BinaryTrees;
import com.cx.tree.AVLTree;
import com.cx.tree.BST;
import com.cx.tree.BinaryTree;
import com.cx.tree.BinaryTree.Visitor;

public class Main {

	static void test1() {
		Integer data[] = new Integer[] {
				72, 94, 69, 92, 43, 10, 98, 85, 58, 33, 82, 59, 2, 42, 20, 84
		};
		
		AVLTree<Integer> avl = new AVLTree<>();
		for (int i = 0; i < data.length; i++) {
			avl.add(data[i]);
			//System.out.println("------------------");
			//System.out.println("【" + data[i] + "】");
			//BinaryTrees.println(avl);
			
		}
		BinaryTrees.println(avl);
//		for (int i = 0; i < data.length; i++) {
//			avl.remove(data[i]);
//			System.out.println("------------------");
//			System.out.println("【" + data[i] + "】");
//			BinaryTrees.println(avl);
//		}
		
		
	}

	public static void main(String[] args) {
		test1();
	}
}
