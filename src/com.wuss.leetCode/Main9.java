package com.wuss.leetCode;

import java.util.Scanner;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 */
public class Main9 {
    public static void main(String[] args) {
        Main9 main9 = new Main9();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(main9.isPalindrome(scanner.nextInt()));
        }
    }

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        String numStr = String.valueOf(x);
        int end = numStr.length() -1;
        int begin = 0;
        for (;begin<end;){
            if(numStr.charAt(begin++) != numStr.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
