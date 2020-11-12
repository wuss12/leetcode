package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Main216 {


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        combinationSum3(lists,new ArrayList<>(),n,k,1);
        return lists;
    }

    public void combinationSum3(List<List<Integer>> lists,List<Integer> tempList,int leftN,int leftK,int start){
        if (leftK == 0 && leftN == 0){
            lists.add(new ArrayList<>(tempList));
            return;
        }
        if (start > leftN || leftN < 0 || leftK > 9){
            return;
        }

        for (int i= start;i<=9;i++){
            tempList.add(i);
            combinationSum3(lists,tempList,leftN - i,leftK-1,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
