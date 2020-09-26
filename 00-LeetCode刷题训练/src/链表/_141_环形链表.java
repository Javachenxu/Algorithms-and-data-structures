package 链表;
/*
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @author chnexu
 */
/*
 * 算法思想：使用快慢指针，定义一个fast，每次遍历跨越2个节点，slow节点，依次遍历，如果有
 * 环，两个节点便会相遇，即fast == slow、
 */
public class _141_环形链表 {
	class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		 val = x;
		 next = null;
		 }
	}
	 public boolean hasCycle(ListNode head) {
		 if(head == null || head.next == null) return false;
		 ListNode slow = head;
		 ListNode fast = head.next;
		 while (fast != null && fast.next != null) {
			 if (slow == fast) return true;
				slow = slow.next;
				fast = fast.next.next;
		}
		 return false;
	 }
}
