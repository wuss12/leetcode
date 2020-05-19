package com.wuss.leetCode;

import java.util.*;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class Main107 {
    //    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (root == null){
//            return result;
//        }
//        TreeNode temp = root;
//        Deque<TreeNode> stack = new LinkedList<>();
//        stack.push(temp);
//        while (!stack.isEmpty()){
//            List<Integer> list = new ArrayList<>();
//            int size = stack.size();
//            for (int i=0;i<size;i++){
//                temp = stack.pollFirst();
//                list.add(temp.val);
//                if (temp.left!=null){
//                    stack.add(temp.left);
//                }
//                if (temp.right!= null){
//                    stack.add(temp.right);
//                }
//            }
//            result.add(list);
//        }
//        List<List<Integer>> resultDes = new ArrayList<>();
//        for (int i= result.size()-1;i>=0;i--){
//            resultDes.add(result.get(i));
//        }
//        return resultDes;
//    }

    //递归
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, root, 1);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            ans.add(result.get(i));
        }
        return ans;
    }

    public void helper(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null){
            return;
        }
        if (result.size() < level) {
            result.add(new ArrayList<>());
        }
        result.get(level - 1).add(root.val);
        helper(result, root.left, level + 1);
        helper(result, root.right, level + 1);
    }

}
