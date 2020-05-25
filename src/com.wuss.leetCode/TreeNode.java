package com.wuss.leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    //按照层次遍历入参生成二叉树
    public static TreeNode getTreeNode(Integer... arr){
        int len = arr.length;
        if (len == 0){
            return null;
        }
        int i=0;
        TreeNode root = new TreeNode(arr[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        TreeNode tempNode;
        while (!deque.isEmpty() && i<len){
            int size = deque.size();
            for (int j=0;j<size;j++){
               tempNode  = deque.pollFirst();
               if (tempNode == null){
                   continue;
               }
               if (i+1<len && arr[++i] != null){
                   tempNode.left = new TreeNode(arr[i]);
               }
               if (i+1<len && arr[++i] != null){
                    tempNode.right = new TreeNode(arr[i]);
               }

               deque.add(tempNode.left);
               deque.add(tempNode.right);
            }
        }
        return root;
    }
}