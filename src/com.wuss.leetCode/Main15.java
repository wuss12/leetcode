package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 3) return lists;
        int a, L,R,sum;
        for (int i = 0; i < len; i++) {
            a = nums[i];
            if (a > 0) {
                break;
            }
            if(i > 0 && nums[i -1] == a){
                continue;
            }
            L = i+1;
            R = len -1;
            while (L < R){
                sum = 0;
                sum = a + nums[L] ;
                if(sum > 0){
                    break;
                }
                sum += nums[R];
                if(sum == 0){
                    lists.add(Arrays.asList(a,nums[L],nums[R]));
                    while (L < R && nums[L] == nums[L+1]){
                        L++;
                    }
                    while (L < R && nums[R-1] == nums[R]){
                        R --;
                    }
                    L++;
                    R--;
                    continue;
                }
                if(sum > 0){
                    R --;
                }else {
                    L++;
                }
            }


        }
        return lists;
    }




    public static void main(String[] args) {
//        int[] arr = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        int[] arr = {-1, 0, 1, 2, -1, -4};
        TestMain.testMethod(Main15.class);
    }
}
