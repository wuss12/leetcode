package com.wuss.leetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 46 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main46 {
    public List<List<Integer>> permute(int[] nums) {
       return premute(nums,new Stack<Integer>());

    }

    public List<List<Integer>> premute(int[] nums, Stack<Integer> stack){
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums.length == 0){
            Integer[] arrs = new Integer[stack.size()];
            stack.copyInto(arrs);
            lists.add(Arrays.asList(arrs));
            return lists;
        }
        for (int i=0;i< nums.length;i++){
            stack.push(nums[i]);
            int[] newNums = new int[nums.length -1];
            int index= 0;
            for (int k=0;k<nums.length;k++){
                if (k != i){
                    newNums[index++] = nums[k];
                }
            }
            lists.addAll(premute(newNums,stack));
            stack.pop();
        }
        return lists;
    }
}
