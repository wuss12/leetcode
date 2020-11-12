package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class Main96 {
    Integer[] arr ;
    public int numTrees(int n) {
        arr = new Integer[n];
        return numTrees(1,n);
    }

    private int numTrees(int start,int end){
        int all = 0;
        if (start > end){
            return 1;
        }
        if (start == end){
            return 1;
        }
        if (arr[end-start] != null){
            return arr[end-start];
        }
        for (int i=start;i<=end;i++){
            int left = numTrees(start,i-1);
            int right = numTrees(i+1,end);
            all = all + left * right;
        }
        arr[end-start] = all;
        return all;
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main96.class);
    }
}
