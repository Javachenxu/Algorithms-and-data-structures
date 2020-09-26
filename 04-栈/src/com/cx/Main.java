package com.cx;

public class Main {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(11);
		stack.push(22); 
		stack.push(33);
		stack.push(44);
		System.out.println("栈顶元素是"+stack.top());
		while(!stack.isEmpty()) {
		System.out.println(stack.pop());
		}
		System.out.println(stack);
		stack.clear();
		System.out.println(stack);
	
	}
}
