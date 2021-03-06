package com.wuss.leetCode;

import java.util.*;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class Main257 {

    //深度优先
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        binaryTreePathHelper(root,list,"");
        return list;
    }

    // 深度优先
    private void binaryTreePathHelper(TreeNode root,List<String> list,String str){
        if (root == null){
            return;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.append(root.val);
        if (root!= null && root.left == null && root.right == null){
            list.add(sb.toString());
            return;
        }
        sb.append("->");

        if(root.left != null){
            binaryTreePathHelper(root.left,list,sb.toString());
        }
        if(root.right != null){
            binaryTreePathHelper(root.right,list,sb.toString());
        }


    }

// 广度优先
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> paths = new ArrayList<String>();
//        if (root == null) {
//            return paths;
//        }
//        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
//        Queue<String> pathQueue = new LinkedList<String>();
//
//        nodeQueue.offer(root);
//        pathQueue.offer(Integer.toString(root.val));
//
//        while (!nodeQueue.isEmpty()) {
//            TreeNode node = nodeQueue.poll();
//            String path = pathQueue.poll();
//
//            if (node.left == null && node.right == null) {
//                paths.add(path);
//            } else {
//                if (node.left != null) {
//                    nodeQueue.offer(node.left);
//                    pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
//                }
//
//                if (node.right != null) {
//                    nodeQueue.offer(node.right);
//                    pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
//                }
//            }
//        }
//        return paths;
//    }






}
