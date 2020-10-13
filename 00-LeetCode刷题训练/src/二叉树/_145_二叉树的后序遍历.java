package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class _145_二叉树的后序遍历 {
	public List<Integer> postorderTraversal(TreeNode root) {
		//递归法
		postOrder(root);
	    return result;
	}
	private List<Integer> result = new ArrayList<>();
	private void postOrder(TreeNode root) {
		if (root == null) return;
	    postorderTraversal(root.left);
	    postorderTraversal(root.right);
	    result.add(root.val);
	}
}
