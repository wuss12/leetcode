package com.wuss.leetCode;

import java.util.*;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 87. 扰乱字符串
 * 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 * <p>
 * 下图是字符串 s1 = "great" 的一种可能的表示形式。
 * <p>
 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t
 * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 * <p>
 * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
 * <p>
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
 * <p>
 * 同样地，如果我们继续交换节点 "eat" 和 "at" 的子节点，将会产生另一个新的扰乱字符串 "rgtae" 。
 * <p>
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a
 * 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
 * <p>
 * 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "great", s2 = "rgeat"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s1 = "abcde", s2 = "caebd"
 * 输出: false
 */
public class Main87 {

    public boolean isScramble(String s1, String s2) {
        System.out.println(s1+"\t"+s2);
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        if (s1.equals(s2)){
            return true;
        }
        Map<Character, Integer> map = new HashMap<>(len1);
        char ch;
        for (int i = 0; i < len1; i++) {
            ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int value;
        for (int i = 0; i < len1; i++) {
            ch = s2.charAt(i);
            value = map.getOrDefault(ch, 0);
            if (value == 0) {
                return false;
            }
            map.put(ch, value - 1);
        }

        boolean pass = false;
        for (int i=1;i<len1;i++){
            pass = isScramble(s1.substring(0,i),s2.substring(0,i))&& isScramble(s1.substring(i),s2.substring(i))
                    || isScramble(s1.substring(0,i),s2.substring(s1.length()-i))&& isScramble(s1.substring(i),s2.substring(0,len1-i));
            if (pass){
                return true;
            }
        }
        return false;
    }





    public static void main(String[] args) {
        TestMain.testMethod(Main87.class);
    }


}
