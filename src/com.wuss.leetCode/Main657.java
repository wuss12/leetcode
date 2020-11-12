package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 657. 机器人能否返回原点
 */
public class Main657 {
    //R（右），L（左），U（上）和 D（下）
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arrs  = s.split(" ");
        for(int i=0;i<arrs.length;i++){
            String s1 = arrs[i];
            for(int j= s1.length()-1;j>=0;j--){
                sb.append(s1.charAt(j));
            }
            sb.append(" ");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}
