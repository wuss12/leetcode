package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Main77 {
    List<List<Integer>> resultList = new ArrayList<>(1000);
    public List<List<Integer>> combine(int n, int k) {
        resultList.clear();
        List<Integer> list = new ArrayList<>();
        for (int i=1;i<= n;i++){
            list.add(i);
        }
        return combine(list,new Stack<Integer>(),0,k);
    }

    public List<List<Integer>> combine(List<Integer> list,List<Integer> tempList, int start,int k){
        if (k == 0){
            resultList.add(new ArrayList<>(tempList));
        }
        int size = tempList.size();
        for (int i=start;i<list.size();i++){
            tempList.add(list.get(i));
            combine(list,tempList,i+1,k-1);
            tempList.remove(size);
        }
        return resultList;
    }
    public static void main(String[] args) {
        Main77 main77 = new Main77();
        List<List<Integer>> combine = main77.combine(4, 2);
        combine.stream().forEach((e-> System.out.println(e)));

    }


}
