package com.wuss.leetCode;


/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class Main72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if ((len1 | len2) == 0){
            return len1+len2;
        }
        int[][] arr = new int[len1+1][len2+1];
        for (int i=0;i<= len1;i++){
            arr[i][0] = i;
        }
        for (int j=0;j<= len2;j++){
            arr[0][j] = j;
        }
        int left,up,leftUp;
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        for (int i=1;i<= len1;i++){
            for (int j=1;j<= len2;j++){
                 left = arr[i-1][j]+1;
                 up = arr[i][j-1]+1;
                 leftUp = arr[i-1][j-1];
                if (arr1[i-1]!= arr2[j-1]){
                    leftUp++;
                }
                arr[i][j] = Math.min(Math.min(left,up),leftUp);
            }
        }
        return arr[len1][len2];


    }



    public static void main(String[] args) {
        TestMain.testMethod(Main72.class);
    }
}
