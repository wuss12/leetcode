package com.wuss.leetCode;

/**
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Main3 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0){
            return 0;
        }
        int[] arr = new int[len];
        arr[0] =1;
        int maxLen = 1;
        int j=0;
        int tempLen = 0;
        char ch;
        for (int i=0;i<len;i++){
            if(i > 0){
                tempLen = arr[i -1];
                ch = s.charAt(i);
                j =1;
                while (j <= tempLen){
                    if(ch != s.charAt(i -j)){
                        j++;
                        continue;
                    }
                    break;
                }
                arr[i] = j;
                if(maxLen < j){
                    maxLen = j;
                }

            }
        }
        return maxLen;

    }

    public static void main(String[] args) {
        Main3 main3 = new Main3();
        String str ="pwwkew";
        System.out.println(main3.lengthOfLongestSubstring(str));
    }
}
