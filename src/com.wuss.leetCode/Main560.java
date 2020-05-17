package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class Main560 {
//    public int subarraySum(int[] nums, int k) {
//        int len = nums.length;
//        if (len == 0){
//            return 0;
//        }
//        int num = 0;
//        for (int i=0;i<len;i++){
//            int sum = 0;
//            for (int j=i;j<len;j++){
//                sum = sum+nums[j];
//                if (sum == k){
//                    num++;
//                }
//            }
//        }
//        return num;
//
//    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Integer[] preSum = new Integer[nums.length];
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            if (start>0){
                preSum[start] = preSum[start-1]+nums[start];
            }

            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
            preSum[start] = sum;
        }
        return count;
    }



    public static void main(String[] args) {
        TestMain.testMethod(Main560.class);
    }
}
