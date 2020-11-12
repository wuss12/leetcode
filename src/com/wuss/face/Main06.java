package com.wuss.face;

import com.wuss.leetCode.TestMain;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * @create: 2020/03/13 14:41
 * 面试题 01.06. 字符串压缩
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，
 * 字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 *  "bbbac"
 * 提示：
 *
 * 字符串长度在[0, 50000]范围内。
 */
public class Main06 {
    public String compressString(String s) {
        int len = s.length();
        if (len <= 1){
            return s;
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        char chOld = chars[0],chNew=chOld;
        int count = 1;
        for (int i=1;i<= len-1 ;){
            chNew = chars[i];
            if (chOld != chNew){
                sb.append(chOld);
                sb.append(count);
                chOld = chNew;
                count = 1;
                i++;
                continue;
            }
            count++;
            i++;


        }
        sb.append(chNew).append(count);

        if (len <= sb.length()){
            return s;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main06.class);
    }
}
