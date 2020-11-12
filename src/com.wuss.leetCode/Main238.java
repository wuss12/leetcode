package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 *238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class Main238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len <=1){
            return nums;
        }
        int[] chengLArr = new int[len];
        int[] chengRArr = new int[len];
        int ji =1;
        for (int i=0;i<len;i++){
            ji = ji*nums[i];
            chengLArr[i] = ji;
        }
        ji =1;
        for (int i=0,j=len-1;i<len;i++){
            ji = ji*nums[j];
            chengRArr[j--] = ji;
        }
        int[] resultArr = new int[len];
        resultArr[0]=chengRArr[1];
        for (int i=1;i<len;i++){
            if (i == len-1){
                resultArr[i] = chengLArr[i-1];
                continue;
            }
            resultArr[i] = chengLArr[i-1]*chengRArr[i+1];
        }
        return resultArr;
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main238.class);
    }
}
