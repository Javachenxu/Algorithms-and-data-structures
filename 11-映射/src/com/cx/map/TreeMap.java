package com.cx.map;

public class TreeMap<K, V> implements Map<K, V> {
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	
	public int size() {
		
		return 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public V put(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	public V get(K key) {
		
		return null;
	}

	public V remove(K key) {
		
		return null;
	}

	public boolean cobtainsKey(K key) {
		
		return false;
	}

	public boolean cobtainsValue(V value) {
		
		return false;
	}

	@Override
	public void traversal(Visitor<K, V> visitor) {
		
	}
	
	private static class Node<K, V> {
		K key;
		V value;
		boolean color = RED;
		Node<K, V> left;
		Node<K, V> right;
		Node<K, V> parent;
		public Node(K key,V value, Node<K, V> parent) {
			this.key = key;
			this.value = value;
			this.parent = parent;
		}
		
		public boolean isLeaf() {
			return left == null && right == null;
		}
		
		public boolean hasTwoChildren() {
			return left != null && right != null;
		}
		
		public boolean isLeftChild() {
			return parent != null && this == parent.left;
		}
		
		public boolean isRightChild() {
			return parent != null && this == parent.right;
		}
		
		public Node<K, V> sibling() {
			if (isLeftChild()) {
				return parent.right;
			}
			
			if (isRightChild()) {
				return parent.left;
			}
			
			return null;
		}
	}

}
