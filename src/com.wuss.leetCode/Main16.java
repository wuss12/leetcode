package com.wuss.leetCode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Main16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0,tempSum = 0;
        int minCha = Integer.MAX_VALUE,tempCha;
        int len = nums.length;
        if(len <= 3){
            for (int i=0;i<len;i++){
                sum+= nums[i];
            }
            return sum;
        }
        int left,right;
        for (int i=0;i<len;i++){
            left = i+1;
            right = len -1;
            while (left < right){
                tempSum = nums[i]+nums[left]+nums[right];
                if(tempSum == target){
                    return target;
                }
                if(tempSum > target){
                    tempCha =   tempSum - target;
                    if(tempCha < minCha){
                        minCha = tempCha;
                        sum = tempSum;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    right --;
                }else {
                    tempCha = target - tempSum;
                    if(tempCha < minCha){
                        minCha = tempCha;
                        sum = tempSum;
                    }
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    left++;

                }
            }

        }
        return sum;


    }

    public static void main(String[] args) {
        TestMain.testMethod(Main16.class);
    }

}
