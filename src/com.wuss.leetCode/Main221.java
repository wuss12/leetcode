package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 221. 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */
public class Main221 {
    //method1
//    int c,r;
//    public int maximalSquare(char[][] matrix) {
//        int max = 0;
//        r = matrix.length;
//        if (r < 1){
//            return 0;
//        }
//        c = matrix[0].length;
//        if (c < 1){
//            return 0;
//        }
//        boolean hasOne = false;
//        for (int i=0;i<r;i++){
//            for (int j=0;j<c;j++){
//                if (matrix[i][j] == '1'){
//                    hasOne = true;
//                    while (isSquare(matrix,i,j,max+1)){
//                        max = max+1;
//                    }
//                }
//            }
//        }
//
//        return hasOne? (max+1)*(max+1):0;
//
//    }
//
//    private boolean isSquare(char[][] matrix,int x,int y,int len){
//        if (x+len>= r || y+len >= c){
//            return false;
//        }
//        for (int i=x+len;i>=x;i--){
//            for (int j=y+len;j>=y;j--){
//                if (matrix[i][j] != '1'){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    //method2
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }


    public static void main(String[] args) {
        char[][] ma = new char[][]{
                {'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}
        };

        Main221 main221 = new Main221();
        System.out.println(main221.maximalSquare(ma));
    }

}