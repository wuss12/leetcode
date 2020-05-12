package com.wuss.leetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 */
public class Main101 {
//    metho 1
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null){
//            return true;
//        }
//        return isSymmetric(root.left,root.right);
//    }
//
//    public boolean isSymmetric(TreeNode left,TreeNode right){
//        if (left == null && right ==  null){
//            return true;
//        }
//        if (left == null|| right == null){
//            return false;
//        }
//        if (left.val != right.val){
//            return false;
//        }
//        boolean eq1 = isSymmetric(left.left, right.right);
//        if(!eq1){
//            return false;
//        }
//        return isSymmetric(left.right,right.left);
//    }

    //method 2
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null){
//            return true;
//        }
//        return isSymmetric(root.left,root.right);
//    }
//
//    public boolean isSymmetric(TreeNode left,TreeNode right){
//        if (left == null && right ==  null){
//            return true;
//        }
//        if (left == null|| right == null){
//            return false;
//        }
//        Deque<TreeNode> deque1 = new ArrayDeque<>();
//        Deque<TreeNode> deque2 = new ArrayDeque<>();
//        TreeNode tempL = left,tempR = right;
//        TreeNode popL,popR;
//        while (tempL!= null || !deque1.isEmpty()){
//            if (tempR == null && deque2.isEmpty()){
//                return false;
//            }
//            while (tempL!= null){
//                deque1.push(tempL);
//                tempL = tempL.left;
//            }
//            while (tempR != null){
//                deque2.push(tempR);
//                tempR = tempR.right;
//            }
//            if (deque1.size() != deque2.size()){
//                return false;
//            }
//            popL = deque1.pop();
//            popR = deque2.pop();
//            if (popL.val != popR.val){
//                return false;
//            }
//            tempL = popL.right;
//            tempR = popR.left;
//        }
//        return tempR == null && deque2.isEmpty();
//    }






}
