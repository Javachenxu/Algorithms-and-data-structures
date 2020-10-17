package com.cx.set;

import java.util.Comparator;

import com.cx.tree.BinaryTree;
import com.cx.tree.RBTree;

public class TreeSet<E> implements Set<E> {
	private RBTree<E> tree;
	//传个比较器
	public TreeSet() {
		this(null);
	}
	
	public TreeSet(Comparator<E> comparator) {
		tree = new RBTree<>(comparator);
	}
	
	public int size() {
		
		return tree.size();
	}

	@Override
	public boolean isEmpty() {
		
		return tree.isEmpty();
	}

	@Override
	public void clear() {
		tree.clear();
	}

	@Override
	public boolean contains(E element) {
		
		return tree.contains(element);
	}

	@Override
	public void add(E element) {//红黑树默认去重
		tree.add(element);
	}

	@Override
	public void remove(E element) {
		tree.remove(element);
	}

	@Override
	public void traversal(Visitor<E> visitor) {
		tree.inorder(new BinaryTree.Visitor<E>() {
			public boolean visit(E element) {
				return visitor.visit(element);
			}
		});//中序遍历

	}

}
