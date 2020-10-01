package com.cx;

public class Main {
	public static void main(String[] args) {
		
		Queue<Integer> queue = new Queue<>();
		queue.enQueue(11);
		queue.enQueue(22);
		queue.enQueue(33);
		queue.enQueue(44);
		System.out.println(queue.deQueue());
		
		while(!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
		
	}
}
