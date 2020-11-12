package com.wuss.face;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 *   01.08. 零矩阵
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 */
public class Main08 {
    public void setZeroes(int[][] matrix) {
        //行
        int len = matrix.length;
        if (len <= 0){
            return;
        }
        //列
        int hight = matrix[0].length;
        int[][] zero = new int[len][hight];
        for (int i=0;i<len;i++){
            for (int j=0;j<hight;j++){
                if (matrix[i][j] == 0){
                    zero[i][j] = 1;
                }
            }
        }
        for (int i=0;i<len;i++){
            for (int j=0;j<hight;j++){
                if (zero[i][j] == 1){
                    for (int k=0;k<hight;k++){
                        matrix[i][k] = 0;
                    }
                    for (int k = 0;k<len;k++){
                        matrix[k][j] = 0;
                    }
                }
            }
        }

    }
}
