package 链表;

import 链表._237_删除链表中的节点.ListNode;

/*
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author chenxu
 */
/*
 * 算法思想：
 */
public class _206_反转链表 {
	/*public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
}*/
	//递归方法
	/*public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	
	}*/
	//非递归方法（迭代）
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) return head;
		
		ListNode newHead = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		return newHead;
		}
	
	}


