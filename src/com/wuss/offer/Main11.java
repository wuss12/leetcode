package com.wuss.offer;

import com.wuss.leetCode.TestMain;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class Main11 {
    public int minArray(int[] numbers) {
       int l = 0 ;
       int r = numbers.length -1 ;
       int m;
       while (l < r){
           m = (l+r) >> 1;
           if (numbers[m] >= numbers[r]){
               l = m+1;
           }else if (numbers[l] >= numbers[m]){
               r = m;
           }else {
               r--;
           }
       }
       return numbers[r];
    }



    public static void main(String[] args) {
        TestMain.testMethod(Main11.class);
    }
}
