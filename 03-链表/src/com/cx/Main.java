package com.cx;

import com.cx.circle.SingleCircleLinkedList;

public class Main {
	
	static void testlist(List<Integer> list) {
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		
		list.add(0, 55);
		list.add(2, 66);
		list.add(list.size() , 77);
		
		list.remove(0);
		list.remove(2);
		list.remove(list.size() - 1);
		
		Asserts.test(list.indexOf(44) == 3);
		Asserts.test(list.indexOf(22) == List.ELEMENT_NOT_FOUND);
		Asserts.test(list.contains(33));
		Asserts.test(list.get(0) == 11);
		Asserts.test(list.get(1) == 66);
		Asserts.test(list.get(list.size() - 1) == 44);
		
 		System.out.println(list);
	
	}

	public static void main(String[] args) {
		/*List<Integer> list = new LinkedList<>();
		list.add(20);
		list.add(30);
		list.add(35);
		list.add(65);
		System.out.println(list);*/
		
		/*List<Integer> list = new ArrayList2<Integer>();
		for (int i = 0; i < 50; i++) {
			list.add(i);
		}
		for (int i = 0; i < 50; i++) {
			list.remove(0);
		}*/
		
		//testlist(new ArrayList<>());
		//testlist(new LinkedList<>());
		
		testlist(new SingleCircleLinkedList<>());
		//System.out.println(list);
		
	}
}