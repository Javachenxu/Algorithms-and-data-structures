package com.cx.map;

//红黑树实现

public interface Map<K, V> {
	int size();//有多少对key和value
	boolean isEmpty();//检查是否为空
	void clear();//清空
	V put(K key,V value);//添加映射
	V get(K key);//获取某对映射
	V remove(K key);//删除映射
	boolean cobtainsKey(K key);//检查某个key存不存在
	boolean cobtainsValue(V value);//检查某个key存不存在
	void traversal(Visitor<K, V> visitor);//遍历接口
	
	public static abstract class Visitor<K,V> {
		boolean stop;
		abstract boolean visit(K key,V value);
	}
	
}
