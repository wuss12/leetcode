package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * @create: 2021/04/27 09:10
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 */
public class Main938 {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        vist(root,low,high);
        return sum;
    }

    // method 1
//    private void vist(TreeNode root,int low,int high){
//        if (root == null){
//            return;
//        }
//        int val = root.val;
//        if (val >= low){
//            vist(root.left,low,high);
//        }
//
//        if (low<= val && val<=high){
//            sum+=val;
//        }
//        if (val<= high){
//            vist(root.right,low,high);
//        }
//    }

    // method 2
    private void vist(TreeNode root,int low,int high){
        if (root == null){
            return;
        }
        int val = root.val;
        if (val >= low){
            vist(root.left,low,high);
        }

        if (low<= val && val<=high){
            sum+=val;
        }
        if (val<= high){
            vist(root.right,low,high);
        }
    }
}
