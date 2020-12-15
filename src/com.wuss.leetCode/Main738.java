package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * 738. 单调递增的数字
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 */
public class Main738 {

    public int monotoneIncreasingDigits(int N) {
        char[] chars = Integer.toString(N).toCharArray();
        int len = chars.length;
        if (len<2){
            return N;
        }
        int i=1;

        while (i<len && chars[i]>= chars[i-1]){
            i++;
        }

        if (i == len){
            return N;
        }

        for (;i>0;i--){
            if (chars[i]> chars[i-1]){
                break;
            }
        }
        chars[i] -= 1;
        for (i=i+1;i<len;i++){
            chars[i] = '9';
        }
        return Integer.valueOf(new String(chars));
    }
}
