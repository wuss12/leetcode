package com.wuss.face;

import com.wuss.leetCode.TestMain;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 *面试题46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 *
 * 提示：
 *
 * 0 <= num < 2的31
 */
public class Main46 {
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int len = numStr.length();
        if (len <=1){
            return 1;
        }
        int p = 0,q = 0,r=1;

        char chP,ch;
        for (int i=0;i<len;i++){

            p = q;
            q = r;
            r = q;
            if (i == 0){
                continue;
            }
            ch = numStr.charAt(i);
            chP = numStr.charAt(i-1);
            if (chP <'2'&& chP>'0' || chP =='2' && ch <= '5'){
                r += p;
            }


        }
        return r;

    }


//    public int translateNum(int num) {
//        String src = String.valueOf(num);
//        int p = 0, q = 0, r = 1;
//        for (int i = 0; i < src.length(); ++i) {
//            p = q;
//            q = r;
//            r = 0;
//            r += q;
//            if (i == 0) {
//                continue;
//            }
//            String pre = src.substring(i - 1, i + 1);
//            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
//                r += p;
//            }
//        }
//        return r;
//    }





    public static void main(String[] args) {
        TestMain.testMethod(Main46.class);
    }
}
