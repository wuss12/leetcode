package com.wuss.leetCode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int len = strs.length;
        if(len == 0){
            return "";
        }
        String firstStr = strs[0];


        while (true){
            for (int j=0;j<firstStr.length();j++){
                sb.append(firstStr.charAt(j));
                for (int i=0;i< len;i++){
                    if(!strs[i].startsWith(sb.toString())){
                        sb.deleteCharAt(j);
                        return sb.toString();
                    }
                }
            }
            break;

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main14.class);
    }
}
