package list;

//import list;
//抽象出公共类

public abstract class AbstractList<E> implements List<E> {
	
	protected int size;
	
	public int size() {
		return size ;
	}
	@Override
	public boolean isEmpty() {
		
		return size == 0;
	}
	@Override
	public void add(E element) {
		add(size, element);
	}
	@Override
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	protected void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + "Size" + size);
	}
	//检查范围
	protected void rangeCheck(int index) {
		if(index < 0 || index >= size) {
			outOfBounds(index);
		}
	}
	//添加操作检查范围
	protected void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
	}

}
