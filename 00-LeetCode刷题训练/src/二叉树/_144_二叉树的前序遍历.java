package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_二叉树的前序遍历 {
	
    public List<Integer> preorderTraversal(TreeNode root) {
    	/*
       //递归法
       preOrder(root);
       return result;
    }
    private List<Integer> result = new ArrayList<>();
    private void preOrder(TreeNode root) {
        if (root == null) return;
        
        preorderTraversal(root.left);
        result.add(root.val);
        preorderTraversal(root.right);
    }*/
    	//迭代(栈实现)
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        TreeNode node = root;
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
    			stack.push(node.right);
    		}
    		if (node.left != null) {
    			stack.push(node.left);
    		}
        }
        return list;
        }
}
