package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 */
public class Main110 {
//    public boolean isBalanced(TreeNode root) {
//        if (root == null){
//            return true;
//        }
//        int left = isBalanced(root.left,1);
//        int right = isBalanced(root.right,1);
//        boolean result = Math.abs(left-right)<=1;
//        if (!result){
//            return false;
//        }
//        result = isBalanced(root.left) && isBalanced(root.right);
//        return result;
//    }
//
//    private int isBalanced(TreeNode root,int level){
//        if (root == null){
//          return level;
//        }
//        int left = isBalanced(root.left,level+1);
//        int right= isBalanced(root.right,level+1);
//       return Math.max(left,right);
//    }

    //method2
    public boolean isBalanced(TreeNode root) {
        return helper(root)>=0;
    }

    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = helper(root.left);
        int r = helper(root.right);
        if(l==-1 || r==-1 || Math.abs(l-r)>1) {
            return -1;
        }
        return Math.max(l,r) +1;
    }


    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode(3, 9, 20, null, null, 15, 7);
        TreeNode treeNode2 = TreeNode.getTreeNode(1,2,2,3,3,null,null,4,4);
        Main110 main110 = new Main110();
        System.out.println(main110.isBalanced(treeNode));
        System.out.println(main110.isBalanced(treeNode2));
    }
}
