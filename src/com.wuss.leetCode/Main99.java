package com.wuss.leetCode;

import java.util.*;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 99. 恢复二叉搜索树
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 *
 * 输入: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * 进阶:
 *
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 */
public class Main99 {
//    public void recoverTree(TreeNode root) {
//       List<Integer> list = new ArrayList<>();
//       search(root,list);
//       int[] twoSwapped = findTwoSwapped(list);
//       if (twoSwapped[0] == twoSwapped[1]){
//           return;
//       }
//        recover(root,2,twoSwapped[0],twoSwapped[1]);
//    }
//
//    private void search(TreeNode root,List<Integer> list){
//        if (root == null){
//            return;
//        }
//        search(root.left,list);
//        list.add(root.val);
//        search(root.right,list);
//    }
//
//    private  int[] findTwoSwapped(List<Integer> nums) {
//        int n = nums.size();
//        int x = -1, y = -1;
//        for(int i = 0; i < n - 1; ++i) {
//            if (nums.get(i + 1) < nums.get(i)) {
//                y = nums.get(i + 1);
//                // first swap occurence
//                if (x == -1) x = nums.get(i);
//                    // second swap occurence
//                else break;
//            }
//        }
//        return new int[]{x, y};
//    }
//    public void recover(TreeNode r, int count, int x, int y) {
//        if (r != null) {
//            if (r.val == x || r.val == y) {
//                r.val = r.val == x ? y : x;
//                if (--count == 0) {
//                    return;
//                }
//            }
//            recover(r.left, count, x, y);
//            recover(r.right, count, x, y);
//        }
//    }


    // method2
    public void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque();
        TreeNode x = null, y = null, pred = null,temp = root;

        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                stack.add(temp);
                temp = temp.left;
            }
            temp = stack.removeLast();
            if (pred != null && temp.val < pred.val) {
                y = temp;
                if (x == null) x = pred;
                else break;
            }
            pred = temp;
            temp = temp.right;
        }

        swap(x, y);
    }






}
