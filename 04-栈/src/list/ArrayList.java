package list;

//import List.AbstractList;

//动态数组接口设计
/*
 * int size(); //元素的数量
 * boolean isEmpty();//是否为空
 * boolean contains(E element); //是否包含某个元素
 * voidadd(E element); //添加元素到最后
 * E get(int index); //返回index 位置对应的元素
 * E set(int index,E element); //设置index位置的元素
 * void add(int index,E element); //往index位置添加元素
 * E remove(int index); //删除index位置对应的元素
 * int indexOf(E element); //查看元素的位置
 * void clear(); //清除所有元素
 * 
 * */
public class ArrayList<E> extends AbstractList<E>{
	//元素的数量
	
	//所有的元素
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	/*
	 * 保证要有capacity的容量
	 * @param capacity
	 */
	private void ensureCapacity(int capacity) {
		int oidCapacity = elements.length;
		if (oidCapacity >= capacity) return;
		
		//新容量为旧容量的1.5倍
		int newCapacity = oidCapacity + (oidCapacity >> 1);
		@SuppressWarnings("unchecked")
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oidCapacity + "扩容为" + newCapacity);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		capacity = (capacity < DEFAULT_CAPACITY)? DEFAULT_CAPACITY:capacity;
		elements = (E[]) new Object[capacity];
	}
	public  ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	/*
	 * 清除所有元素
	 * */
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}
	/*

	/*
	 * 获取index位置的元素
	 * @param index
	 * @return
	 */
	public E get(int index) {
		//if (index < 0 || index >= size) {
		//	throw new IndexOutOfBoundsException("Index"+ index + ",Size"+ size);
		//}
		rangeCheck(index);
		return elements[index] ;
	}
	/*
	 * 设置index位置的元素
	 * @param index
	 * @param element
	 * @return 原来的元素
	 */
	public E set(int index,E element) {
		/*if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index"+ index + ",Size"+ size);
		}*/
		rangeCheck(index);
		E old = elements[index];
		elements[index] = element;
		return old;
	}
	/*
	 * 打印数组
	 */
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(",[");
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(",");
			}
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();
		
	}
	/*
	 * 在某一位置添加元素
	 * @param index
	 * @return 
	 */
	public void add(int index, E element) {
		/*if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index"+ index + ",Size"+ size);
		}*/
		rangeCheckForAdd(index);
		
		//保证容量
		ensureCapacity(size + 1);
		
		for (int i = size - 1; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
		size++;
	}
	/*
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		/*if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index"+ index + ",Size"+ size);
		}*/
		rangeCheck(index);
		E old = elements[index];
		for (int i = index + 1; i < size - 1; i++) {
			elements[i - 1] = elements[i];
		}
		size--;
		elements[size] = null;
		return old;
		
	}
	
	/*
	 * 查看元素的位置
	 * @param index
	 * @return
	 */
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) return i;
			}
		}else {
			for (int i = 0; i < size; i++) {
				if (elements[i] .equals(element)) {
					return i;
				}
			}
		}
		return ELEMENT_NOT_FOUND;
	}
}
