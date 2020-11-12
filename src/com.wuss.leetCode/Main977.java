package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */
public class Main977 {

    public int[] sortedSquares(int[] A) {
        int l = 0,r = A.length-1;
        int pos = r;
        int ml,mr;
        int[] arrs = new int[A.length];
        while ( l<= r){
            ml = A[l]*A[l];
            mr = A[r]*A[r];
            if (ml >= mr){
                arrs[pos] = ml;
                l++;
            }else {
                arrs[pos] = mr;
                r--;
            }
            pos--;
        }
        return arrs;

    }
}