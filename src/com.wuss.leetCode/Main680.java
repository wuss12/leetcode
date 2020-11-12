package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 */
public class Main680 {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length() - 1, false);
    }

    private boolean validPalindrome(String s, int start, int end, boolean userFlag) {
        if (start >= end) {
            return true;
        }
        boolean result;
        if (s.charAt(start) == s.charAt(end)) {
            result = validPalindrome(s, start + 1, end - 1, userFlag);
        } else {
            if (userFlag) {
                return false;
            }
            result = validPalindrome(s, start + 1, end, true) ||
                    validPalindrome(s, start, end - 1, true);
        }
        return result;
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main680.class);
    }


}

