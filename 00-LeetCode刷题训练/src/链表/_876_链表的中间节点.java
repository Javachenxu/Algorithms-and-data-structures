package 链表;

/*
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @author chnexu
 */
public class _876_链表的中间节点 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	/*public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }*/
	//单指针法：遍历两次链表，第一次遍历链表的长度n，第二次遍历n/2次
	/*public ListNode middleNode(ListNode head) {
		 int n = 0;
	        ListNode cur = head;
	        while(cur != null) {
	            cur = cur.next;
	            ++n;
	        }
	        int k = 0;
	        cur = head;
	        while(k < n/2) {
	            cur = cur.next;
	            ++k;
	        }
	        return cur;
    }*/
	//直接遍历
	public ListNode middleNode(ListNode head) {
		ListNode[] A = new ListNode[100];
	       
        int i = 0;
        while(head != null) {
            A[i++] = head;
            head = head.next;
        }
        return A[i/2];
	}
}
