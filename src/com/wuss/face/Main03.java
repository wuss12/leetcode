package com.wuss.face;

import com.wuss.leetCode.TestMain;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * @create: 2020/03/13 13:31
 * 面试题 01.03. URL化
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。
 * 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *
 * 示例1:
 *
 *  输入："Mr John Smith    ", 13
 *  输出："Mr%20John%20Smith"
 * 示例2:
 *
 *  输入："               ", 5
 *  输出："%20%20%20%20%20"
 * 提示：
 *
 * 字符串长度在[0, 500000]范围内。
 */
public class Main03 {
    public String replaceSpaces(String S, int length) {
        if (length > S.length()){
            length = S.length();
        }
        char[] arr = new char[length*3];
        int j = 0;
        char ch;
        for (int i=0;i<length;i++){
            ch = S.charAt(i);
            if (ch == ' '){
                arr[j++] = '%';
                arr[j++] = '2';
                arr[j++] = '0';
                continue;
            }
            arr[j++] = ch;
        }
        return new String(arr,0,j);
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main03.class);
    }
}
