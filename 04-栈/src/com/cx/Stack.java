package com.cx;

import list.ArrayList;
import list.List;

public class Stack<E>  {
	
	private List<E> list = new ArrayList<>();
	//清空栈
	public void clear() {
		list.clear();
	}
	//元素的数量
	public int size() {
		return list.size();
	}
	//是否为空
	public boolean isEmpty() {
		return list.isEmpty();
	}
	//入栈
	public void push(E element) {
		list.add(element);
	}
	//出栈
	public E pop() {
		return list.remove(list.size() -1);
	}
	//获取栈顶元素
	public E top() {
		return list.get(list.size() - 1);
	}
}
