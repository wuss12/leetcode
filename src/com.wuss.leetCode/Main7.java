package com.wuss.leetCode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Main7 {

    public int reverse(int x) {
        boolean fu = x >=0;
        StringBuilder sb = new StringBuilder();
        sb.append(fu? x:-x);
        String value = sb.reverse().toString();
        int maxLen = String.valueOf(Integer.MAX_VALUE).length();
        if(value.length() > maxLen){
            return 0;
        }
        Long result = Long.valueOf(value);
        if(fu){
            if(result > Long.valueOf(Integer.MAX_VALUE)){
                return 0;
            }
            return result.intValue();
        }
        result = -result;
        if(result < Long.valueOf(Integer.MIN_VALUE)){
            return 0;
        }
        return result.intValue();
    }

    public static void main(String[] args) {
        Main7 main7 = new Main7();
        System.out.println(main7.reverse(1230));
    }
}
