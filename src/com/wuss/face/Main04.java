package com.wuss.face;

import com.wuss.leetCode.TestMain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * @create: 2020/03/13 13:41
 * 面试题 01.04. 回文排列
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 */
public class Main04 {
    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>(chars.length);
        for (char ch : chars){
            if (set.contains(ch)){
                set.remove(ch);
                continue;
            }
            set.add(ch);
        }
        return set.size() <= 1;
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main04.class);
    }
}
