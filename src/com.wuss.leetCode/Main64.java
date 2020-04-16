package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class Main64 {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        if (r == 0){
            return 0;
        }
        int c = grid[0].length;
        if (c == 0){
            return 0;
        }
        int[][] arr = new int[r][c];
        arr[0][0] = grid[0][0];
        int left,top;
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                if (i == 0 && j == 0){
                    continue;
                }
                if (i > 0){
                    left = arr[i-1][j];
                }else {
                    left = Integer.MAX_VALUE;
                }
                if (j>0){
                    top = arr[i][j-1];
                }else {
                    top = Integer.MAX_VALUE;
                }
                arr[i][j] = grid[i][j]+Math.min(left,top);
            }
        }
        return arr[r-1][c-1];
    }

    public static void main(String[] args) {
        Main64 main64 = new Main64();
        int[][] arr ={{1,3,1},{1,5,1},{4,2,1}};
        int value = main64.minPathSum(arr);
        System.out.println(value);
    }
}
