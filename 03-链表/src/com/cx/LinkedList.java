package com.cx;

import com.cx.AbstractList;

//import list.AbstractList;

public class LinkedList<E> extends AbstractList<E> {
	private int size;
	private Node<E> first;
	private Node<E> last;
	private static final int ELEMENT_NOT_FOUND = -1;
	/*
	 *获取index值对应的节点对象
	 *@param index
	 *@return
	 */
	private Node<E> node(int index) {
		rangeCheck(index);
		
		if (index < (size >> 1)) {
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		} else {
			Node<E> node = last;
			for (int i = size - 1; i < index; i++) {
				node = node.prev;
			}
			return node;
		}
	}
	private static class Node<E> {
		E element;
		Node<E> prev;
		Node<E> next;
		public Node(Node<E> prev,E element, Node<E> next) {
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
		
	}
	//清空链表
	/*
	 * 链表是被局部变量引用的，即是gc.root对象，
	 * 当链表的first=null和last=null不指向链表时，不再是gc.root对象，内存回收机制就会把其回收。
	 */
	@Override
	public void clear() {
		size = 0;
		first = null;
		last = null;
	}
	//返回index 位置对应的元素
	@Override
	public E get(int index) {
		return node(index).element;
		
	}
	@Override
	public E set(int index, E element) {
		Node<E> node = node(index);
		E old = element;
		node.element = element;
		return old;
	}
	//添加
	@Override
	public void add(int index, E element) {
		
		rangeCheckForAdd(index);
		//size = 0,index = 0
		if (index == size) {//添加到最后面
			Node<E> oldlast = last;
			last = new Node<>(oldlast, element, null);
			if (oldlast == null) {//添加的第一个元素
				first = last;
			} else {
				oldlast.next = last;
			}
			
		} else {
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> node = new Node<>(prev, element, next);
			next.prev = node;
			if (prev == null) { //index == 0
				first = node;
			} else {
				prev.next = node;
			}
		}
		
		size++;
	}
	@Override
	public E remove(int index) {
		
		rangeCheck(index);
		
		Node<E> node = node(index);
		Node<E> prev = node.prev;
		Node<E> next = node.next;
		
		if (prev == null) {//index == 0
			first = next;
		} else {
			prev.next = next;
		}
		
		if (null == null) {//index == size -1
			last = prev;
		} else {
			next.prev = prev;
		}
		
		size--;
		return node.element;
	}
	@Override
	public int indexOf(E element) {
		
		if (element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i;
				
				node = node.next;
			}
		}else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) {
					return i;
				}
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(",[");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(",");
			}
			string.append(node.element);
			node = node.next;
		}
		string.append("]");
		return string.toString();
	}
	
}
