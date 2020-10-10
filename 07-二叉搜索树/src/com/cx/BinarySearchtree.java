package com.cx;
import java.util.Comparator;

import com.cx.printer.BinaryTreeInfo;

/*
 * 接口设计：
 * int size() // 元素的数量
 * boolean isEmpty() // 是否为空
 * void clear() // 清空所有元素
 * void add(E element) // 添加元素
 * void remove(E element) // 删除元素
 * boolean contains(E element) // 是否包含某元素
 */
@SuppressWarnings("unchecked")
public class BinarySearchtree<E> implements BinaryTreeInfo {//调用打印器
	
	private int size;
	private Node<E> root;
	
	private Comparator<E> comparetor;
	public BinarySearchtree() {
		this(null);
	}
	public BinarySearchtree(Comparator comparetor) {
		this.comparetor = comparetor;
	}
	//元素的数量
	public int size() {
		return size();
	}
	//判断是否为空
	public boolean isEmpty() {
		return size() == 0;
	}
	//清空
	public void clear() {
		
	}
	//二叉树前序遍历(递归实现)
	public void preorderTraversal() {
		preorderTraversal(root);
	}
	private void preorderTraversal(Node<E> node) {
		if (node == null) return;
		
		System.out.println(node.element);
		preorderTraversal(node.leaf);
		preorderTraversal(node.right);
		
	}
	
	//二叉树中序遍历
	
	public void inorderTraversal() {
		inorderTraversal(root);
	}
	
	private void inorderTraversal(Node<E> node) {
		if (node == null) return;
		
		inorderTraversal(node.leaf);
		System.out.println(node.element);
		inorderTraversal(node.right);
	}
	
	//二叉树后序遍历
	
	public void postorderTraversal() {
		postorderTraversal(root);
	}
	
	private void postorderTraversal(Node<E> node) {
		if(node == null) return;
		
		postorderTraversal(node.leaf);
		postorderTraversal(node.right);
		System.out.println(node.element);
	}

	
	//添加
	public void add(E element) {
		elementNotNullCheck(element);
		//添加第一个节点
		if (root == null) {
			root = new Node<>(element,null);
			size++;
			return;
		}
		//添加后续节点
		//找到父节点
		//创建新节点node
		//parent.left = node 或者 parent.right = node
		
		Node<E> parent = null;
		
		Node<E> node = root;
		int cmp = 0;
		while (node != null) {
			cmp = compare(element, node.element);
			parent = node;//父节点
			if (cmp > 0) {
				node = node.right;
			} else if (cmp < 0) {
				node = node.leaf;
			} else {//相等
				node.element = element;
				return;
			} 
		}
		//看看插入到父节点的那个位置
		Node<E> newNode = new Node<>(element, parent);
		if (cmp > 0) {
			parent.right = newNode;
		} else {
			parent.leaf = newNode;
		}
		size++;
	}
	//删除
	public void remove(E element) {
		
	}
	//是否包含某元素
	public boolean contains(E element) {
		return false;
	}
	//比较函数
	/*
	 * @return 返回值等于0，代表e1与e2相等，返回值大于0，代表e1大于e2,
	 * 返回值小于0，代表e1小于e2.
	 */
	
	private int compare(E e1,E e2) {
		if (comparetor != null) {
			return comparetor.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
	}
	
	private void elementNotNullCheck(E element) {
		if (element == null) {//非法参数异常
			throw new IllegalArgumentException("element must not be null");
		}
	}
	
	private static class Node<E> {
		E element;
		Node<E> leaf;
		Node<E> right;
		Node<E> parent;//父节点
		
		public  Node(E element,Node<E> parent) {
			this.parent = parent;
			this.element = element;
		}
	}

	@Override
	public Object root() {
		
		return root;
	}
	@Override
	public Object left(Object node) {
		return ((Node<E>)node).leaf;
	}
	@Override
	public Object right(Object node) {
		return ((Node<E>)node).right;
	}
	@Override
	//打印出parent节点
	public Object string(Object node) {
		Node<E> myNode = (Node<E>)node;
		String parentString = "null";
		if (myNode.parent != null) {
			parentString = myNode.parent.element.toString();
		}
		return myNode.element + "_p(" + parentString + ")";
	}
}

