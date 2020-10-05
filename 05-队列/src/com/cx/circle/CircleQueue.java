package com.cx.circle;
//循环队列
@SuppressWarnings("unchecked")
public class CircleQueue<E> {
	
	private int front;
	private int size;
	private E[] elements;
	private static final int DEFAULT_CAPACITY= 10;
	
	
	public CircleQueue() {
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void enQueue(E element) {
		elements[(front + size) % elements.length] = element;
		size++;
	}
	
	public E deQueue() {
		
		E frontelement = elements[front];
		elements[front] = null;
		front = (front + 1) % elements.length;
		size--;
		return frontelement;
	}
	
	public E front() {
		return elements[front];
	}
	
	/*private void clear() {
		list.clear();
	}*/
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("capcacity=").append(elements.length)
		.append(" size=").append(size).append(",[");
		for (int i = 0; i < elements.length; i++) {
			if (i != 0) {
				string.append(",");
			}
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();
		
	}
}
