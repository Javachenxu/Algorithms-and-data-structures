package com.cx;

import com.cx.circle.CircleQueue;

public class Main {
	//循环队列测试类
	static void test2() {
		CircleQueue<Integer> queue = new CircleQueue<>();
		
		for (int i = 0; i < 10; i++) {
			queue.enQueue(i);
		}
		for (int i = 0; i < 5; i++) {
			queue.deQueue();
		}
		for (int i = 15; i < 23; i++) {
			queue.enQueue(i);
		}
		System.out.println(queue);
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
	}
	
	public static void main(String[] args) {
		
		test2();
		//普通队列
	/*	Queue<Integer> queue = new Queue<>();
		queue.enQueue(11);
		queue.enQueue(22);
		queue.enQueue(33);
		queue.enQueue(44);
		System.out.println(queue.deQueue());
		
		while(!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
		//双端队列
		Deque<Integer> queue = new Deque<>();
		queue.enQuenefront(11);
		queue.enQuenefront(22);
		queue.enQueueRear(33);
		queue.enQueueRear(44);
		//System.out.println(queue.deQueueFront());
		
		while(!queue.isEmpty()) {
			System.out.println(queue.deQueueFront());
		}*/
	}
}
