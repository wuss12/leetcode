package com.wuss.leetCode;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main28 {
    public static int strStr(String haystack, String needle) {
        int sorceLen = haystack.length();
        int needLen = needle.length();
        if (sorceLen < needLen){
            return -1;
        }
        for (int i=0;i<= sorceLen - needLen;i++){
            int j=0;
            for ( ;j<needLen;j++){
                if (haystack.charAt(i+j)!= needle.charAt(j)){
                    break;
                }
            }
            if (j == needLen){
                return i;
            }
        }
        return -1;

    }

}
