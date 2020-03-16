package com.wuss.face;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * @create: 2020/03/16 09:58
 * 面试题 01.07. 旋转矩阵
 * 给定一幅由N × N矩阵表示的图像，其中每个像素的大小为4字节，编写一种方法，将图像旋转90度。
 *
 * 不占用额外内存空间能否做到？
 *
 *
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class Main07 {
    public static void rotate(int[][] matrix) {
        //先上下对称，在对角线对称
        int len = matrix.length;
        for (int i=0;i< (len+1)/2;i++){
            for (int j=0;j<len;j++){
                swap(matrix,i,j,len-i-1,j);
            }
        }
        for (int i=0;i<len;i++){
            for (int j=0;j<i;j++){
                swap(matrix,i,j,j,i);
            }
        }

    }
    private static void  swap(int[][] matrix,int x1,int y1,int x2,int y2){
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
    private static void show(int[][] matrix){
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        int[][] arr ={{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
        int[][] arr ={{1,2,3},{4,5,6},{7,8,9}};
        show(arr);
        rotate(arr);
        split();
        show(arr);
    }
    private static void split(){
        System.out.println("-----------------------");
    }
}


