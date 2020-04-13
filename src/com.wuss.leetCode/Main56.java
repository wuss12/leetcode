package com.wuss.leetCode;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3},{2,6},{8,10},{15,18]]
 * 输出: [[1,6},{8,10},{15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4},{4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Main56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1){
            return intervals;
        }
        for (int i=0;i<intervals.length;i++){
            for (int j=0;j<intervals.length;j++){
                if (i == j){
                    continue;
                }
                int[][] merge1= merge(intervals[i][0],intervals[i][1],intervals[j][0],intervals[j][1]);
                if (merge1.length ==1){
                    int len = intervals.length;
                    if (i>j){
                        intervals[i] =intervals[len -1];
                        intervals[j] = merge1[0];
                    }else {
                        intervals[j] =intervals[len -1];
                        intervals[i] = merge1[0];
                    }

                    intervals = Arrays.copyOfRange(intervals,0,len-1);
                    i=0;
                }

            }
        }
        return intervals;
    }

    private static int[][] merge(int left1,int right1,int left2,int right2){
        if (right1 < left2 || left1 > right2){
            return new int[][]{{left1,right1},{left2,right2}};
        }
        return new int[][]{{(Math.min(left1,left2)),Math.max(right2,right1)}};
    }

    public static void main(String[] args) {
       Main56 main56 = new Main56();
//        int[][] ints = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] ints = {{1,4},{4,6},{5,15},{15,18}};
//        int[][] ints = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] ints = {{1,4},{4,5}};
        System.out.println(main56.merge(ints));
    }
}
