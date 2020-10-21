package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 925. 长按键入
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 *
 *
 * 示例 1：
 *
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 *
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * 示例 3：
 *
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * 示例 4：
 *
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 */
public class Main925 {

    public  boolean isLongPressedName(String name, String typed) {
        int i=0,j=0;
        int len = name.length();
        int len1 = typed.length();
        if (len > len1){
            return false;
        }
        if (len == len1){
            return name.equals(typed);
        }
        while (j<len1){
            if (i<len && name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
                continue;
            }
            if (j>0 && typed.charAt(j)==typed.charAt(j-1)){
                j++;
                continue;
            }
            return false;
        }
        return i>= len;
    }


    public static void main(String[] args) {
        TestMain.testMethod(Main925.class);
    }
}