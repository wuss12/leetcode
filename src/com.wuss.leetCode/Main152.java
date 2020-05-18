package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组
 */
public class Main152 {
//   f(i) 表示以i结尾的最大乘
    public int maxProduct(int[] nums) {
        int length = nums.length;
        if (length == 0){
            return 0;
        }
        int[] minArr = new int[length];//最大值
        int[] maxArr = new int[length];//最小值
        minArr[0]=nums[0];
        maxArr[0]=nums[0];
        int max = nums[0];
        for (int i=1;i<length;i++){
            minArr[i]=Math.min(minArr[i-1]*nums[i],Math.min(maxArr[i-1]*nums[i],nums[i]));
            maxArr[i]=Math.max(minArr[i-1]*nums[i],Math.max(maxArr[i-1]*nums[i],nums[i]));
            max = Math.max(minArr[i],maxArr[i]);
        }

        return max;
    }



    public static void main(String[] args) {
        Main152 main152 = new Main152();
        int[] arr = {0,2};
        System.out.println(main152.maxProduct(arr));
    }
}
