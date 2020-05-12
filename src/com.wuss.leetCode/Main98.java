package com.wuss.leetCode;

import java.util.Stack;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class Main98 {
    Integer minValue ;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        minValue = null;
        return isValidBSTs(root);
    }

    private boolean isValidBSTs(TreeNode root) {
        if (root == null ){
            return true;
        }
        boolean l = isValidBSTs(root.left);
        if (!l ){
            return false;
        }
        if (minValue == null){
            minValue = root.val;
        }else {
            if (root.val <= minValue){
                return false;
            }
        }

        minValue = root.val;
        boolean r = isValidBSTs(root.right);
        return r;
    }

// method2
    public boolean isValidBST1(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        Integer value = null;
        while (temp!= null || !stack.isEmpty()){
            while (temp!= null){
                stack.push(temp);
                temp = temp.left;
            }
            if (!stack.isEmpty()){
                TreeNode pop = stack.pop();
                if (value == null){
                    value = pop.val;
                }else {
                    if (value >= pop.val){
                        return false;
                    }
                }
                if (pop.right != null){
                    temp = temp.right;

                }
            }
        }
        return true;
    }
//method 3

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (! helper(node.right, val, upper)) {
            return false;
        }
        if (! helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return helper(root, null, null);
    }



}
