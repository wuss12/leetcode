package com.wuss.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 *409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class Main409 {
    public int longestPalindrome(String s) {
        int len = s.length();
        if (len <=1){
            return len;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (char ch:s.toCharArray()){
            Integer orDefault = map.getOrDefault(ch, 0);
            map.put(ch,orDefault+1);
        }
        int maxLen =0;
        int value;
        boolean hasJ = false;
        for (Map.Entry<Character,Integer> entry:map.entrySet()){
            value = entry.getValue();
            if (value %2 == 0){
                maxLen = maxLen + value;
            }else {
                maxLen = maxLen + value -1;
                hasJ = true;
            }
        }
        return hasJ? maxLen+1:maxLen;
    }


    public static void main(String[] args) {
        TestMain.testMethod(Main409.class);
    }
}
