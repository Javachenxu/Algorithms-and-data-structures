package com.cx;

import com.cx.Times.Task;
import com.cx.file.FileInfo;
import com.cx.file.Files;
import com.cx.set.ListSet;
import com.cx.set.Set;
import com.cx.set.Set.Visitor;
import com.cx.set.TreeSet;

public class Main {
	static void test1() {
		Set<Integer> listSet = new ListSet<>();
		listSet.add(10);
		listSet.add(11);
		listSet.add(12);
		listSet.add(13);
		listSet.add(10);
		
		listSet.traversal(new Visitor<Integer>() {
			
			public boolean visit(Integer element) {
				System.out.println(element);
				return false;
			}
		});
	}
	
	static void test2() {
		Set<Integer> treeSet = new TreeSet<>();
		treeSet.add(12);
		treeSet.add(13);
		treeSet.add(10);
		treeSet.add(11);
	
		treeSet.add(10);
		
		treeSet.traversal(new Visitor<Integer>() {
			
			public boolean visit(Integer element) {
				System.out.println(element);
				return false;
			}
		});
	}
	static void testSet(Set<String> set,String[] words) {
		for (int i = 0; i < words.length; i++) {
			set.add(words[i]);
		}
		for (int i = 0; i < words.length; i++) {
			set.contains(words[i]);
		}
		for (int i = 0; i < words.length; i++) {
			set.remove(words[i]);
		}
	}
	static void test3() {
		FileInfo fileInfo = Files.read("D:\\file", new String[]{"java"});
		System.out.println("文件数量：" + fileInfo.getFiles());
		System.out.println("代码行数：" + fileInfo.getLines());
		String[] words = fileInfo.words();
		System.out.println("单词数量：" + fileInfo.words().length);
		Times.test("ListSet", new Task() {
			public void execute() {
				testSet(new ListSet<>(), words);
			}
		});
		Times.test("TreeSet", new Task() {
			public void execute() {
				testSet(new TreeSet<>(), words);
			}
		});
	}
	public static void main(String[] args) {
		test3();

	}

}
