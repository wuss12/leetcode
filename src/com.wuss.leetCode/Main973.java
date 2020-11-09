package com.wuss.leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 973. 最接近原点的 K 个点
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 */
public class Main973 {

    //method 1
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]*o1[0]+o1[1]*o1[1] - o2[0]*o2[0]-o2[1]*o2[1];
            }
        });
        return Arrays.copyOfRange(points,0,K);
    }

    //变形快排
    Random rand = new Random();

    public int[][] kClosest1(int[][] points, int K) {
        int n = points.length;
        random_select(points, 0, n - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void random_select(int[][] points, int left, int right, int K) {
        int pivotId = left + rand.nextInt(right - left + 1);
        int[] temp = points[pivotId];
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points, right, pivotId);
        int l = left;
        int r = right;
        while (l < r){
            while (l < r ){
                int value = points[l][0]*points[l][0]+points[l][1]*points[l][1];
                if (value >= pivot){
                    break;
                }
                l++;
            }
            points[r] = points[l];
            while (l<r){
                int value = points[r][0]*points[r][0]+points[r][1]*points[r][1];
                if (value < pivot){
                    break;
                }
                r--;
            }
            points[l] = points[r];
        }
        points[l] = temp;
        if (K < l - left +1){
            random_select(points,left,l-1,K);
        }
        if (K> l -left+1){
            random_select(points,l+1,right,K- l+left -1);
        }

    }



    public void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }



}
