package com.wuss.leetCode;


import java.util.*;

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
    class Point {
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

    public int[][] merge1(int[][] intervals) {
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
        int[][] ints = {{1,4},{2,3}};
        int[][] merge = main56.merge(ints);
        for (int i=0;i<merge.length;i++){
            System.out.print("["+merge[i][0]+","+merge[i][1]+"],");
        }
        System.out.println();
    }
}
