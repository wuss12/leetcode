package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * @create: 2021/04/25 08:45
 * 897. 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 */
public class Main897 {

    List<Integer> list = new ArrayList();
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }
        searchBST(root);
        TreeNode root1 = new TreeNode();
        TreeNode temp = root1;
        for(int i:list){
            temp.right = new TreeNode(i);
            temp = temp.right;
        }

        return root1.right;
    }

    public void searchBST(TreeNode root) {
        if(root == null){
            return ;
        }
        searchBST(root.left);
        list.add(root.val);
        searchBST(root.right);

    }

}


