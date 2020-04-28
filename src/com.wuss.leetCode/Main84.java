package com.wuss.leetCode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * . 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 */
public class Main84 {
    private int largestRectangleArea1(int[] heights) {
        int len = heights.length;
        if (len <= 0){
            return 0;
        }
        int max = 0;
        int min =0;
        for (int i=0;i<len;i++){
            min =Integer.MAX_VALUE;
            for (int j=i;j<len;j++){
                min = Math.min(min,heights[j]);
                max = Math.max(max,min * (j - i+1));
            }
        }
        return max;

    }
    //递归遇到有序数组效率极低
//
//    public int largestRectangleArea(int[] heights) {
//        int len = heights.length;
//        if (len <= 0){
//            return 0;
//        }
//
//        return largestRectangleArea2(heights,0,len-1);
//
//    }
//
//    private int largestRectangleArea2(int[] heights,int left,int right) {
//        if (left >= right){
//            return 0;
//        }
//        if (left == right-1){
//            return Math.min(heights[left],heights[right])<<1;
//        }
//        int minIndex = left;
//        int minValue = heights[left];
//        for (int i= right;i>left;i--){
//            if (minValue > heights[i]){
//                minIndex = i;
//                minValue = heights[i];
//            }
//        }
//        int max = minValue * (right - left+1);
//        int maxL = largestRectangleArea2(heights,left,minIndex -1);
//        int maxR = largestRectangleArea2(heights,minIndex+1,right);
//
//        return Math.max(Math.max(max,maxL),maxR);
//
//    }







    public static void main(String[] args) {
        TestMain.testMethod(Main84.class);
    }
}
