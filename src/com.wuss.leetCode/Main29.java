package com.wuss.leetCode;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 1){
            return dividend;
        }
        if (divisor == -1){
            return dividend == Integer.MIN_VALUE? Integer.MAX_VALUE:-dividend;
        }
        if (dividend == divisor){
            return 1;
        }

        boolean fu = (dividend > 0) ^ (divisor>0);
        if (dividend > 0){
            dividend = -dividend;
        }
        if (divisor > 0){
            divisor = -divisor;
        }
        int [] arr = new int[31];

        arr[0] = divisor;

        int maxIndex = 0;
        for (int i=1;i<31;i++){
            arr[i] = arr[i-1]<<1;
            if(arr[i] <= Integer.MIN_VALUE>>1 || arr[i]>=0){
                maxIndex = i-1;
                break;
            }
        }
        int result = 0;
        for (int i = maxIndex;dividend<= divisor;i--){
            while (dividend <= arr[i]){
                dividend -= arr[i];
                result += numArr[i];
            }
        }
        return fu? -result:result;
    }

    static int numArr[] = new int[31];
    static {
        numArr[0]=-1;
        for (int i=1;i<31;i++){
            numArr[i] = numArr[i-1]<<1;
        }
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main29.class);
    }



}
