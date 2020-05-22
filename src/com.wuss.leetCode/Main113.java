package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class Main113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result =  new ArrayList<>();
        TreeNode temp = root;
        pathSum(temp,sum,new ArrayList<>(),result);
        return result;
    }

    private void pathSum(TreeNode root,int left,List<Integer> list,List<List<Integer>> result){
        if (root == null){
            return;
        }
        if (root.left ==null && root.right == null && root.val == left){
            List<Integer> listT = new ArrayList<>(list);
            listT.add(root.val);
            result.add(listT);
            return;

        }
        list.add(root.val);
        pathSum(root.left,left-root.val,list,result);
        pathSum(root.right,left-root.val,list,result);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);
        Main113 main113 = new Main113();
        List<List<Integer>> lists = main113.pathSum(treeNode, 22);
        System.out.println(lists);
    }
}
