package com.cx;

public class Main {

	public static void main(String[] args) {
		/*List<Integer> list = new LinkedList<>();
		list.add(20);
		list.add(30);
		list.add(35);
		list.add(65);
		System.out.println(list);*/
		
		List<Integer> list = new ArrayList2<Integer>();
		for (int i = 0; i < 50; i++) {
			list.add(i);
		}
		for (int i = 0; i < 50; i++) {
			list.remove(0);
		}
		
		System.out.println(list);
		
	}
}