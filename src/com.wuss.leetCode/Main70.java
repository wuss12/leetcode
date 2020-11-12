package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class Main70 {
    public int climbStairs(int n) {
        if (n ==1 || n ==2){
            return n;
        }
        int sum = 0;
        int a =1,b=2;
        for (int i=3;i<=n;i++){
            sum = a+b;
            a= b;
            b = sum;
        }
        return sum;

    }

    public static void main(String[] args) {
        TestMain.testMethod(Main70.class);
    }
}
