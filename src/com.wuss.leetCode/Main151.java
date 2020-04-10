package com.wuss.leetCode;
import java.util.Scanner;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 */
public class Main151 {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if ("".equals(words[i])) {
                continue;
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(words[i]);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Main151 main151 = new Main151();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println( main151.reverseWords(scanner.nextLine()));
        }
    }
}
