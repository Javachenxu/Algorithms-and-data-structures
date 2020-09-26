package 链表;

/*
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @author chenxu
 * 题目：请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。
 * 传入函数的唯一参数为 要被删除的节点 。
 */
/*
 * 算法思想：使用被删除的节点的下一个节点的值覆盖掉将要被删除的值。
 * 再进行node.next = node.next.next;
 * 实际上是将node.next节点删掉了。
 */
public class _237_删除链表中的节点 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		}
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
