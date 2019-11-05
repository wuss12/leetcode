package com.wuss.leetCode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        if (len == 0){
            return true;
        }
        char ch,lastChar;
        for (int i=0;i<len;i++){
            ch = s.charAt(i);
            if(ch == '(' || ch == '['||ch == '{'){
                stack.push(ch);
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            lastChar = stack.pop();
            switch (ch){
                case ')':
                    if(lastChar != '('){
                        return false;
                    }
                    break;
                case ']':
                    if(lastChar != '['){
                        return false;
                    }

                    break;
                case '}':
                    if(lastChar != '{'){
                        return false;
                    }
                    break;

            }
        }
        return stack.isEmpty();
    }
}
