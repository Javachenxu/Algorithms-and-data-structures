package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class _94_二叉树的中序遍历 {
//递归法
	private List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
       //递归法
       inOrder(root);
       return result;
    }
    private void inOrder(TreeNode root) {
        if (root == null) return;
        
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
    }
}
