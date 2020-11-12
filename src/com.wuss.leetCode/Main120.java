package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 *
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class Main120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len < 1){
            return 0;
        }
        int [] arrs = new int[len];
        arrs[0] = triangle.get(0).get(0);
        int prev =0,current;
        for (int i=1;i<len;i++){
            List<Integer> list = triangle.get(i);
            for (int j = 0;j<=i;j++){
                current = arrs[j];
                if (j == 0){
                    arrs[j] = arrs[j]+list.get(j);

                }else if (j == i){
                    arrs[j] = prev + list.get(j);
                }else {
                    arrs[j] = Math.min(current, prev) + list.get(j);
                }
                prev = current;
            }
        }
        int min = arrs[0];
        for (int i : arrs){
            min = Math.min(min,i);
        }
        return min;

    }


    public int minimumTotal1(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len < 1){
            return 0;
        }
        Integer [][] arrs = new Integer[len][len];
        for (int i=0;i<len;i++){
            List<Integer> list = triangle.get(i);
            int len1 = list.size();
            for (int j = 0;j<len1;j++){
                if (i == 0){
                    arrs[i][j] = list.get(j);
                    continue;
                }
                if (j ==0){
                    arrs[i][j] = arrs[i-1][j]+list.get(j);
                    continue;
                }
                if (arrs[i-1][j] == null){
                    arrs[i-1][j] = arrs[i-1][j-1];
                }
                arrs[i][j] = Math.min(arrs[i-1][j],arrs[i-1][j-1])+list.get(j);

            }
        }
        int min = arrs[len-1][0];
        for (int i : arrs[len-1]){
            min = Math.min(min,i);
        }
        return min;

    }

    public static void main(String[] args) {

        //[[1],[-5,-2],[3,6,1],[-1,2,4,-3]]
        Main120 main120 = new Main120();
        List<List<Integer>> list = getLists();
        System.out.println(main120.minimumTotal(list));
    }

    private static List<List<Integer>> getLists() {
        List<List<Integer>> list = new ArrayList();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));
        return list;
    }
    private static List<List<Integer>> getLists1() {
        List<List<Integer>> list = new ArrayList();
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(-5,-2));
        list.add(Arrays.asList(3,6,1));
        list.add(Arrays.asList(-1,2,4,-3));
        return list;
    }
}

