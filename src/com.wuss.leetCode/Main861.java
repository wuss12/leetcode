package com.wuss.leetCode;

/**
 * @program leetcode
 * @description: 861. 翻转矩阵后的得分
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * <p>
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * <p>
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * <p>
 * 返回尽可能高的分数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 */
public class Main861 {


    // method one
//        public int matrixScore(int[][] A) {
//
//            int len =A.length;
//            int colum = A[0].length;
//            for (int i=0;i<len;i++){
//                if (A[i][0] == 1){
//                    continue;
//                }
//                for (int j=colum-1;j>=0;j--){
//                    A[i][j] = 1-A[i][j];
//                }
//            }
//
//            for (int i=0;i<colum;i++){
//                int num = 0;
//                for (int j=0;j<len;j++){
//                    if (A[j][i] == 0){
//                        num++;
//                    }
//                }
//                if (num> (len>>1)){
//                    for (int j=0;j<len;j++){
//                        A[j][i] = 1-A[j][i];
//                    }
//                }
//            }
//
//            int sum = 0;
//            StringBuilder sb = new StringBuilder();
//            for (int i=0;i<len;i++){
//                sb.setLength(0);
//                for (int j=0;j<colum;j++){
//                    sb.append(A[i][j]);
//                }
//                sum += Integer.parseInt(sb.toString(),2);
//            }
//            return sum;
//
//
//        }
//    }
//
//

    public int matrixScore(int[][] A) {
        int sum = 0;
        int row = A.length;
        int colum = A[0].length;
        sum += row * (1 << (colum - 1));

        for (int i = 1; i < colum; i++) {
            int num = 0;
            for (int j = 0; j < row; j++) {
                if (A[j][0] == 1) {
                    num += A[j][i];
                } else {
                    num += (1 - A[j][i]);
                }
            }
            sum += Math.max(num, row - num) * (1 << (colum - i - 1));
        }
        return sum;

    }


}
