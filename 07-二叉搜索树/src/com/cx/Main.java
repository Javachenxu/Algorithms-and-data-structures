package com.cx;

import java.sql.Date;
import java.util.Comparator;

import com.cx.printer.BinaryTreeInfo;
import com.cx.printer.BinaryTrees;

@SuppressWarnings("unused")
public class Main {
	
	private static class PersonComparetor implements Comparator<Person> {
		@Override
		public int compare(Person e1, Person e2) {
			// TODO Auto-generated method stub
			return e1.getAge() - e2.getAge();
		}
	}
	
	private static class PersonComparetor2 implements Comparator<Person> {
		@Override
		public int compare(Person e1, Person e2) {
			// TODO Auto-generated method stub
			return e2.getAge() - e1.getAge();
		}
	}
	
	static void test1() {
		Integer data[] = new Integer[] {
				7,4,9,2,5,8,11,3,1,12,6,25
		};
		BinarySearchtree<Integer> bst = new BinarySearchtree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
			}
		BinaryTrees.println(bst);
	}

	static void test2() {
		Integer data[] = new Integer[] {
				7,4,9,2,5,8,11,3,1,12,6,25
		};
		BinarySearchtree<Person> bst1 = new BinarySearchtree<>();
		for (int i = 0; i < data.length; i++) {
			bst1.add(new Person(data[i]));
			}
		BinaryTrees.println(bst1);
		
		/*
		 * java的匿名类，类似于iOS的Block，JS中的function
		 */
		BinarySearchtree<Person> bst2 = new BinarySearchtree<>(new Comparator<Person>() {
			public int compare(Person o1,Person o2) {
				return o2.getAge() - o1.getAge();
			}
		});
		for (int i = 0; i < data.length; i++) {
			bst2.add(new Person(data[i]));
			}
		BinaryTrees.println(bst2);
		
		
		}
	static void test3() {
		//Integer以及其他几个内置的类型，基本上都实现了comparable接口
		BinarySearchtree<Integer> bst3 = new BinarySearchtree<Integer>();
		for (int i = 0; i < 30; i++) {
			bst3.add((int)(Math.random() * 100));
		}
		BinaryTrees.println(bst3);
	}
	
	static void test4() {
			BinaryTrees.println(new BinaryTreeInfo() {
			
			@Override
			public Object string(Object node) {
				return node.toString() + "_";
			}
			
			@Override
			public Object root() {
				return "A";
			}
			
			@Override
			public Object right(Object node) {
				if (node.equals("A")) return "B";
				if (node.equals("C")) return "E";
				return null;
			}
			
			@Override
			public Object left(Object node) {
				if (node.equals("A")) return "C";
				if (node.equals("C")) return "D";
				return null;
			}
		});
	}
	
	static void test5() {
		BinarySearchtree<Person> bst = new BinarySearchtree<>();
		bst.add(new Person(10,"jack" ));
		bst.add(new Person(12,"mark" ));
		bst.add(new Person(6,"rose" ));
		//bst.add(new Person(, ));
		
		BinaryTrees.println(bst);
		}
	
	public static void main(String[] args) {
		
	test5();
	//test2();
	//test3();	
	//test4();
	}
	
	/*BinarySearchtree<Person> bst4 = new BinarySearchtree<>(new PersonComparetor());
	bst4.add(new Person(12));
	bst4.add(new Person(15));*/

	}




