package 链表;

/*
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @author chenxu
 */
/*
 * 1.递归法：将链表的头结点与其他元素分开讨论。
 * 2.非递归法：使用虚拟头结点法，头结点与其他节点一视同仁
 */
public class _203_移除链表元素 {
	class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		 val = x;
		 }
	}
	//递归法
	/*public ListNode removeElements(ListNode head,int val) {
		if(head == null) return null;
		//先处理链表除头结点以外的元素
		head.next = removeElements(head.next,val);
		//再处理头结点
		return head.val == val ? head.next : head;
	}*/
	//非递归定义虚拟头结点法
	public ListNode removeElements(ListNode head,int val) {
		ListNode Xuni = new ListNode(val - 1);
	       Xuni.next = head;
	       ListNode prev = Xuni;
	       while(prev.next != null) {
	           if(prev.next.val == val) {
	               prev.next = prev.next.next;
	           } else {
	               prev = prev.next;
	           }
	       }
	       return Xuni.next;
	}
}
