package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class Main91 {

    /**
     * dp[i]表示0-i最多的译码数
     * 如果 s[i] == '0' 如果s[i-1] == '1' 或者'2' dp[i] = dp[i-2] 否则返回0
     * 如果 s[i-1] == '1' dp[i] = dp[i-1]+dp[i-2]
     * 如果 s[i-1] =='2' and s[i] in ['1','6'] dp[i] = dp[i-1]+dp[i-2]  否则：dp[i]=dp[i-1]
     * @param s
     * @return
     */
    public int numDecodings(String s1) {
        char[] s = s1.toCharArray();

        if (s[0] == '0') return 0;
        int len = s.length;
        int[] dp = new int[len+1];
        dp[1]=1;
        dp[0]=1;
        char cCh,pCh;
        for (int i=2;i<= len;i++){
            cCh = s[i-1];
            pCh = s[i-2];
            if (cCh =='0'){
                if (pCh == '1'|| pCh =='2'){
                    dp[i] = dp[i-2];
                    continue;
                }
                return 0;
            }
            if (pCh =='1' || pCh=='2' && cCh>='1'&& cCh<='6'){
                dp[i] = dp[i-1]+dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[len];

    }


    public static void main(String[] args) {
        TestMain.testMethod(Main91.class);
    }
}
