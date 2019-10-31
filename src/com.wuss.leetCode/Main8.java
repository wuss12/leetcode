package com.wuss.leetCode;

import java.util.Scanner;

/**
 * 你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 *

 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main8 {
    public int myAtoi(String str) {
        char ch;
        boolean zhengshu = true ;
        boolean hasFuhao = false;
        Integer maxLen = String.valueOf(Integer.MAX_VALUE).length();
        StringBuilder sb = new StringBuilder();
        boolean skipBlank = true;
        int len = str.length();
        for (int i=0;i<len;i++){
            ch = str.charAt(i);
            if(ch == ' '){
                if(skipBlank){
                    continue;
                }
                break;
            }
            skipBlank = false;
            if(ch == '+' || ch == '-'){
                if(hasFuhao == true){
                    break;
                }
                hasFuhao = true;
                zhengshu = (ch == '+');
                continue;
            }
            if(ch >= '0' && ch <= '9'){
                hasFuhao = true;
                if(ch == '0' && sb.length() == 0){
                    continue;
                }
                sb.append(ch);
                continue;
            }
            break;
        }
        if(sb.length() ==0){
            return 0;
        }

        if(sb.length() > maxLen){
            return zhengshu? Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        Long result = new Long(sb.toString());
        if(zhengshu){
            if(result >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }

        }else {
            result = - result;
            if(result <= Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }


        return result.intValue();
    }


    public static void main(String[] args) {
        Main8 main8 = new Main8();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(main8.myAtoi(scanner.nextLine()));

        }
    }
}
