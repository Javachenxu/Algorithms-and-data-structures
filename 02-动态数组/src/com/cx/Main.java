package com.cx;

import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		

		
		ArrayList<Person> persons = new ArrayList<>();
		persons.add(new Person(10,"Jack"));
		persons.add(new Person(10,"James"));
		persons.add(null);
		persons.add(new Person(10,"Rose"));
		persons.add(new Person(10,"Tom"));
		//System.out.println(persons);
		persons.clear();
		
		//提醒垃圾回收
		System.gc();
		ArrayList<Integer> ints = new ArrayList<>();
		ints.add(15);
		ints.add(16);
		ints.add(17);
		ints.add(18);
		System.out.println(ints);
		ints.indexOf(17);
		System.out.println(ints.indexOf(16));
		Object[] objects = new Object[7];
		objects[1] = new Object();
	}
	
	
	
	
}
