package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 724. 寻找数组的中心索引
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2：
 *
 * 输入：
 * nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引。
 */
public class Main724 {
//    method one
//
//    int [] leftSum ;
//    int [] rightSum ;
//    public int pivotIndex(int[] nums) {
//        int len = nums.length;
//        leftSum = new int[len];
//        rightSum = new int[len];
//        int right;
//        for (int i=0;i< len;i++){
//            right = len -1 - i;
//            if (i == 0){
//                leftSum[i] = nums[i];
//                rightSum[right] = nums[right];
//            }else {
//                leftSum[i] = nums[i]+ leftSum[i-1];
//                rightSum[right] = nums[right]+ rightSum[right+1];
//            }
//        }
//
//        for (int i=0;i<= len-1;i++){
//            if (i == 0 || i == len -1){
//                if (i ==0 && rightSum[i+1] == 0){
//                    return i;
//                }
//                if (i == len -1 && leftSum[i-1] == 0){
//                    return i;
//                }
//
//            }else {
//                if (leftSum[i-1] == rightSum[i+1]){
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }


    public int pivotIndex(int[] nums) {
        int sum = 0;
        int len = nums.length-1;
        for (int i= len;i>=0 ;i--){
            sum += nums[i];
        }
        int cur = 0;
        for (int i =0;i<=len;i++ ){
            if (cur *2 + nums[i] == sum){
                return i;
            }
            cur  += nums[i];
        }
        return -1;
    }

}
