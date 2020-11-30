package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 */
public class Main767 {
    /**
     * 第一遍寻找出现次数最多的那个字母，下一遍在寻找不是上一次的，出现最多的字母，依次类推，如果元素未找完，且找到的元素和上一次一样，则寻找不到
     * 暴力破解
     * @param S
     * @return
     */
//    public String reorganizeString(String S) {
//        int[] arrs = new int[26];
//        for (char ch : S.toCharArray()){
//            arrs[ch-'a']++;
//        }
//        int len = S.length();
//
//        StringBuilder sb = new StringBuilder();
//        int preIndex = -1;
//        while (sb.length() < len) {
//            int max = 0;
//            int maxIndex = -1;
//            for (int i = 0; i < 26; i++) {
//                if (preIndex != i && max < arrs[i]) {
//                    max = arrs[i];
//                    maxIndex = i;
//                }
//            }
//            if (maxIndex >= 0) {
//                sb.append((char) (maxIndex + 'a'));
//                arrs[maxIndex]--;
//                preIndex = maxIndex;
//            }
//            if (maxIndex < 0){
//                return "";
//            }
//        }
//
//        return sb.toString();
//    }


    public String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (length + 1) / 2) {
            return "";
        }
        char[] reorganizeArray = new char[length];
        int evenIndex = 0, oddIndex = 1;
        int halfLength = length / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (counts[i] > 0 && counts[i] <= halfLength && oddIndex < length) {
                reorganizeArray[oddIndex] = c;
                counts[i]--;
                oddIndex += 2;
            }
            while (counts[i] > 0) {
                reorganizeArray[evenIndex] = c;
                counts[i]--;
                evenIndex += 2;
            }
        }
        return new String(reorganizeArray);
    }

}
