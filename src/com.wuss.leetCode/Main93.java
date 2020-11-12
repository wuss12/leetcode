package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class Main93 {
    List<String> reList = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        reList.clear();
        int len = s.length();
        if (len >12){
            return reList;
        }
       restoreIpAddresses(s,0,3,new ArrayList<>());
        return reList;
    }

    StringBuilder sb = new StringBuilder();
    private void restoreIpAddresses(String s,int start,int left,List<String> list ) {

        if (left ==0 && s.length() - start <= 3 ){
            sb.setLength(0);
            for (String s1 : list){
                if (!valid(s1)){
                    return;
                }
                sb.append(s1);
            }
            String leftStr = s.substring(start);
            if (valid(leftStr)){
                sb.append(leftStr);
                reList.add(sb.toString());
            }

        }
        if (left == 0){
            return;
        }
        int len = s.length();
        int leftLen = len -start;
        if (left ==1){
            if (leftLen >6){
                return;
            }
        }
        for (int i=start+1;i<len;i++){
            int le = list.size();
            String str1 = s.substring(start,i);
            list.add(str1);
            list.add(".");
            restoreIpAddresses(s,i,left-1,list);
            for (int k = list.size()-1;k>= le;k-- ){
                list.remove(k);
            }
        }

    }
    private boolean valid(String s){
        int len = s.length();
        if (len >3 || (len == 3 && "255".compareTo(s)< 0)){
            return false;
        }
        if (len > 1 && s.startsWith("0")){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main93.class);
    }
}
