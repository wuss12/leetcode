package com.wuss.face;

import com.wuss.leetCode.TestMain;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * @create: 2020/03/13 13:56
 * 面试题 01.05. 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，
 * 编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 */
public class Main05 {
    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) >=2){
            return false;
        }

        int notEqulNum = 0;
        int i= 0,j = 0;
        for (;i< len1 && j < len2;){
            if (first.charAt(i) == second.charAt(j)){
                i++;
                j++;
                continue;
            }
            notEqulNum++;
            if (notEqulNum > 1){
                return false;
            }
            if (len1 < len2){
                j++;
                continue;
            }
            if (len1 > len2){
                i++;
                continue;
            }
            if (len1 == len2){
                i++;
                j++;
            }

        }

//        return oneEditAway(first, second,false);
        if (i == len1 && len2 == j){
            return true;
        }
        if (notEqulNum > 0){
            return false;
        }
        return (i == len1 && j+1 == len2) || (i+1 == len1 && j == len2);
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main05.class);
    }


    private boolean oneEditAway(String first, String second,boolean editFlag) {

        int len1 = first.length();
        int len2 = second.length();
        int min = Math.min(len1,len2);
        int max = Math.max(len1,len2);
        if (min == 0 && max ==0){
            return true;
        }
        if (max - min >= 2){
            return false;
        }
        if (editFlag && max != min){
            return false;
        }
        int i=0;
        for (;i< min;i++){
            if (first.charAt(i) != second.charAt(i)){
                break;
            }
        }
        if (i == len1 && i == len2){
            return true;
        }
        if (!editFlag){
           if (len1 < len2){
               return oneEditAway(first.substring(i),second.substring(i+1),true);
           }
           if (len1 > len2){
               return oneEditAway(first.substring(i+1),second.substring(i),true);
           }
           return oneEditAway(first.substring(i+1),second.substring(i+1),true);
        }
        return false;
    }
}
