package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 97. 交错字符串
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * 示例 1:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 */
public class Main97 {
//    method one
    class Solution1{

    Boolean[][]memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3){
            return false;
        }
        if(len3 ==0){
            return true;
        }
        memo = new Boolean[len1][len2];
        return isInterleave(s1,0,s2,0,s3,0);

    }

    private boolean isInterleave(String s1,int i,String s2,int j,String s3,int k){
        if (i == s1.length()){
            return s2.substring(j).equals(s3.substring(k));
        }
        if (j == s2.length()){
            return s1.substring(i).equals(s3.substring(k));
        }
        if (memo[i][j] != null){
            return memo[i][j];
        }
        boolean ans = false;
        char ch3 = s3.charAt(k);
        if ((s1.charAt(i) == ch3 && isInterleave(s1,i+1,s2,j,s3,k+1)) || s2.charAt(j) == ch3 && isInterleave(s1,i,
                s2,j+1,s3,k+1)){
            ans = true;
        }
        memo[i][j] = ans;
        return ans;
    }
}

    public class Solution2 {
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s3.length() != s1.length() + s2.length()) {
                return false;
            }
            boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
            for (int i = 0; i <= s1.length(); i++) {
                for (int j = 0; j <= s2.length(); j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = true;
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                    } else {
                        dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                    }
                }
            }
            return dp[s1.length()][s2.length()];
        }
    }


//    public static void main(String[] args) {
//        TestMain.testMethod(Main97.class);
//    }
}
