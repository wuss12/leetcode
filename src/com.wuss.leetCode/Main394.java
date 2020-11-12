package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class Main394 {
    public String decodeString(String s) {
        int index = s.indexOf(']');
        if (index == -1){
            return s;
        }
        int i = index-1;
        for (;i>=0;i--){
            if (s.charAt(i) =='['){
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        int j = i-1;
        char ch;
        for (;j>=0;j--){
            ch =s.charAt(j);
            if (ch >='0' && ch <= '9'){
                sb.insert(0,ch);
                continue;
            }
            break;
        }
        int num = Integer.valueOf(sb.toString());
        sb.setLength(0);
        String sub = s.substring(i+1,index);
        if (j+1 > 0){
            sb.append(s.substring(0,j+1));
        }

        for (i=0;i<num;i++){
          sb.append(sub);
        }
        if (index+1 < s.length() && index+1>=0){
            sb.append(s.substring(index+1));
        }
        return decodeString(sb.toString());

    }

    public static void main(String[] args) {
        TestMain.testMethod(Main394.class);
    }
}
