package com.wuss.leetCode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class Main60 {
    static int[] numAre = new int[9];
    static {
        numAre[0]=1;
        for (int i=2;i<= 9;i++){
            numAre[i-1] = numAre[i-2]*i;
        }
    }
    int m = 0;
    int limitNum;
    String result;
    StringBuilder sb = new StringBuilder();
    public String getPermutation(int n, int k) {
        m = 0;
        limitNum = k;
        String str ="123456789";
        result = null;
        getPermutation(str.substring(0,n),new Stack<Character>(),n);
        return result;
    }


    public void getPermutation(String str, Stack<Character> stack,int k){
        if(result != null){
            return ;
        }
        char[] arr = str.toCharArray();
        if (k == 1){
            if(m+str.length() < limitNum){
                m+= str.length();
                return;
            }
            for (int i=0;i<str.length();i++){
                m++;
                if (m == limitNum){
                    Character[] re = new Character[stack.size()];
                    stack.copyInto(re);
                    sb.setLength(0);
                    for (int j = 0;j<re.length;j++){
                        sb.append(re[j]);
                    }
                    sb.append(arr[i]);
                    result = sb.toString();
                    return ;
                }
            }
            return ;
        }


        for (int i =0;i<arr.length;i++){
            if (m + numAre[k-2] < limitNum){
                m += numAre[k-2];
                continue;
            }
            stack.push(arr[i]);
            sb.setLength(0);
            for (int j=0;j<str.length();j++){
                if (j != i){
                    sb.append(arr[j]);
                }
            }

            getPermutation(sb.toString(),stack,k-1);
            stack.pop();
        }

    }


    public static void main(String[] args) {
        Main60 main60 = new Main60();
        System.out.println(Arrays.toString(numAre));
        System.out.println(main60.getPermutation(9,3));
    }

}
