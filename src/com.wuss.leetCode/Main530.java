package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 */
public class Main530 {
    int min = Integer.MAX_VALUE;
    Integer pre = null;


    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }
        getMinimumDifference(root.left);
        if (pre == null) {
            pre = root.val;
        } else {
            min = Math.min(min, root.val - pre);
            pre = root.val;

        }
        getMinimumDifference(root.right);
        return min;
    }
}
