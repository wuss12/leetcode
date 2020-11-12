package com.wuss.leetCode;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @program leetcode
 * @description:
 * @author: wuss
 * @create: 2020/01/21 09:56
 */
public class Main43 {
    char zero = '0';

    public String multiply(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        if ("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        int jin = 0;
        char ch1,ch2;
        int mutiply = 0;
        StringBuilder[] sb = new StringBuilder[num2.length()];
        for (int i = num2.length() - 1; i >= 0; i--) {
            jin = 0;
            sb[i] = new StringBuilder();
            ch2 = chars2[i];
            for (int j = num1.length() - 1; j >= 0; j--) {
                ch1 = chars1[j];
                mutiply = (ch2 - zero) *(ch1 - zero) +jin;
                sb[i].append(mutiply%10);
                jin = mutiply /10;
            }
            if (jin > 0){
                sb[i].append(jin);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i=0;i<sb.length;i++){
            sb[i] = sb[i].reverse();
            for (int j=sb.length -1;j>i;j--){
                sb[i].append("0");
            }
            result = add(sb[i],result);
        }
        return result.toString();
    }



    public StringBuilder add(StringBuilder sb1, StringBuilder sb2) {
        StringBuilder result = new StringBuilder();
        int minLen = Math.min(sb1.length(), sb2.length());
        StringBuilder tempSb = null;
        int i = 0;
        int jin = 0;
        char ch1, ch2;
        int sum = 0;
        sb1 = sb1.reverse();
        sb2 = sb2.reverse();
        while (i < minLen) {
            ch1 = sb1.charAt(i);
            ch2 = sb2.charAt(i);
            sum = ch1 - zero + ch2 - zero + jin;
            jin = sum /10;
            sum = sum %10;

            result.append(sum);
            i++;
        }
        tempSb = i < sb1.length() ? sb1 : sb2;
        while (i < tempSb.length()) {
            ch1 = tempSb.charAt(i);
            sum = ch1 - zero + jin;
            jin = sum /10;
            sum = sum %10;

            result.append(sum);
            i++;
        }

        if (jin > 0) {
            result.append(1);
        }
        return result.reverse();
    }



}



