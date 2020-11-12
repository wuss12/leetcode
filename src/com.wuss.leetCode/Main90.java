package com.wuss.leetCode;

import java.util.*;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Main90 {


public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        backtrack(0, nums, res, new ArrayList<>());
        return res;


    }

    private void backtrack(int idx, int[] nums, List<List<Integer>> res, List<Integer> tmp_list) {
        res.add(new ArrayList<>(tmp_list));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i - 1] == nums[i]) {
                continue;
            }
            tmp_list.add(nums[i]);
            backtrack(i + 1, nums, res, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }



    public static void main(String[] args) {
        TestMain.testMethod(Main90.class);
    }
}
