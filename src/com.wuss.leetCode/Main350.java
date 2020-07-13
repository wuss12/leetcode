package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Main350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int num1: nums1){
            Integer value = map.getOrDefault(num1,0);
            map.put(num1,value+1);
        }
        for (int num2 : nums2){
            int value = map.getOrDefault(num2,0);
            if (value == 0){
                continue;
            }
            list.add(num2);
            map.put(num2,value-1);
        }
        int[] arr = new int[list.size()];
        for (int i=arr.length-1;i>=0;i--){
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main350.class);
    }
}
