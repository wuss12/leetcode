package com.wuss.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 1207. 独一无二的出现次数
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */
public class Main1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] results = new int[2001];
        for (int i : arr){
            results[i+1000]++;
        }
        Set<Integer> set = new HashSet<>();
        for (int i: results){
            if (i != 0){
                if (set.contains(i)){
                    return false;
                }
                set.add(i);
            }
        }
        return true;
    }
}
