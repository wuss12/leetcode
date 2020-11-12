package com.wuss.face;

import com.wuss.leetCode.TestMain;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * @create: 2020/03/13 13:24
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 */
public class Main02 {
    public boolean CheckPermutation(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2){
            return false;
        }
        int[] arr1 = new int[1024];
        int[] arr2 = new int[1024];
        for (int i=0;i<len1;i++){
            arr1[s1.charAt(i)]++;
            arr2[s2.charAt(i)]++;
        }
        for (int i=0;i<len1;i++){
            if (arr1[s1.charAt(i)] != arr2[s1.charAt(i)]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main02.class);
    }
}
