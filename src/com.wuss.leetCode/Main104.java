package com.wuss.leetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class Main104 {
    //method1
//    public int maxDepth(TreeNode root) {
//        if (root == null){
//            return 0;
//        }
//        Deque<TreeNode> deque = new LinkedList();
//        deque.add(root);
//        TreeNode tempNode;
//        int deep = 0;
//        while (!deque.isEmpty()){
//            deep++;
//            int size = deque.size();
//            for (int i=0;i<size;i++){
//                tempNode = deque.pollFirst();
//                if (tempNode == null){
//                    continue;
//                }
//                if (tempNode.left != null){
//                    deque.add(tempNode.left);
//                }
//                if (tempNode.right != null){
//                    deque.add(tempNode.right);
//                }
//            }
//        }
//        return deep;
//
//    }

    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDep = maxDepth(root.left);
        int rightDep = maxDepth(root.right);
        return Math.max(leftDep,rightDep)+1;
    }
}
