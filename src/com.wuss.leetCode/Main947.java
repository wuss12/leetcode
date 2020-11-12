package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 941. 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
public class Main947 {
    public boolean validMountainArray(int[] A) {
        int len = A.length;
        if (len <3){
            return false;
        }
        int i=1;
        while (i<len && A[i]>A[i-1]){
            i++;
        }
        if (i == len || i == 1){
            return false;
        }
        while (i<len && A[i]<A[i-1]){
            i++;
        }
        return i==len;
    }

}
