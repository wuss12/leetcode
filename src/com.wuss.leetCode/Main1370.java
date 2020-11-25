package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * 1370. 上升下降字符串
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 *
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * 示例 2：
 *
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 * 示例 3：
 *
 * 输入：s = "leetcode"
 * 输出："cdelotee"
 * 示例 4：
 *
 * 输入：s = "ggggggg"
 * 输出："ggggggg"
 * 示例 5：
 *
 * 输入：s = "spo"
 * 输出："ops"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 */
public class Main1370 {

//    public String sortString(String s) {
//        StringBuilder sb = new StringBuilder();
//        char[] chars = s.toCharArray();
//        Arrays.sort(chars);
//        List list = new LinkedList();
//        for (char ch:chars){
//            list.add(ch);
//        }
//        while (!list.isEmpty()){
//            dealStr(list,sb,true);
//            dealStr(list,sb,false);
//        }
//        return sb.toString();
//    }
//
//    public void dealStr(List<Character> list,StringBuilder sb,boolean desc){
//        Character ch = null;
//        List<Integer> needRemove = new ArrayList<>();
//        int start,step,limit;
//        if (desc){
//            start = 0;
//            step = 1;
//            limit = list.size()-1;
//        }else {
//            start = list.size()-1;
//            step = -1;
//            limit = 0;
//        }
//        for (int i=start;desc?i<= limit: i>= limit;i = i+ step){
//            if (ch == null){
//                ch = list.get(i);
//                sb.append(ch);
//                needRemove.add(i);
//                continue;
//            }
//            if (ch == list.get(i)){
//                continue;
//            }
//            ch = list.get(i);
//            sb.append(ch);
//            needRemove.add(i);
//
//        }
//
//        Collections.sort(needRemove);
//        for (int i= needRemove.size()-1;i>=0;i--){
//            list.remove(needRemove.get(i).intValue());
//        }
//    }

    public String sortString(String s) {
        int[] arrs = new int[26];
        for (char ch:s.toCharArray()){
            arrs[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder(s.length());
        while (sb.length() < s.length()){
            //增加
            for (int i=0;i< 26;i++){
                if (arrs[i] == 0){
                    continue;
                }
                sb.append((char) (i+'a'));
                arrs[i]--;

            }
            //减少
            for (int i=25;i>=0;i--){
                if (arrs[i] == 0){
                    continue;
                }
                sb.append((char) (i+'a'));
                arrs[i]--;
            }
        }
        return sb.toString();
    }
}
