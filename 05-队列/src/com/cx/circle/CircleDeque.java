package com.cx.circle;
//双端循环队列
@SuppressWarnings("unchecked")
public class CircleDeque<E> {
	
	private int front;
	private int size;
	private E[] elements;
	private static final int DEFAULT_CAPACITY= 10;
	private int index(int index) {
		index += front;
		if (index < 0) {
			return index + elements.length;
		}
			return index - (index >= elements.length ? elements.length : 0);
	}
	
	public CircleDeque() {
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	/*
	 * 从尾部入队
	 * @param element
	 */
	public void enQueueRear(E element) {
		ensureCapacity(size + 1);
		elements[index(size)] = element;
		size++;

	}
	/*
	 * 从头部出队
	 * @param element
	 */
	public E deQueueFront() {
		E frontelement = elements[front];
		elements[front] = null;
		front = index(1);
		size--;
		return frontelement;
	}
	/*
	 * 从头部入队
	 * @param element
	 */
	public void enQueneFront(E element) {
		ensureCapacity(size + 1); 
		front = index(-1);
		elements[front] = element;
		size++;
	}
	/*
	 * 从尾部出队
	 * @param element
	 */
	public E deQueneRear() {
		int rearIndex = index(size - 1);
		E rear = elements[rearIndex];
		elements[rearIndex] = null;
		size--;
		return rear;
	}
	//获取头部
	public E front() {
		return elements[front];
	}
	//获取尾部
	public E rear() {
		return elements[index(size - 1)];
	}
	
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("capcacity=").append(elements.length)
		.append(" size=").append(size)
		.append(" front=").append(front).append(",[");
		for (int i = 0; i < elements.length; i++) {
			if (i != 0) {
				string.append(",");
			}
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();
		
	}
	/*
	 * 保证要有capacity的容量
	 * @param capacity
	 *    动态扩容
	 */
	private void ensureCapacity(int capacity) {
		int oidCapacity = elements.length;
		if (oidCapacity >= capacity) return;
		
		//新容量为旧容量的1.5倍
		int newCapacity = oidCapacity + (oidCapacity >> 1);
		@SuppressWarnings("unchecked")
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[index(i)];
		}
		elements = newElements;
		front = 0;
		System.out.println(oidCapacity + "扩容为" + newCapacity);
	}
}
