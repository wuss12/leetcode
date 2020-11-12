package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: "aba"
 *
 * 输出: False
 * 示例 3:
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class Main271 {

    public static void main(String[] args) {
        TestMain.testMethod(Main271.class);
    }
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();

        if (len <=1){
            return false;
        }
        char[] arrs = s.toCharArray();
        int i=0;
        char ch1 = s.charAt(i);
        while (true){
            i = s.indexOf(ch1, i+1);
            if (i < 0){
                return false;
            }
            if (repeated(arrs,i)){
                return true;
            }
        }
    }

    private boolean repeated(char[] s,int end){
        int len1 = s.length;
        int len2 = end ;
        if (len1 % len2 != 0){
            return false;
        }

        int start = 0;
        for (int i=end;i<len1;i++){
            if (s[i]!= s[start++]){
                return false;
            }
            if (start >= end){
                start = 0;
            }
        }
        return true;

    }
}
