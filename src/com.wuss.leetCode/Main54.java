package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.List;
/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
public class Main54 {
    List<Integer> list = new ArrayList<>();
    int maxSize;
    public List<Integer> spiralOrder(int[][] matrix) {
        int h = matrix.length;
        if(h == 0){
            return list;
        }
        int l = matrix[0].length;
        maxSize = h*l;
        list.clear();
        spiralOrder(matrix,0,h-1,0,l-1);
        return list;
    }
    private  void spiralOrder(int[][] matrix,int minx,int maxx,int miny,int maxy){
        if (list.size() >= maxSize ){
            return;
        }
        if (minx >= maxx && miny == maxy){
            add(matrix[minx][miny]);
            return;
        }

        for (int i=miny;i<=maxy;i++){
            add(matrix[minx][i]);
        }
        for (int i=minx+1;i<=maxx;i++){
            add(matrix[i][maxy]);
        }

        for (int i=maxy-1;i>= miny;i--){
            add(matrix[maxx][i]);
        }
        for (int i=maxx-1;i>=minx+1;i--){
            add(matrix[i][miny]);
        }
        spiralOrder(matrix,minx+1,maxx-1,miny+1,maxy-1);

    }
    private void add(int value){
        if (list.size() >= maxSize){
            return;
        }
        list.add(value);
    }

    public static void main(String[] args) {
        int h= 3,l =4;
        int[][]arr = new int[h][l];
        int num =1;
        for (int i=0;i<h;i++){
            for (int j=0;j<l;j++){
                arr[i][j] = num++;
            }
        }
        Main54 main54 = new Main54();
        System.out.println(main54.spiralOrder(arr));

    }
}

