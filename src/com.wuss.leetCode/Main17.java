package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * 2->abc,3->def,4->ghi,5->jkl,6->mn0,7->pqrs,8->tuv,9->wxyz
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Main17 {
    static String[] letterArr = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        return getCom(digits,new ArrayList<>());
    }
    private static List<String> getCom(String digits,List<String> results){
        int len = digits.length();
        if(len == 0){
            return results;
        }
        String nowStr = letterArr[digits.charAt(0)-'2'];
        char[] nowChars = nowStr.toCharArray();
        int listSize =results.size() == 0? 1:results.size();
        List<String> tempResult = new ArrayList<>(listSize*nowStr.length());
        StringBuilder sb = new StringBuilder();
        int leLen = nowStr.length();
        if(results.size() > 0){
            for (String str : results){
                for (int i=0;i<leLen;i++){
                    sb.setLength(0);
                    sb.append(str);
                    sb.append(nowChars[i]);
                    tempResult.add(sb.toString());
                }
            }
        }else {
            for (int i=0;i<leLen;i++){
                sb.setLength(0);
                sb.append(nowChars[i]);
                tempResult.add(sb.toString());
            }
        }

        return getCom(digits.substring(1),tempResult);
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main17.class);
    }
}
