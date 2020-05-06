package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 */
public class Main94 {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        inorderTraversal(root,list);
//        return list;
//    }
//
//    public void inorderTraversal(TreeNode root, List<Integer> list) {
//        TreeNode temp = root;
//        if (temp == null){
//            return;
//        }
//        inorderTraversal(root.left,list);
//        list.add(temp.val);
//        inorderTraversal(root.right,list);
//    }

    //非递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
       while (temp != null||!stack.isEmpty()){

           while (temp != null){
               stack.push(temp);
               temp = temp.left;
           }
           if (!stack.isEmpty()){
               TreeNode pop = stack.pop();
               list.add(pop.val);
               temp = pop.right;
           }


       }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        root.right = node2;
        node2.left = node3;
        Main94 main94 = new Main94();
        List<Integer> list = main94.inorderTraversal(root);
        System.out.println(list);
    }
}
