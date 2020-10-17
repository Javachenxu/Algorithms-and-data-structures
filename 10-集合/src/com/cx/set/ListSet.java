package com.cx.set;

import com.cx.list.LinkedList;
import com.cx.list.List;

public class ListSet<E> implements Set<E> {
	private List<E> list = new LinkedList<E>(); 

	@Override
	public int size() {
		
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return isEmpty();
	}

	@Override
	public void clear() {
		list.clear();

	}

	@Override
	public boolean contains(E element) {
		return list.contains(element);
	}

	@Override//添加操作
	public void add(E element) {
		//两种添加方法
		//用contains函数找到不相同的元素
//		if (list.contains(element)) return;
//		list.add(element);
		//相同元素覆盖
		int index = list.indexOf(element);
		if (index != List.ELEMENT_NOT_FOUND) {//存在就覆盖
			list.set(index, element);
		} else {//不存在就添加
			list.add(element);
		}

	}

	@Override
	public void remove(E element) {
		int index = list.indexOf(element);
		if (index != List.ELEMENT_NOT_FOUND) {
			list.remove(index);
		}
	}

	@Override//遍历接口
	public void traversal(Visitor<E> visitor) {
		if (visitor == null) return;
		int size = list.size();
		for (int i = 0; i < size; i++) {
			if (visitor.visit(list.get(i))); 
		}

	}

}
