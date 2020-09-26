package 链表;
/*
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @author chenxu
 */
/*
 * 算法思想：定义一个指向head的链表节点cur，比较节点cur与其后继节点cur.next的值val是否
 * 相等，若相等，就让cur.next = cur.next.next,即是让cur.next.next节点
 * 覆盖cur.next.若不相等继续遍历链表。
 * 
 */
public class _83_删除排序链表中的重复元素 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		}
	 public ListNode deleteDuplicates(ListNode head) {
	        ListNode cur = head;
	        //判断边界条件
	        while(cur != null && cur.next != null)  {
	            if(cur.val == cur.next.val) {
	                cur.next = cur.next.next;//覆盖
	            } else {
	                cur = cur.next;
	            }
	        }
	        return head;
	    }
}
