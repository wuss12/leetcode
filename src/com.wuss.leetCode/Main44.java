package com.wuss.leetCode;

import java.util.Arrays;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 * <p>
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 * <p>
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 * <p>
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @program leetcode
 * @description:
 * @author: wuss
 * @create: 2020/02/03 10:34
 * "adceb"
 * "*a*b"
 */
public class Main44 {
    private boolean isMatch(String s, String p) {
       if (p.isEmpty()){
           return s.isEmpty();
       }
       boolean isFirstMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?' ));
       if (isFirstMatch){
           return isMatch(s.substring(1),p.substring(1));
       }
       if (p.charAt(0) == '*'){
           if (s.isEmpty()){
               return isMatch(s,p.substring(1));
           }
           return isMatch(s,p.substring(1))|| isMatch(s.substring(1),p);
       }
       return false;
    }
    private static boolean isEmpty(String s){
        return s == null || s.length() == 0;
    }

    public static void main(String[] args) {
//       Main44 main44 = new Main44();
//        System.out.println(main44.isMatch1("a","a*"));;
        TestMain.testMethod(Main44.class);
    }

    public boolean isMatch1(String s, String p) {
      //arr[pi][sj]-> 第i位置上的模式串 是否 匹配 字符串第j位置  也就是：p.charAt(i) 和  s.charAt(j)是否匹配
      // 如果 p.charAt(j) 和 p.charAt(i)相同 或者 p.charAt(i) == '?' -> arr[pi][sj] = arr[pi-1][sj-1]
      // 如果 p.charAt(j) == '*' 且 arr[pi-1][sj-1] == true||arr[pi-1][sj]==true  -> arr[pi-1][j] j> sj-1 =true
        int[][] arr = new int[p.length()+1][s.length()+1];
        arr[0][0] = 1;
        for (int i=0;i< p.length();i++){
            if (p.charAt(i) == '*'){
                arr[i+1][0] = arr[i][0];
            }
        }

        for (int i=1;i <= p.length();i++){
            char pCh = p.charAt(i-1);
            for (int j=1;j<= s.length();j++){
                char sCh = s.charAt(j-1);
                if (sCh == pCh || pCh == '?'){
                    arr[i][j] = arr[i-1][j-1];
                    continue;
                }
                if (pCh == '*' && Math.max(arr[i-1][j-1],arr[i-1][j]) == 1){
                   for (;j<= s.length();j++){
                       arr[i][j] = 1;
                   }
                }

            }
        }
        return arr[p.length()][s.length()] == 1;
    }
}
