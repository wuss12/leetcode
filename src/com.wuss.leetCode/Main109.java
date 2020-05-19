package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class Main109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        Integer[] integers = list.toArray(new Integer[0]);
        return sortedListToBST(integers,0,integers.length-1);
    }

    public TreeNode sortedListToBST(Integer[] nums,int left,int right){
        if (left == right){
            return new TreeNode(nums[left]);
        }
        int half = (left+right)>>1;
        TreeNode root = new TreeNode(nums[half]);
        if (left!=half){
            root.left = sortedListToBST(nums,left,half-1);
        }
        root.right = sortedListToBST(nums,half+1,right);
        return root;
    }


}
