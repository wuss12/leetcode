package com.wuss.leetCode;

import java.util.Arrays;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Main66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len-1]<= 8){
            digits[len-1]++;
            return digits;
        }
        int[] arr = new int[len+1];
        int value =1;
        for (int i=len;i>0;i--){
            arr[i] = digits[i-1]+value;
            if (arr[i] > 9){
                arr[i] = 0;
                continue;
            }
            value = 0;

        }
        arr[0] = value;
        if (value == 0){
            return Arrays.copyOfRange(arr,1,len+1);
        }
        return arr;
    }

    public static void main(String[] args) {
        Main66 main66 = new Main66();
        int[] arr ={1,2,3,9};
        System.out.println(Arrays.toString(main66.plusOne(arr)));
    }
}
