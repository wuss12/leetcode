package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class Main59 {
    int[][] arr;
    int start;
    public int[][] generateMatrix(int n) {
        arr = new int[n][n];
        start = 0;
        return generateMatrix(0,n-1,0,n-1);
    }
    private int[][] generateMatrix (int left,int right,int top,int bottom){
        if (left > right || top > bottom){
            return arr;
        }
        for (int i = left;i<= right;i++){
            arr[left][i] = ++start;
        }
        for (int i = top+1;i< bottom;i++){
            arr[i][right] = ++start;
        }
        for (int i= right;i> left;i--){
            arr[bottom][i] = ++start;
        }
        for (int i= bottom;i>top;i--){
            arr[i][left] = ++start;
        }


        return  generateMatrix(left+1,right-1,top+1,bottom-1);

    }

    public static void main(String[] args) {
        Main59 main59 = new Main59();
        int n = 3;
        int[][] arr = main59.generateMatrix(n);
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
