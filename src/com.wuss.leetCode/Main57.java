package com.wuss.leetCode;

import java.util.*;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 57. 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Main57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int[][] result ;
        if (newInterval.length ==2){
            result = Arrays.copyOf(intervals,len+1);
            result[len] = new int[]{newInterval[0],newInterval[1]};
        }else {
            result = intervals;
        }
        return merge(result);
    }
    private class Point {
        int x,y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
        public int[] changeToArr(){
            return new int[]{x,y};
        }


    }

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len <= 1){
            return intervals;
        }
        List<Point> list = new ArrayList<>(len);
        for (int i=0;i<len;i++){
            list.add(new Point(intervals[i][0],intervals[i][1]));
        }
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x != o2.x){
                    return o1.x - o2.x;
                }
                return o1.y - o2.y;
            }
        });
        List<Point> pointsList = new ArrayList<>();
        Point pOld = null,pNew;
        for (int i=0;i<len;i++){
            pNew = list.get(i);
            if (pOld == null){
                pOld = pNew;
                pointsList.add(pOld);
                continue;
            }

            if (pNew.x >= pOld.x && pNew.x<= pOld.y && pNew.y >= pOld.y){
                pOld.y = pNew.y;
                continue;
            }
            if (pNew.y <= pOld.y){
                continue;
            }
            pOld = pNew;
            pointsList.add(pOld);

        }
        int[][] arr = new int[pointsList.size()][];
        for (int i=0;i<arr.length;i++){
            arr[i] = pointsList.get(i).changeToArr();
        }

        return arr;
    }
}

