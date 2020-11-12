package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。`x`
 * @program leetcode
 * @description:
 * @author: wuss
 * @create: 2020/01/20 10:15
 */
public class Main40 {
    List<List<Integer>> list = new ArrayList<>();
    int len;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        len = candidates.length;
        Arrays.sort(candidates);
        list.clear();
        combinationSum(candidates,0,target,new Stack());
        return list;
    }

    private void combinationSum(int[] candidates, int start, int left, Stack<Integer> stack){
        if (left == 0){
            list.add(new ArrayList<>(stack));
            return;
        }
        if (start >= len){
            return;
        }
        if (candidates[start] > left){
            return;
        }

        for (int i = start;i<len;i++){
            stack.push(candidates[i]);
            combinationSum(candidates,i+1,left - candidates[i],stack);
            stack.pop();
            while (i < len-1 && candidates[i] == candidates[i+1]){
                i++;
            }
        }
    }






    public static void main(String[] args) {

        //[10,1,2,7,6,1,5]

        //8
        int[] arr ={2,5,2,1,2};
        Main40 main40 = new Main40();
        main40.combinationSum2(arr,5);
        System.out.println(main40.list);
    }
}
