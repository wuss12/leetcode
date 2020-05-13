package com.wuss.leetCode;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main103 {
//    metho1 非递归
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> resultList = new ArrayList<>();
//        if (root == null){
//            return resultList;
//        }
//        boolean leftFirst = true;
//        Deque<TreeNode> deque = new LinkedList<>();
//        deque.add(root);
//        TreeNode tempNode;
//        while (!deque.isEmpty()){
//            int size = deque.size();
//            List<Integer> listI = new ArrayList<>();
//            if (leftFirst){
//                for (int i =0;i<size;i++){
//                    tempNode = deque.pollFirst();
//                    if (tempNode == null){
//                        continue;
//                    }
//                    listI.add(tempNode.val);
//                    if (tempNode.left != null){
//                        deque.add(tempNode.left);
//                    }
//                    if (tempNode.right != null){
//                        deque.add(tempNode.right);
//                    }
//                }
//                leftFirst = false;
//
//            }else {
//                for (int i=size-1;i>=0;i--){
//                    tempNode = deque.pollLast();
//                    if (tempNode == null){
//                        continue;
//                    }
//                    listI.add(tempNode.val);
//                    if (tempNode.right != null){
//                        deque.addFirst(tempNode.right);
//                    }
//                    if (tempNode.left != null){
//                        deque.addFirst(tempNode.left);
//                    }
//                    leftFirst = true;
//
//                }
//            }
//            resultList.add(listI);
//        }
//        return resultList;
//    }

//    //method2 递归
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        zigzagLevelOrder(nodeList,resultList,true);
        return resultList;
    }

    public void zigzagLevelOrder(List<TreeNode> nodeList,List<List<Integer>> resultList,boolean leftFirst){
        if (nodeList.isEmpty()){
            return ;
        }

        int size = nodeList.size();
        List<Integer> listI = new ArrayList<>(size);
        TreeNode temp;
        if (leftFirst){
            for (int i=0;i<size;i++){
                temp = nodeList.get(i);
                if (temp != null){
                    listI.add(temp.val);
                }
            }
        }else {
           for (int i = size-1;i>=0;i--){
               temp = nodeList.get(i);
               if (temp != null){
                   listI.add(temp.val);
               }
           }
        }


        resultList.add(listI);
        List<TreeNode> newList = new ArrayList<>();
        for (int i = 0;i<= size-1;i++){
            temp = nodeList.get(i);
            if (temp == null){
                continue;
            }
            if (temp.left!= null){
                newList.add(temp.left);
            }
            if (temp.right!= null){
                newList.add(temp.right);
            }
        }
        zigzagLevelOrder(newList,resultList,!leftFirst);
    }

    public static void main(String[] args) {
        Main103 main103 = new Main103();
        TreeNode treeNode = TreeNode.getTreeNode(1, 2, 3, 4, null, null, 5);
        List<List<Integer>> lists = main103.zigzagLevelOrder(treeNode);
        lists.forEach(e-> System.out.println(e));

    }
}
