package com.wuss.leetCode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * @create: 2021/04/22 09:12
 * 139-单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * dp[i] 表示字符串 s 前 i 个字符组成的字符串 s[0..i-1] 是否能被空格拆分成若干个字典中出现的单词
 * dp[i] = dp[j] && check[j,i)
 */
public class Main139 {
    static Map<Integer,Boolean> map;
    static Set<String> set;
    static int len;
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null|| s.length() == 0){
            return true;
        }
        len = s.length();
        map = new HashMap<>(len);
        set = new HashSet<>(wordDict);
        return wordBreak(s,0);
    }

    public static boolean wordBreak(String s,int start){
       if (start == len){
           return true;
       }
       Boolean flag = map.get(start);
       if (flag!=null){
           return flag;
       }

       for (int i=start;i<len;i++){
           if (set.contains(s.substring(start,i+1))){
               if (wordBreak(s,i+1)){
                   map.put(start,true);
                   return true;
               }
           }
       }
       map.put(start,false);
       return false;
    }


    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> list = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        System.out.println(wordBreak(s,list));
    }
}
