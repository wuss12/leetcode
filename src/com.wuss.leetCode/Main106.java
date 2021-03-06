package com.wuss.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Main106 {
    int[] postorder;
    int[] inorder;
    int postIndex ;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        postIndex= postorder.length-1;
        int len = inorder.length;
        for (int i=0;i<len;i++){
            map.put(inorder[i],i);
        }
        return help(0,len);
    }

    private TreeNode help(int left,int right){
        if (left > right){
            return null;
        }
        int value = postorder[postIndex--];
        TreeNode root = new TreeNode(value);
        int valueIndex = map.get(value);
        root.right=help(valueIndex+1,right);
        root.left = help(left,valueIndex-1);
        return root;
    }




    public static void main(String[] args) {
       int[] inorder={9,3,15,20,7};
       int[] postorder={9,15,7,20,3};
       Main106 main106 = new Main106();
        TreeNode treeNode = main106.buildTree(inorder, postorder);
        System.out.println(treeNode);
    }
}
