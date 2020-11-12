package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例 1:
 *
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 说明:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * 通过次数16,194提交次数31,400
 */
public class Main718 {
//    public int findLength(int[] A, int[] B) {
//        int lenA = A.length;
//        int lenB = B.length;
//        int[][] arr = new int[lenA][lenB];
////        arr[i][j] =  (i !=j)
//        int max = 0;
//        for (int i=0;i<lenA;i++){
//            for (int j=0;j<lenB;j++){
//                if (A[i] != B[j]){
//                    arr[i][j] = 0;
//                    continue;
//                }
//                if (i ==0 || j ==0){
//                    max = Math.max(max,1);
//                    arr[i][j] =1;
//                    continue;
//                }
//                arr[i][j] = arr[i-1][j-1]+1;
//                max = Math.max(max,arr[i][j]);
//            }
//        }
//        return max;
//    }

    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxlen = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxlen);
        }
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxlen = maxLength(A, B, 0, i, len);
            ret = Math.max(ret, maxlen);
        }
        return ret;
    }

    private int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }




    public static void main(String[] args) {
        TestMain.testMethod(Main718.class);
    }
}
