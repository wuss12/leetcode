package com.wuss.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class Main76 {
    public String minWindow(String s, String t) {

        int lenS = s.length();
        int lenT = t.length();
        if (lenS == 0 || lenT == 0) {
            return "";
        }
        Map<Character, Integer> mapT = new HashMap<>();
        char[] charsT = t.toCharArray();
        char[] charsS = s.toCharArray();
        for (char ch : charsT) {
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }
        int forms = 0;
        Map<Character, Integer> mapS = new HashMap<>();
        int l = 0, r = 0;
        Integer value;
        Character ch;
        int[] ans = {-1, 0, 0};
        while (r < lenS) {
            ch = charsS[r];
            if (!mapT.containsKey(ch)) {
                r++;
                continue;
            }
            value = mapS.getOrDefault(ch, 0) + 1;
            mapS.put(ch, value);
            if (value.intValue() == mapT.get(ch)) {
                forms++;
            }
            while (l <= r && forms == mapT.size()) {
                ch = charsS[l];

                if (ans[0] == -1 || r - l+1 < ans[0]) {
                    ans[0] = r - l+1;
                    ans[1] = l ;
                    ans[2] = r;
                }
                l++;
                if (!mapT.containsKey(ch)) {

                    continue;
                }

                mapS.put(ch, mapS.getOrDefault(ch, 0) - 1);
                if (mapS.get(ch) < mapT.get(ch).intValue()){
                    forms--;
                }


            }
            r++;

        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }


    public static void main(String[] args) {
        TestMain.testMethod(Main76.class);
    }
}
