package com.wuss.leetCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 1248. 统计「优美子数组」
 * 给你一个整数数组 nums 和一个整数 k。
 * <p>
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * <p>
 * 请返回这个数组中「优美子数组」的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 * <p>
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 */
public class Main1248 {
    /**
     * (双指针)
     *     双指针扫描 r 在前，l 在后。
     *     如果当前位置是奇数，则更新计数器，如果当前 [l, r] 有了恰好 k 个奇数，则移动 l 直到不满足，期间统计出长度为 tot。
     *     让 ans 累加 tot。
     *     如果当前位置是偶数，则说明贡献的答案和上一次是奇数的时候一样，直接让 ans 累加上一次的 tot。
     *
     *     时间复杂度
     *     每个位置最多遍历两次，故时间复杂度为 O(n)
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return 0;
        // 双指针
        int left = 0, right = 0;
        int count = 0; // 连续子数组中奇数的个数
        int res = 0;
        int preEven = 0; // 记录第一个奇数前面的偶数个数
        while (right < nums.length){
            // 连续子数组中奇数个数不够
            if (count < k){
                if (nums[right] % 2 != 0) count++;
                right++; // 移动右侧指针
            }
            // 连续子数组中奇数个数够了，看第一个奇数前面有多少个偶数
            if (count == k) {
                preEven = 0;
                while (count == k){
                    res++;
                    if (nums[left] % 2 != 0) count--;
                    left++;
                    preEven++;
                }
            } else res += preEven; // 每次遇到 right 为偶数的时候就进行累加 相当于区间前面偶数个数 * 后面偶数个数
        }
        return res;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        if (len ==0|| k==0|| k > len){
            return 0;
        }
        int left = 0,right = 0;
        int sum = 0,preCount = 0;
        int count = 0;//连续子数组中奇数的个数
        while (right < len){
            if (count < k){
                if ((nums[right] & 1) == 1){
                    count++;
                }
                right++;
            }
            if (count == k){
                preCount = 0;
                while (count == k){
                    sum++;
                    preCount++;
                    if ((nums[left] & 1) == 1){
                        count--;
                    }
                    left++;
                }
            }else {
                sum = sum + preCount;
            }
        }
        return sum;
    }



    public static void main(String[] args) {
        /**
         * 输入形式：
         * 1,1,2,1,1
         * 3
         */
        TestMain.testMethod(Main1248.class);
    }
}
