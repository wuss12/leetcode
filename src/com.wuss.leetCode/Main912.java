package com.wuss.leetCode;

import java.util.Arrays;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 */
public class Main912 {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return nums;
        }
        Arrays.sort(nums);
        return nums;
    }
}
