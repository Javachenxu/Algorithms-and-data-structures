package com.cx;


//使用双向链表构造队列
import com.cx.list.LinkedList;
import com.cx.list.List;

/*
 * 队列是一种特殊的数据结构，只能在头尾两端进行操作
 * 队尾（rear）：只能在队尾添加元素，一般叫做enQueue。入队
 * 对头（front）：只能在队头移除元素，一般叫做deQueue，出队
 * 先进先出的原则，First In First Out，FIFO
 */
/*
 * 队列的接口设计
 * int size(); //元素的数量
 * boolean isEmpty(); //是否为空
 * void enQueue(E element); //入队
 * E deQueue(); //出队
 * E front(); //获取队列的头元素
 * void clear(); //清空
 */
public class Queue<E> {
	
	private List<E> list = new LinkedList<>();
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty() ;
	}
	
	public void enQueue(E element) {
		list.add(element);
	}
	
	public E deQueue() {
		return list.remove(0);
	}
	
	public E front() {
		return list.get(0);
	}
	
	private void clear() {
		list.clear();
	}
}
