package com.wuss.leetCode;

import java.util.*;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class Main95 {
//    method1
//    public List<TreeNode> generateTrees(int n) {
//        List<TreeNode> nodeList = new ArrayList<>();
//        List<Integer> list = initList(n);
//        List<List<Integer>> resultList = new ArrayList<>();
//        initCom(list,resultList,new ArrayList<>());
//
//        for (int i=0;i<resultList.size();i++){
//            List<Integer> it = resultList.get(i);
//            Tree tree = new Tree();
//            for (int j : it){
//                tree.insert(j);
//            }
//            boolean equalFlag = false;
//            for (int k=0;k<nodeList.size();k++){
//                if (equal(nodeList.get(k),tree.root)){
//                    equalFlag = true;
//                    break;
//                }
//            }
//            if (!equalFlag){
//                nodeList.add(tree.root);
//            }
//        }
//
//        return nodeList;
//    }
//
//    private static List<Integer> initList(int n){
//        List<Integer> list = new ArrayList<>(n);
//        for (int i=1;i<=n;i++){
//            list.add(i);
//        }
//        return list;
//    }
//
//    private static void initCom(List<Integer> list,List<List<Integer>> resultList,List<Integer> tempList){
//        if (list.size() == 1){
//            tempList.add(list.get(0));
//            resultList.add(new ArrayList<>(tempList));
//            tempList.remove(list.get(0));
//            return;
//        }
//        for (int i = list.size()-1;i>=0;i--){
//            Integer tempValue = list.get(i);
//            tempList.add(tempValue);
//            list.remove(tempValue);
//            initCom(list,resultList,tempList);
//            tempList.remove(tempList.size()-1);
//            list.add(i,tempValue);
//        }
//    }
//    static class Tree{
//        TreeNode root ;
//
//        public void insert(int value){
//            TreeNode newNode = new TreeNode(value);
//            if (root == null){
//                root = newNode;
//                return;
//            }
//            TreeNode temp = root;
//            TreeNode parent = root;
//            while (temp != null){
//                parent = temp;
//                if (value < temp.val){
//                    temp = temp.left;
//                }else {
//                    temp = temp.right;
//                }
//            }
//            if (value < parent.val){
//                parent.left = newNode;
//            }else {
//                parent.right = newNode;
//            }
//        }
//
//    }
//
//    private static boolean equal(TreeNode node1,TreeNode node2){
//        TreeNode temp1,temp2;
//        temp1 = node1;
//        temp2 = node2;
//        if (node1 == node2){
//            return true;
//        }
//        if (node1==null || node2 ==null){
//            return false;
//        }
//        if (temp1.val != temp2.val){
//            return false;
//        }
//        return equal(temp1.left,temp2.left) && equal(temp1.right,temp2.right);
//    }

    //method2
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (n == 0) {
            return ans;
        }
        return getAns(1, n);

    }
    private List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (start>end){
            ans.add(null);
            return ans;
        }
        if (start == end){
            ans.add(new TreeNode(start));
            return ans;
        }
        for (int i=start;i<=end;i++){
            List<TreeNode> leftTree = getAns(start,i-1);
            List<TreeNode> rightTree = getAns(i+1,end);
            for (TreeNode l: leftTree){
                for (TreeNode r : rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
       return ans;
    }







}
