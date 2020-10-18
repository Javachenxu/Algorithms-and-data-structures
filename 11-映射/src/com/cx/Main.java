package com.cx;

import com.cx.map.Map;
import com.cx.map.Map.Visitor;
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
	public static void main(String args[]) {
		test1();
	}
}
