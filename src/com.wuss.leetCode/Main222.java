package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * 222. 完全二叉树的节点个数
 * 给出一个完全二叉树，求出该树的节点个数。
 */
public class Main222 {
    public int countNodes(TreeNode root) {
        if (root == null ){
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+1;

    }
}
