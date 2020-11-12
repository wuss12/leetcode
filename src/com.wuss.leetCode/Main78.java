package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Main78 {
    int size;
    public List<List<Integer>> subsets(int[] nums) {
        size = nums.length;
        List<List<Integer>> list = new ArrayList<>(1000);
        list.add(new ArrayList<>());
        if (size == 0){
            return list;
        }
        List<Integer> tempList = new ArrayList<>();
        for (int i=1;i<= size;i++){
            subsets(nums,tempList,list,i,0);
        }
        return list;
    }

    public void subsets(int[] nums,List<Integer> tempList,List<List<Integer>> resultList,int k,int start){
        if (k == 0){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        int tempListSize = tempList.size();
        for (int i= start;i < size;i++){
            tempList.add(nums[i]);
            subsets(nums,tempList,resultList,k-1,start+1);
            tempList.remove(tempListSize);
        }
    }
}
