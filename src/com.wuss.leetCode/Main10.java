package com.wuss.leetCode;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Main10 {

    public boolean isMatch(String text, String pattern) {
       int lenText = text.length();
       int lenPattern = pattern.length();
       boolean dp[][] = new boolean[lenText+1][lenPattern+1];
       dp[lenText][lenPattern] = true;
       boolean lastMatch = false;
       for (int i=lenText;i>=0;i--){
           for (int j=lenPattern-1;j>=0;j--){
               lastMatch = i < lenText && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
               if(j+1 < lenPattern && pattern.charAt(j+1) == '*'){
                   dp[i][j] = dp[i][j+2]||lastMatch && dp[i+1][j];
               }else {
                   dp[i][j] = lastMatch && dp[i+1][j+1];
               }
           }
       }
       return dp[0][0];
    }


    public static void main(String[] args) {
       TestMain.testMethod(Main10.class);
    }






}
