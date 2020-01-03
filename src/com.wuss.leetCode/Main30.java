package com.wuss.leetCode;


import java.util.*;

/**
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main30 {
//    public  List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> list = new ArrayList<>();
//        int nums = words.length;
//        if (nums == 0){
//            return list;
//        }
//        int len = words[0].length();
//        int allLen = len * nums;
//        int stringLen = s.length();
//        if (stringLen < allLen){
//            return list;
//        }
//        List<String> oriList = Arrays.asList(words);
//        List<String> newList = new ArrayList<>(nums);
//        for (int i=0;i<= stringLen - allLen;i++){
//            newList.clear();
//            for (int j=0;j<nums;j++){
//                newList.add(s.substring(i+len*j,i+len*j+len));
//            }
//            if (oriList.size()!= newList.size()){
//                continue;
//            }
//            for (String str : oriList){
//                newList.remove(str);
//            }
//            if (newList.isEmpty()){
//                list.add(i);
//            }
//        }
//        return list;
//
//    }

    public  List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int nums = words.length;
        if (nums == 0){
            return list;
        }
        int len = words[0].length();
        int allLen = len * nums;
        int stringLen = s.length();
        if (stringLen < allLen){
            return list;
        }
        Map<String,Integer> map = new HashMap<>();
        Integer value = 0;
        for (String str : words){
            value = map.get(str);
            value = value == null? 1:value+1;
            map.put(str,value);
        }
        Map<String,Integer> newMap = new HashMap<>();
        String newStr;
        String tempStr;
        for (int i=stringLen - allLen;i>= 0;i--){
            newMap.clear();
            newMap.putAll(map);
            newStr = s.substring(i,i+allLen);
            for (int j=0;j<nums;j++){
                tempStr = newStr.substring(j*len,j*len+len);
                value = newMap.get(tempStr);
                if (value == null || value <= 0){
                    break;
                }
                value --;
                if (value == 0){
                    newMap.remove(tempStr);
                }else {
                    newMap.put(tempStr,value );
                }

            }
            if (newMap.isEmpty()){
                list.add(i);
            }


        }
        return list;

    }

}
