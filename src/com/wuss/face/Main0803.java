package com.wuss.face;

import com.wuss.leetCode.TestMain;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 面试题 08.03. 魔术索引
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，
 * 在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 *
 * 示例1:
 *
 *  输入：nums = [0, 2, 3, 4, 5]
 *  输出：0
 *  说明: 0下标的元素为0
 * 示例2:
 *
 *  输入：nums = [1, 1, 1]
 *  输出：1
 * 提示:
 *
 * nums长度在[1, 1000000]之间
 */
public class Main0803 {
//    public int findMagicIndex(int[] nums) {
//        int len = nums.length;
//        for (int i=0;i<len;i++){
//            if (i == nums[i]){
//                return i;
//            }
//        }
//        return -1;
//
//    }


    public int findMagicIndex(int[] nums) {
        if (nums[0] >= nums.length) {
            return -1;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right + left) >> 1;
        int leftRes = helper(nums, left, mid - 1);
        if (leftRes != -1) {
            return leftRes;
        }
        if (nums[mid] == mid) {
            return mid;
        }
        return helper(nums, mid + 1, right);
    }



    public static void main(String[] args) {
        TestMain.testMethod(Main0803.class);
    }
}
