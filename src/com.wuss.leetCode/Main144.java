package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 */
public class Main144 {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        preorderTraversal(root,list);
//        return list;
//    }
//
//    public void preorderTraversal(TreeNode root, List<Integer> list){
//        if(root == null){
//            return;
//        }
//        list.add(root.val);
//        preorderTraversal(root.left,list);
//        preorderTraversal(root.right,list);
//    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(root==null){
            return list;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            list.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return list;
    }
}
