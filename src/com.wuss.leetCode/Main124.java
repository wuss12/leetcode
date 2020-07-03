package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 */
public class Main124 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        getMaxSum(root);
        return maxSum;
    }

    private int getMaxSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            maxSum = Math.max(root.val,maxSum);
            return root.val;
        }
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        int value = root.val;

        if (root.left != null){
            left = getMaxSum(root.left);
        }
        if (root.right != null){
            right = getMaxSum(root.right);
        }
        int max = Math.max(Math.max(value,left),right);
        if ( left < 0){
            left = 0;
        }
        if ( right < 0){
            right = 0;
        }
        max = Math.max(max,left+right+value);
        maxSum = Math.max(max,maxSum);
        return Math.max(left,right)+root.val;
    }



    public static void main(String[] args) {
//        TreeNode node = TreeNode.getTreeNode(0);
        TreeNode node = TreeNode.getTreeNode(5,4,8,11,null,13,4,7,2,null,null,null,1);
//        TreeNode node = TreeNode.getTreeNode(1, -2, -3, 1, 3, -2, null, -1);
//        TreeNode node = TreeNode.getTreeNode(-10,9,20,null,null,15,7);
        Main124 main124 = new Main124();
        System.out.println(main124.maxPathSum(node));


    }
}
