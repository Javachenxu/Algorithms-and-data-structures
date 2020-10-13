package 二叉树;
//https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/submissions/
public class _701_二叉搜索树中的插入操作 {
	    public TreeNode insertIntoBST(TreeNode root, int val) {
	    /*
	     * 算法思想：比较插入值val与根节点，如果val < root.val ，
	     * 那么说明要插入的节点在根节点左边，反之，在右边。循环执行。
	     */
	        //添加第一个节点
	      
	        if (root == null) {
	            return new TreeNode(val);
	        }
	        //添加后续节点
	        TreeNode node = root; 
	        /*   
	        while (node != null) {
	            if (val < node.val) {
	                if (node.left == null) {
	                    node.left = new TreeNode(val);
	                    break;
	                } else {
	                    node = node.left;
	                }
	            } else {
	                if (node.right == null) {
	                    node.right = new TreeNode(val);
	                    break;
	                } else {
	                    node = node.right;
	                }
	            }
	        }
	        return root;
	        */
	        //递归法
	            if ( node.val > val) {
	                node.left = insertIntoBST(node.left,val);
	            } else {
	                node.right = insertIntoBST(node.right,val);
	            }
	        return root;

	    }
}
