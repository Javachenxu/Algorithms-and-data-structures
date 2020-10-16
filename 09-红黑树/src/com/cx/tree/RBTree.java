package com.cx.tree;
/**
 * 红黑树必须满足以下 5 条性质
 * 1. 节点是 RED 或者 BLACK
 * 2. 根节点是 BLACK
 * 3. 叶子节点（外部节点，空节点）都是 BLACK
 * 4. RED 节点的子节点都是 BLACK
 * ✓ RED 节点的 parent 都是 BLACK
 * ✓ 从根节点到叶子节点的所有路径上不能有 2 个连续的 RED 节点
 * 5. 从任一节点到叶子节点的所有路径都包含相同数目的 BLACK 节点
 */
import java.util.Comparator;

import com.cx.tree.BinaryTree.Node;

public class RBTree<E> extends BBST<E> {
	public static final boolean RED = false;
	public static final boolean BLACK = true;
		
	public RBTree() {
		this(null);
	}
	
	public RBTree(Comparator<E> comparator) {
		super(comparator);
	}
	@Override
	protected void afterAdd(Node<E> node) {
		Node<E> parent = node.parent;
		//添加的是根节点
		if (parent == null) {
			black(node);
			return;
		}
		//如果父节点是黑色，直接返回
		if (isBlack(parent)) return;
		//uncle节点
		Node<E> uncle = parent.sibling();
		//祖父节点
		Node<E> grand = parent.parent;
		//叔父节点是红色
		if (isRed(uncle)) {
			black(parent);
			black(uncle);
			//把祖父节点当成新添加的节点
			red(grand);
			afterAdd(grand);
			return;
		}
		//叔父节点不是红色
		if (parent.isLeftChild()) {//L
			if (node.isLeftChild()) {//LL
				black(parent);
				red(grand);
				rotateRight(grand);
			} else {//LR
				black(node);
				red(grand);
				rotateLeft(parent);
				rotateRight(grand);
			}
		} else {//R
			if (node.isLeftChild()) {//RL
				black(node);
				red(grand);
				rotateRight(parent);
				rotateLeft(grand);
			} else {//RR
				black(parent);
				red(grand);
				rotateLeft(grand);
			}
		}
	}
	
	@Override
	protected void afterRemove(Node<E> node) {
		// TODO Auto-generated method stub
		super.afterRemove(node);
	}
	//染色
	private Node<E> color(Node<E> node,boolean color) {
		if (node == null) return node;
		((RBNode<E>)node).color = color;
		return node;
	}
	//染成红色
	private Node<E> red(Node<E> node) {
		return color(node, RED);
	}
	//染成黑色
	private Node<E> black(Node<E> node) {
		return color(node, BLACK);
	}
	//判断某个节点是什么颜色
	private boolean colorOf(Node<E> node) {
		return node == null ? BLACK : ((RBNode<E>)node).color;
	}
	
	//是否为黑色
	private boolean isBlack(Node<E> node) {
		return colorOf(node) == BLACK;
	}
	//是否为红色
	@SuppressWarnings("unused")
	private boolean isRed(Node<E> node) {
		return colorOf(node) == RED;
	}
	
	@Override
	protected Node<E> createNode(E element, Node<E> parent) {
		// TODO Auto-generated method stub
		return new RBNode<>(element, parent);
	}
	private static class RBNode<E> extends Node<E> {
		//建议新添加的节点默认为 RED，这样能够让红黑树的性质尽快满足
		//（性质 1、2、3、5 都满足，性质 4 不一定）
		boolean color = RED;
		public RBNode(E element, Node<E> parent) {
			super(element, parent);
			
		}

		@Override
		public String toString() {
			String str = "";
			if (color == RED) {
				str = "R_";
			}
			return str + element.toString();
		}
}
}
