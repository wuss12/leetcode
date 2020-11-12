package com.wuss.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 *
 *
 * 示例：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Main202 {
//    Set<Integer> set = new HashSet<>();
//    public boolean isHappy(int n) {
//        set.clear();
//       return isHappy(n,set);
//
//    }
//
//    public boolean isHappy(int n,Set<Integer> set){
//        if (set.contains(n)){
//            return false;
//        }
//        set.add(n);
//
//        if (n == 0){
//            return false;
//        }
//        if (n == 1){
//            return true;
//        }
//        int sum = 0;
//        int mod = 0;
//        while (n >0){
//            mod = n%10;
//            sum+= mod * mod;
//            n = n/10;
//        }
//
//        if (sum == 1){
//            return true;
//        }
//
//        return isHappy(sum,set);
//    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main202.class);
    }
}
