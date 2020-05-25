package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class Main114 {
    //method 1
//    public void flatten(TreeNode root) {
//        if (root == null){
//            return;
//        }
//       List<TreeNode> list = new ArrayList<>();
//       flatten(root,list);
//       root = list.get(0);
//       TreeNode temp = root;
//       temp.left = null;
//       for (int i=1;i<list.size();i++){
//           temp.right = list.get(i);
//           temp.left = null;
//           temp = temp.right;
//       }
//       temp.left = null;
//       temp.right = null;
//    }
//
//    public void flatten(TreeNode root, List<TreeNode> list){
//       if (root == null){
//           return ;
//       }
//       list.add(root);
//       flatten(root.left,list);
//       flatten(root.right,list);
//    }
    TreeNode pre;
    public void flatten(TreeNode root) {
        TreeNode temp = new TreeNode(0);
        pre = temp;
        flattenHelp(root);
        root = temp.right;
    }

    public void flattenHelp(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode left,right;
        left = root.left;
        right = root.right;
        pre.right = root;
        pre.left = null;
        pre=pre.right;
        flattenHelp(left);
        flattenHelp(right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode(1, 2, 5, 3, 4, null, 6);
        Main114 main114 = new Main114();
        main114.flatten(treeNode);
    }
}
