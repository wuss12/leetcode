package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class Main63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        if (r == 0 || c == 0 || obstacleGrid[0][0] + obstacleGrid[r-1][c-1] > 0){
            return 0;
        }
        int[][] arr = new int[r][c];
        for (int i=0;i<r;i++){
            if (obstacleGrid[i][0] == 1){
                break;
            }
            arr[i][0] = 1;
        }
        for (int i=0;i<c;i++){
            if (obstacleGrid[0][i] == 1){
                break;
            }
            arr[0][i] =1;
        }
        for (int i=1;i<r;i++){
            for (int j =1;j<c;j++){
                if (obstacleGrid[i][j] == 0){
                    arr[i][j] = arr[i-1][j]+arr[i][j-1];
                }
            }
        }
        return arr[r-1][c-1];

    }

    public static void main(String[] args) {
        int[][] arr ={{0,0},{1,1},{0,0}};
        Main63 main63 = new Main63();
        int value = main63.uniquePathsWithObstacles(arr);
        System.out.println(value);
    }
}
