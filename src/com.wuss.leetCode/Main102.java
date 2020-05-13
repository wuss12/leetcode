package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Main102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        levelOrder(nodeList,result);
        return result;
    }

    public void levelOrder(List<TreeNode> list,List<List<Integer>> resultList){
        if (list == null ||list.isEmpty()){
            return;
        }
        List<TreeNode> newList = new ArrayList<>();
        List<Integer> listI = new ArrayList<>();
        for (TreeNode node :list){
            listI.add(node.val);
            if (node.left!= null){
                newList.add(node.left);
            }
            if (node.right!= null){
                newList.add(node.right);
            }

        }
        resultList.add(listI);
        levelOrder(newList,resultList);
    }
}
