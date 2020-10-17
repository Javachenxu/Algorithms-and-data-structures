package com.cx;

import com.cx.set.ListSet;
import com.cx.set.Set;
import com.cx.set.Set.Visitor;
import com.cx.set.TreeSet;

public class Main {
	static void test1() {
		Set<Integer> listSet = new ListSet<>();
		listSet.add(10);
		listSet.add(11);
		listSet.add(12);
		listSet.add(13);
		listSet.add(10);
		
		listSet.traversal(new Visitor<Integer>() {
			
			public boolean visit(Integer element) {
				System.out.println(element);
				return false;
			}
		});
	}
	
	static void test2() {
		Set<Integer> treeSet = new TreeSet<>();
		treeSet.add(12);
		treeSet.add(13);
		treeSet.add(10);
		treeSet.add(11);
	
		treeSet.add(10);
		
		treeSet.traversal(new Visitor<Integer>() {
			
			public boolean visit(Integer element) {
				System.out.println(element);
				return false;
			}
		});
	}
	public static void main(String[] args) {
		test1();

	}

}
