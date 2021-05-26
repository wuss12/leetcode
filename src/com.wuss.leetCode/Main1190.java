package com.wuss.leetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * @create: 2021/05/26 18:00
 * 1190. 反转每对括号间的子串
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 *
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 *
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 *
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 */
public class Main1190 {

    // 方法一 递归
    public String reverseParentheses1(String s) {
        int indexl = s.lastIndexOf('(');
        if(indexl< 0){
            return s;
        }
        int indexr = s.indexOf(')',indexl);
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0,indexl)).append(reverse(s.substring(indexl+1,indexr))).append(s.substring(indexr+1));
        return reverseParentheses1(sb.toString());
    }

    private String reverse(String str){
        if(str.length() <= 1){
            return str;
        }
        return new StringBuilder(str).reverse().toString();
    }

    // 方法二 栈

    public String reverseParentheses(String s) {
        int len = s.length();
        if(len<=1){
            return s;
        }
        Deque<String> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        char ch;
        for (int i=0;i<len;i++){
            ch = s.charAt(i);
            if(ch == '('){
                deque.push(sb.toString());
                sb.setLength(0);
                continue;
            }
            if(ch == ')'){
                // 反转
                sb.reverse();
                if(deque.size()>0){
                    sb.insert(0,deque.pop());
                }
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }


    public String reverseParentheses2(String s) {
        Deque<String> stack = new LinkedList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }




    public static void main(String[] args) {
//        String str =  "(u(love)i)";
        String str = "((eqk((h))))";

        Main1190 main1190 = new Main1190();

        System.out.println(main1190.reverseParentheses(str));
        System.out.println(main1190.reverseParentheses2(str));

        StringBuilder sb = new StringBuilder();
        sb.append("11");
        System.out.println(sb.toString());
        System.out.println(sb.insert(0,"").toString());
    }

}
