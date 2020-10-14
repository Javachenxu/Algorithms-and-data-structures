package com.cx.tree;

public class AVLTree<E> extends BST<E> {
	
	protected void afterAdd(Node<E> node) {
		while ((node = node.parent) != null) {
			if (isBalanced(node)) {
				//更新高度
				updateHeight(node);
			} else {
				//恢复平衡
				rebalance(node);
				//整棵树恢复平衡
				break;
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
	private void rebalance(Node<E> grand) {
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
	//左旋转
	private void rotateLeft(Node<E> node) {
		
	}
	//右旋转
	private void rotateRight(Node<E> node) {
		
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
		
	}
}
