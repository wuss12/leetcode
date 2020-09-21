package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 */
public class Main538 {
//    public TreeNode convertBST(TreeNode root) {
//        coverBstHelp(root,0);
//        return root;
//    }
//
//    public int coverBstHelp(TreeNode root,int value){
//        if (root == null){
//            return value;
//        }
//        int i = coverBstHelp(root.right, value);
//        value = i+root.val;
//        root.val = value;
//        return  coverBstHelp(root.left,value);
//    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }


}
