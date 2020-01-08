package com.wuss.leetCode;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main32 {
    public  int longestValidParentheses(String s) {

        char[] chars = s.toCharArray();
        int len = chars.length;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for (int i=0;i<len;i++){
            if (chars[i] == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    max = Math.max(max,i-stack.peek());
                }
            }

        }
        return max;

    }

    public int longestValidParentheses1(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        int left = 0,right = 0;
        for (int i=0;i<len;i++){
            if (chars[i] == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                max = Math.max(max,left <<1);
                continue;
            }
            if (left < right){
                left = right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i=len -1;i>=0 ;i--){
            if (chars[i] == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                max = Math.max(max,left <<1);
                continue;
            }
            if (left > right){
                left = right = 0;
            }
        }
        return max;
    }



    public static void main(String[] args) {
        TestMain.testMethod(Main32.class);
    }
}
