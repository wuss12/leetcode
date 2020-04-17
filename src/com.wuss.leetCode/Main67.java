package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。

 */
public class Main67 {
    public String addBinary(String a, String b) {
        int len1 =a.length();
        if (len1 == 0){
            return b;
        }
        int len2 = b.length();
        if (len2 == 0){
            return a;
        }
        int jin = 0;
        int i= len1-1,j=len2-1;
        int num1,num2,sum;
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (i >=0 || j>= 0 || jin>0){
            num1 = i>=0?arr1[i] - '0':0;
            num2 = j>=0?arr2[j] - '0':0;
            sum = num1+num2+jin;
            if (sum >=2){
                jin = 1;
                sum = sum -2;
            }else {
                jin = 0;
            }
            sb.append(sum);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main67.class);
    }
}
