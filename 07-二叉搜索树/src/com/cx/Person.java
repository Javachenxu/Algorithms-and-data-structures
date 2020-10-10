 package com.cx;

public class Person implements Comparable<Person> {
	private int age;
	private String name;
	public Person(int age) {
		this.age = age;
	}
	public Person(int age,String name) {
		this.age = age;
		this.name = name;
	}
	@Override
	public int compareTo(Person e) {
		
		return age - e.age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return age + "_" + name;
	}
	
}
