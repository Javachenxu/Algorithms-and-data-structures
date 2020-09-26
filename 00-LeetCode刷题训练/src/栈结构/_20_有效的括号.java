package 栈结构;
/*
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @author chnexu
 */
/*
 * 算法思想：定义一个哈希表HashMap，在哈希表中定义好匹配规则，遍历链表，如果匹配了
 */
import java.util.HashMap;
import java.util.Stack;

//LeetCode第20题有效的括号
public class _20_有效的括号 {
	private static HashMap<Character, Character> map = new HashMap<>();
	
	static {
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');	
	}
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (map.containsKey(c)) { 
                	stack.pop();
                	}else {
                		if (stack.isEmpty()) return false;
                		if (c != map.get(stack.pop())) return false;
					}
            }
        } 
        return stack.isEmpty();
	}
}
