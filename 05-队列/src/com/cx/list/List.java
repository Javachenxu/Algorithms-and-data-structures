package com.cx.list;

public interface List<E> {
	
	 static final int ELEMENT_NOT_FOUND = -1;
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
		/*
		 * 清除所有元素
		 * */
		public void clear();
		/*
		 * 元素的数量
		 * */
		public int size() ;
		/*
		 * 是否为空
		 * */
		public boolean isEmpty();
		/*
		 * 添加元素到尾部
		 * @param index
		 * @return
		 */
		public void add(E element);
		/*
		 * 是否包含某个元素
		 */
		public boolean contains(E element) ;
		/*
		 * 获取index位置的元素
		 * @param index
		 * @return
		 */
		public E get(int index) ;
		/*
		 * 设置index位置的元素
		 * @param index
		 * @param element
		 * @return 原来的元素
		 */
		public E set(int index,E element);
		/*
		 * 打印数组
		 */
		public String toString() ;
		/*
		 * 在某一位置添加元素
		 * @param index
		 * @return 
		 */
		public void add(int index, E element) ;
		/*
		 * 删除index位置的元素
		 * @param index
		 * @return
		 */
		public E remove(int index);
		
		/*
		 * 查看元素的位置
		 * @param index
		 * @return
		 */
		public int indexOf(E element);

}
