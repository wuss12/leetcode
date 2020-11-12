package com.wuss.face;

import com.wuss.leetCode.TestMain;

import java.util.Scanner;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * @create: 2020/03/13 10:32
 *
 * 面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 *
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 */
public class Main01 {
    public boolean isUnique(String astr) {
        int arr[] = new int[1024];
        int len = astr.length();
        if (len == 0){
            return true;
        }
        for (int i = 0;i<len;i++){
            arr[astr.charAt(i)] ++;
        }
        for (int i=0;i<1024;i++){
            if (arr[i] > 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main01.class);
    }
}
