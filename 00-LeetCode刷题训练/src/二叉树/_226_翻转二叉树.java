package 二叉树;

import java.util.LinkedList;
import java.util.Queue;



/*
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 题目大意：将所有节点的左右子树都交换
 * 算法思想
 */
public class _226_翻转二叉树 {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return root;
		//前序遍历
		/*
		TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        */
		
		//中序遍历
		/*
		invertTree(root.left);
		TreeNode tmp = root.left;
		root.left = root.right;
        root.right = tmp;
        invertTree(root.right);
        */
		
		//后序遍历
		/*
		invertTree(root.left);
		invertTree(root.right);
		TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        */
		//层序遍历
		if (root == null) return root;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			
			TreeNode tmp = node.left;
	        node.left = node.right;
	        root.right = tmp;
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
        return root;
    }
}
