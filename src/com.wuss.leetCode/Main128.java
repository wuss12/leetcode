package com.wuss.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 128. 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Main128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>(nums.length);
        for (int i: nums){
            hashSet.add(i);
        }
        int logest = 0;
        for (int i: nums){
            int currentNum ;
            int len ;
            if (!hashSet.contains(i-1)){
                currentNum = i;
                len = 1;
                while (hashSet.contains(++currentNum)){
                    len++;
                }
                logest = Math.max(logest,len);
            }
        }
        return logest;
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main128.class);
    }
}
