package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class Main209 {
    public int minSubArrayLen1(int s, int[] nums) {
        Integer min = null;

        for (int i = nums.length-1;i>=0;i--){
            int j=i;
            int sum = 0;
            while (j>=0){
                sum = nums[j]+sum;
                j--;
                if (sum >= s){
                    if (min == null){
                        min = i-j;
                    }else {
                        min = Math.min(min,i-j);
                    }
                    break;
                }
                if (min != null && i-j >= min){
                    break;
                }
            }
        }
        return min == null? 0 : min;

    }

    //双指针
    public int minSubArrayLen(int s, int[] nums) {
       int min = Integer.MAX_VALUE;
       int left = 0,right = 0;
       int sum = 0;//sum 存储 从left+right的值
        int len = nums.length;
        while (right < len){
            sum += nums[right];
            right ++;
            while (sum >= s){
                min = Math.min(min,right - left);
                sum -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE? 0 : min;

    }

    public static void main(String[] args) {
        Main209 main209 = new Main209();
        int[] arr = {2,3,1,2,4,3};
        System.out.println(main209.minSubArrayLen(17,arr));
    }
}
