package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *    返回它的最小深度  2.
 */
public class Main111 {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = minDepthHelper(root.left);
        int right = minDepthHelper(root.right);
        if (root.left==null||root.right==null){
            return Math.max(left,right)+1;
        }
        return Math.min(left,right)+1;
    }
    public int minDepthHelper(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right== null){
            return 1;
        }
        Integer left=null ,right=null;
        if (root.left!= null){
            left = minDepthHelper(root.left)+1;
        }
        if (root.right!= null){
            right = minDepthHelper(root.right)+1;
        }
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        return Math.min(left,right);
    }

    public static void main(String[] args) {
        Main111 main111 = new Main111();
        System.out.println(main111.minDepth(TreeNode.getTreeNode(3,9,20,1,null,15,7)));
        System.out.println(main111.minDepth(TreeNode.getTreeNode(3,9,20,null,null,15,7)));
        System.out.println(main111.minDepth(TreeNode.getTreeNode(1,2)));
        System.out.println(main111.minDepth(TreeNode.getTreeNode(-9,-3,2,null,4,4,0,-6,null,-5)));
    }
}
