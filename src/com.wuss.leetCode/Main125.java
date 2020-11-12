package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class Main125 {
    char[] chars;
    char ch;
    int len ;
    public boolean isPalindrome(String s) {
        s = s.toUpperCase();
        len = s.length()-1;
        chars = s.toCharArray();
        int start =0;
        int end = s.length()-1;
        char chl,chr;
        while (start < end){
            while (start<len && !isValue(start)){
                start++;
            }
            chl = chars[start];

            while (end > 0 && !isValue(end)){
                end --;
            }
            chr = chars[end];
            if (start > end){
                return true;
            }
            start++;
            end --;

            if (chl != chr){
                return false;
            }

        }
        return true;


    }

    private boolean isValue(int i){
         ch = chars[i];
         if (ch >='0'&&ch <='9'){
             return true;
         }
         if (ch>='A' && ch <='Z'){
             return true;
         }
         return false;
    }

    public static void main(String[] args) {
        Main125 main125 = new Main125();
//        String str ="A man, a plan, a canal: Panama";
//        String str ="race a car";
//        String str ="a.";
//        String str ="ab";
        String str =".,";
        System.out.println(main125.isPalindrome(str));
    }

}
