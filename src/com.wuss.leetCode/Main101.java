package com.wuss.leetCode;

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
//        System.out.println("1111");
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

//    public boolean isSymmetric(TreeNode root){
//
//    }
}
