package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        int len = nums.length;
        if(len <4){
            return results;
        }
        int L,R,sum;
        Arrays.sort(nums);
        for (int i=0;i<len;i++){
            while (i> 0 && i<len &&nums[i-1] == nums[i] ){
                i++;
            }
            for (int j=i+1;j<len;j++){
                while (j>i+1 && j<len && nums[j-1] == nums[j]){
                    j++;
                }
                L = j+1;
                R = len -1;
                while (L < R){
                    sum = nums[i]+nums[j]+nums[L]+nums[R];
                    if(sum == target){
                        results.add(Arrays.asList(nums[i],nums[j],nums[L],nums[R]));
                        while (L < R && nums[L] == nums[L+1]){
                            L++;
                        }
                        while (L<R && nums[R] == nums[R-1]){
                            R--;
                        }
                        L++;
                        R--;
                    }else if (sum > target){
                        R--;
                    }else {
                        L++;
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main18.class);
        //-3,-2,-1,0,0,1,2,3   0
        //4,-9,-2,-2,-7,9,9,5,10,-10,4,5,2,-4,-2,4,-9,5  -13
        //-13
    }


}
