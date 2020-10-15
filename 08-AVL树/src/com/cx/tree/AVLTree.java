package com.cx.tree;

import java.util.Comparator;

import com.cx.tree.BinaryTree.Node;

public class AVLTree<E> extends BST<E> {
	
	public AVLTree() {
		this(null);
	}
	public AVLTree(Comparator<E> comparator) {
		super(comparator);
	}
	
	protected void afterAdd(Node<E> node) {
		while ((node = node.parent) != null) {
			if (isBalanced(node)) {
				//更新高度
				updateHeight(node);
			} else {
				//恢复平衡
				rebalance(node);
				break;
			}
		}
		}

	//删除
	//只可能会导致父节点失衡，让父节点恢复平衡后，可能会导致更高层的祖父节点失衡【最多只需要O(logn)次调整】
	@Override
	protected void afterRemove(Node<E> node) {
		while ((node = node.parent) != null) {
			if (isBalanced(node)) {
				//更新高度
				updateHeight(node);
			} else {
				//恢复平衡
				rebalance(node);
				
			}
		}
	}
	protected Node<E> createNode(E element,Node<E> parent) {
		return new AVLNode<>(element, parent);
	}
	/**
	 * 恢复平衡
	 * @param grand 高度最低的那个不平衡节点
	 */
	private void rebalance2(Node<E> grand) {
		Node<E> parent = ((AVLNode<E>) grand).tallerChild();
		Node<E> node = ((AVLNode<E>) parent).tallerChild();
		if (parent.isLeftChild()) {//L
			if (node.isLeftChild()) {//LL
				rotateRight(grand);
			} else {//LR
				rotateLeft(parent);
				rotateRight(grand);
			}
		} else {//R
			if (node.isLeftChild()) {//RL
				rotateRight(parent);
				rotateLeft(grand);
			} else {//RR
				rotateLeft(grand);
			}
		}
	}
	//统一旋转操作
	private void rebalance(Node<E> grand) {
		Node<E> parent = ((AVLNode<E>) grand).tallerChild();
		Node<E> node = ((AVLNode<E>) parent).tallerChild();
		if (parent.isLeftChild()) {//L
			if (node.isLeftChild()) {//LL
				rotate(grand, node.left, node, node.right, parent, parent.right, grand, grand.right);
			} else {//LR
				rotate(grand, parent.left, parent, node.left, node, node.right, grand, grand.right);
			}
		} else {//R
			if (node.isLeftChild()) {//RL
				rotate(grand, grand.left, grand, node.left, node, node.right, parent, parent.right);
			} else {//RR
				rotate(grand, grand.left, grand, parent.left, parent, node.left, node, node.right);
				
			}
		}
	}
	
	private void rotate(
			Node<E> r,  //子树的根节点
			Node<E> a,Node<E> b,Node<E> c,
			Node<E> d,
			Node<E> e,Node<E> f,Node<E> g) {
		d.parent = r.parent;
		if (r.isLeftChild()) {
			r.parent.left = d;
		} else if (r.isRightChild()) {
			r.parent.right = d;
		} else {
			root = d;
		}
		//a-b-c
		b.left = a;
		if (a != null) {
			a.parent = b;
		}
		b.right = c;
		if (c != null) {
			c.parent = b;
		}
		updateHeight(b);
		//e-f-g
		f.left = e;
		if (e != null) {
			e.parent = f;
		}
		f.right = g;
		if (g != null) {
			g.parent = f;
		}
		updateHeight(f);
		
		//b-d-f
		d.left = b;
		d.right = f;
		b.parent = d;
		f.parent = d;
		
		updateHeight(d);
	}
	//左旋转
	private void rotateLeft(Node<E> grand) {
		Node<E> parent = grand.right;
		Node<E> child = parent.left;
		grand.parent = child;
		parent.left = grand;
		
		afterRotate(grand, parent, child);
		
	}
	//右旋转
	private void rotateRight(Node<E> grand)	{
		Node<E> parent = grand.left;
		Node<E> child = parent.right;
		grand.left = child;
		parent.right = grand;
		
		afterRotate(grand, parent, child);
	}
	
	private void afterRotate(Node<E> grand,Node<E> parent,Node<E> child) {
		//让parent成为子树的根节点
				parent.parent = grand.parent;
				if (grand.isLeftChild()) {
					grand.parent.left = parent;
				} else if (grand.isRightChild()){
					grand.parent.right = parent;
				} else {
					root = parent;
				}
				//更新child的根节点
				if (child != null) {
					child.parent = grand;
				}
				//更新grand的根节点
				
				grand.parent = parent;
				
				//更新高度
				updateHeight(grand);
				updateHeight(parent);
	}
	
	private boolean isBalanced(Node<E> node) {
		return Math.abs(((AVLNode<E>)node).balanceFactor()) <= 1;
	}
	
	private void updateHeight(Node<E> node) {
		((AVLNode<E>) node).updateHeight();
		
	}
	
	private static class AVLNode<E> extends Node<E> {
		int height = 1;
		public AVLNode(E element, Node<E> parent) {
			super(element, parent);
		}
		
		public int balanceFactor() {
			int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
			return leftHeight - rightHeight;
		}
		
		public void updateHeight() {
			int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
			height = 1 + Math.max(leftHeight, rightHeight);
		}
		
		public Node<E> tallerChild() {
			int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
			if (leftHeight > rightHeight) return left;
			if (leftHeight < rightHeight) return right;
			return isLeftChild() ? left : right;
							
		}

		
		
		public String toString() {
		
			String parentString = "null";
			if (parent != null) {
				parentString = parent.element.toString();
			}
			return element + "_p(" + parentString + ")_h(" + height + ")";
		}
	}
}
