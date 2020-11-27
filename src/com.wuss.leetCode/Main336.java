package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 336. 回文对
 * 给定一组 互不相同 的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["abcd","dcba","lls","s","sssll"]
 * 输出：[[0,1],[1,0],[3,2],[2,4]]
 * 解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 示例 2：
 *
 * 输入：["bat","tab","cat"]
 * 输出：[[0,1],[1,0]]
 * 解释：可拼接成的回文串为 ["battab","tabbat"]
 */
public class Main336 {

    //metho one

//    List<char[]> chars ;
//
//    public List<List<Integer>> palindromePairs(String[] words) {
//
//        List<List<Integer>> list = new ArrayList<>();
//        int len = words.length;
//        if (len <= 0){
//            return list;
//        }
//        chars = new ArrayList(len);
//        for (String s: words){
//            chars.add(s.toCharArray());
//        }
//        for (int i=0;i<len;i++){
//            for (int j=i+1;j<len;j++){
//                if (huiwen(i,j)){
//                    list.add(Arrays.asList(i,j));
//                }
//                if (huiwen(j,i)){
//                    list.add(Arrays.asList(j,i));
//                }
//            }
//        }
//        return list;
//    }
//
//
//    private boolean huiwen(int i,int j){
//        char[] chars1 = chars.get(i);
//        char[] chars2 = chars.get(j);
//        int l1 = chars1.length;
//        int l2 = chars2.length;
//        int min = Math.min(l1,l2);
//        for (int k=0,m = l2-1;k<min;k++,m--){
//            if (chars1[k]!= chars2[m]){
//                return false;
//            }
//        }
//        if (l1 > min){
//            for (int m = min,k = l1-1;m<l1;m++,k--){
//                if (chars1[m]!= chars1[k]){
//                    return false;
//                }
//            }
//        }
//        if (l2 > min){
//            for (int m = 0,k = l2-1-min;m<k;m++,k--){
//                if (chars2[m]!= chars2[k]){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }


    public static void main(String[] args) {
        String[] arrs = {"abc","bcd","abcd"};
        Main336 main336 = new Main336();
        main336.palindromePairs(arrs);
    }

    class Node {
        int[] ch = new int[26];
        int flag;

        public Node() {
            flag = -1;
        }
    }

    List<Node> tree = new ArrayList<Node>();

    public List<List<Integer>> palindromePairs(String[] words) {
        tree.add(new Node());
        int n = words.length;
        for (int i = 0; i < n; i++) {
            insert(words[i], i);
        }
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            int m = words[i].length();
            for (int j = 0; j <= m; j++) {
                if (isPalindrome(words[i], j, m - 1)) {
                    int leftId = findWord(words[i], 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
                    int rightId = findWord(words[i], j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    public void insert(String s, int id) {
        int len = s.length(), add = 0;
        for (int i = 0; i < len; i++) {
            int x = s.charAt(i) - 'a';
            if (tree.get(add).ch[x] == 0) {
                tree.add(new Node());
                tree.get(add).ch[x] = tree.size() - 1;
            }
            add = tree.get(add).ch[x];
        }
        tree.get(add).flag = id;
    }

    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    public int findWord(String s, int left, int right) {
        int add = 0;
        for (int i = right; i >= left; i--) {
            int x = s.charAt(i) - 'a';
            if (tree.get(add).ch[x] == 0) {
                return -1;
            }
            add = tree.get(add).ch[x];
        }
        return tree.get(add).flag;
    }




}