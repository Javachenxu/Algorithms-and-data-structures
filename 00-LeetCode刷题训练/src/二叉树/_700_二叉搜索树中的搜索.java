package 二叉树;
//https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
public class _700_二叉搜索树中的搜索 {
	public TreeNode searchBST(TreeNode root, int val) {
	 //迭代法
    /*
     * 根节点为空，即root == null，那么return null，
     *  如果根节点不为空，且需要找到的值是根节点的值。那么 return root；
     *  如果根节点不为空，且需要找到的值不是根节点的值，那么根据BST的性质，
     *  判断所查节点在BST的左子树还是右子树上，循环上一过程，
     *  遍历完成后如果节点不存在，
    */
    /*
    while (root != null && val != root.val)
    root = val < root.val ? root.left : root.right;
    return root;
    */
    //递归法
    if(root == null || val == root.val) return root;
    return root = val < root.val ? searchBST(root.left,val) : searchBST(root.right,val);
}
}
