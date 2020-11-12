package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 *127. 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class Main127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len=wordList.size();
        if (len ==0){
            return len;
        }
        int[][] arrs = getArr(wordList);
        int end = wordList.indexOf(endWord);
        if ( end <0){
            return 0;
        }
        int min = 0;
        boolean[] flags = new boolean[len];
        Deque<Integer> deque = new LinkedList();
        for (int i=0;i<len;i++){
            if (similer(beginWord,wordList.get(i))){
                deque.add(i);
                flags[i] = true;
            }
        }
        if (deque.isEmpty()){
            return 0;
        }
        min = 1;
        while (!deque.isEmpty()){
            int size = deque.size();
            min++;
            for (int i=0;i<size;i++){
                Integer integer = deque.pollFirst();
                if (integer == end){
                    return min;
                }
                for (int j=0;j<len;j++){
                    if (!flags[j] && arrs[integer][j] == 1){
                        deque.offerLast(j);
                        flags[j]= true;
                    }
                }
            }
        }
        return 0;

    }



    public static int[][] getArr(List<String> wordList){
        int len = wordList.size();
        int[][] arrs = new int[len][len];
        for (int i=0;i<len;i++){
            for (int j=0;j<len ;j++){
                if (i == j){
                    arrs[i][j] = 0;
                    continue;
                }
                arrs[i][j] = similer(wordList.get(i),wordList.get(j)) ? 1:0;
                arrs[j][i] = arrs[i][j];
            }
        }
        return arrs;
    }

    private static boolean similer(String s1,String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2){
            return false;
        }
        int notEq = 0;
        for (int i=0;i<len1;i++){
            if (s1.charAt(i) != s2.charAt(i)){
                notEq++;
                if (notEq>1){
                    return false;
                }
            }
        }
        return true;
    }



    public static void main(String[] args) {
        Main127 main127 = new Main127();
//        String beginWord = "hit";
//        String endWord ="cog";
//        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));

//        String beginWord = "hot";
//        String endWord ="dog";
//        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dog","cog","pot","dot"));

        String beginWord = "hit";
        String endWord ="cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","cog","dot","dog","hit","lot","log"));

//
//        String beginWord = "hit";
//        String endWord ="cog";
//        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
//        String beginWord = "hot";
//        String endWord ="dog";
//        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog"));


//        String beginWord = "hot";
//        String endWord ="dog";
//        List<String> wordList = new ArrayList<>(Arrays.asList("hot","cog","dog","tot","hog","hop","pot","dot"));
        int i = main127.ladderLength(beginWord, endWord, wordList);
        System.out.println(i);

    }
}

