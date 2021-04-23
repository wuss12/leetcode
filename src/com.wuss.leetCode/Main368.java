package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 368. 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 *
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * @create: 2021/04/23 09:32
 */
public class Main368 {

    //Map<K> 表示已K结尾的最长结果
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();

        int len = nums.length;
        List<Integer> list = null;
        int temp;
        for (int i=0;i<len;i++){
            temp = nums[i];
            int maxLen = 0;
            list = null;
            for (int j=i-1;j>=0;j--){
                if (temp % nums[j] == 0){
                    List<Integer> list1 = map.get(nums[j]);
                    if (list1!=null && list1.size()>maxLen){
                        maxLen = list1.size();
                        list = list1;
                    }
                }
            }
            ArrayList<Integer> integers = null;
            if (list == null){
                integers = new ArrayList<>();
            }else {
                integers= new ArrayList<>(list);
            }
            integers.add(temp);
            map.put(temp,integers);
            if (integers.size()> result.size()){
                result = integers;
            }
          
        }
        return result;

    }


    public static void main(String[] args) {
        Main368 main368 = new Main368();
        int[] ints = {1,2,3,8,6,12,24} ;
        System.out.println(main368.largestDivisibleSubset(ints));
    }

}
