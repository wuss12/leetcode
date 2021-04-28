package com.wuss.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * @create: 2021/04/28 08:52
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 *
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 *
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 *
 * 输入：c = 1
 * 输出：true
 *
 *
 * 提示：
 *
 * 0 <= c <= 231 - 1
 */
public class Main633 {
    // 暴力计算
//    public boolean judgeSquareSum(int c) {
//        int half = (int)(Math.sqrt(c))+1;
//        Set<Long> set = new HashSet<>(half);
//
//        for (int i=0;i<= half ;i++){
//            set.add((long)(i*i));
//        }
//
//        for (long ite : set) {
//            if (set.contains(c - ite)){
//                System.out.println(ite+"\t"+ (c-ite)) ;
//                return true;
//            }
//        }
//        return false;
//    }
    // 双指针 避免溢出

    public boolean judgeSquareSum(int c) {
       int right = (int) Math.sqrt(c);
       int left = 0;
       int sum = 0;
       while (left<= right){
           sum = right*right - c +left*left;
           if (sum == 0){
               System.out.println(left+"\t"+right);
               return true;
           }
           if (sum < 0){
               left++;
               continue;
           }
           right--;
       }
       return false;
    }


    public static void main(String[] args) {
        Main633 main = new Main633();

        int i = 2147482642;
        // 2147482642
        // 26539  37989
        System.out.println(main.judgeSquareSum(i));

//        System.out.println(704318521+1443164121);

//        System.out.println(Math.sqrt(704318521));
//        System.out.println(Math.sqrt(1443164121));




    }
}
