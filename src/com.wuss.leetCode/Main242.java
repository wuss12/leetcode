package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @create: 2020/11/23 18:24
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class Main242 {
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        if (len != t.length()){
            return false;
        }
        int[] arrs = new int['z'+1];
        for (int i = 0;i<len;i++){
            arrs[s.charAt(i)]++;
            arrs[t.charAt(i)]--;
        }
        for (int i= arrs.length -1;i>='a';i--){
            if (arrs[i]!=0){
                return false;
            }
        }
        return true;
    }
}
