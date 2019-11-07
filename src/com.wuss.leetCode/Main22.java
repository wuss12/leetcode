package com.wuss.leetCode;

import java.util.*;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>(100);
        generate("", 0, 0,n,list);
        return list;
    }
    private static void generate(String sb ,int left,int right,int max,List<String> list){
        if(sb.length() == 2*max){
            list.add(sb);
            return;
        }
        if(left < max){
            generate(sb+"(",left+1,right,max,list);
        }
        if(left > right){
            generate(sb+")",left,right+1,max,list);
        }
    }


}
