package com.cx;

import com.cx.Times.Task;
import com.cx.file.FileInfo;
import com.cx.file.Files;
import com.cx.map.Map;
import com.cx.map.Map.Visitor;
import com.cx.set.Set;
import com.cx.set.TreeSet;
import com.cx.map.TreeMap;

public class Main {
	
	static void test1() {
		Map<String, Integer> map = new TreeMap<>();
		map.put("class", 2);
		map.put("public", 5);
		map.put("text", 6);
		map.put("public", 8);
		
		map.traversal(new Visitor<String,Integer>() {
			public boolean visit(String key, Integer value) {
				System.out.println(key + "_" + value);
				return false;
			}
		});
	}
	
	static void test2() {
		FileInfo fileInfo = Files.read("D:\\file\\09-红黑树\\src", new String[]{"java"});
		System.out.println("文件数量：" + fileInfo.getFiles());
		System.out.println("代码行数：" + fileInfo.getLines());
		String[] words = fileInfo.words();
		System.out.println("单词数量：" + fileInfo.words().length);
		
		Map<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < words.length; i++) {
			Integer count = map.get(words[i]);
			count = count == null ? 0 :count;
			map.put(words[i],count + 1);
		}
		map.traversal(new Visitor<String,Integer>() {
			public boolean visit(String key, Integer value) {
				System.out.println(key + "_" + value);
				return false;
			}
		});
		System.out.println(map.size());
	}
	
	static void test3() {
		Set<Integer> treeSet = new TreeSet<>();
		treeSet.add(12);
		treeSet.add(13);
		treeSet.add(10);
		treeSet.add(11);
		treeSet.add(10);
		
		treeSet.traversal(new Set.Visitor<Integer>() {
			
			public boolean visit(Integer element) {
				System.out.println(element);
				return false;
			}
		});
	}
	
	public static void main(String args[]) {
		test3();
	}
}
