package com.wuss.leetCode;

import java.util.Arrays;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 378. 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 */
public class Main378 {

    public int kthSmallest(int[][] matrix, int k) {
        int r = matrix.length;
        int[] arr = Arrays.copyOf(matrix[0],r*r);
        for (int i=1;i<r;i++){
            merge(arr,i*r-1,matrix[i]);
        }
        return arr[k-1];

    }

    private void merge(int[] arr,int arrIndex,int [] arr1){
     int l1= arr1.length;
     for (int i=0;i<l1;i++){
         int j= arrIndex;
         while (arr[j]> arr1[i]){
             arr[j+1] = arr[j];
             j--;
         }
         arr[j+1] = arr1[i];
         arrIndex++;
     }

    }

    public static void main(String[] args) {
        Main378 main378 = new Main378();
        int[][] arrs ={{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(main378.kthSmallest(arrs,8));
    }
}


