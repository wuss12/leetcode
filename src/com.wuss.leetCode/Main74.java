package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class Main74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        if (len == 0){
            return false;
        }
        int i = 0;
        for (;i<len-1;i++){
            if (matrix[i+1][0]> target ){
                break;
            }
        }
        int row = matrix[0].length;
        if (row == 0){
            return false;
        }
        if (target > matrix[i][row-1]|| target < matrix[i][0]){
            return false;
        }
        for (int k=0;k< row;k++){
            if (matrix[i][k] == target){
                return true;
            }
            if (target < matrix[i][k]){
                return false;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Main74 main74 = new Main74();
        int[][] matrix = new int[][]{{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        System.out.println(main74.searchMatrix(matrix,3));
        System.out.println(main74.searchMatrix(matrix,13));
    }
}
