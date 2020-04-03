package com.wuss.leetCode;

import java.util.*;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main47 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>  lists =  permuteUnique(nums,new Stack<Integer>());
        Set<List<Integer>> set = new HashSet<>(lists);
        return new ArrayList<>(set);

    }

    public static void main(String[] args) {
        TestMain.testMethod(Main47.class);
    }

    public List<List<Integer>> permuteUnique(int[] nums, Stack<Integer> stack){
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
            lists.addAll(permuteUnique(newNums,stack));
            stack.pop();
        }
        return lists;
    }
    Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            int len1 = o1.size();
            int len2 = o2.size();
            if (len1 != len2){
                return len1 -len2;
            }
            for (int i=0;i<len1;i++){
                if (o1.get(i).equals(o2.get(i))){
                    continue;
                }
                return o1.get(i) - o2.get(i);
            }
            return len1 - len2;
        }
    };
}
