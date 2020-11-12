package com.wuss.leetCode;

import java.util.Arrays;

/**
 * 41. 缺失的第一个正数
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program leetcode
 * @description:
 * @author: wuss
 * @create: 2020/01/20 11:01
 */
public class Main41 {
    private int firstMissingPositive1(int[] nums) {
        Arrays.sort(nums);
        boolean start = false;
        int num =1;
        for (int i =0;i<nums.length;i++){
            if (nums[i] > 0){
                if (start == false ){
                    if ( nums[i] != 1){
                        return 1;
                    }
                    start = true;

                }
                if (i>0 && nums[i] == nums[i-1]){
                    continue;
                }
                if (start && nums[i] != num ++){
                    return num-1 ;
                }

            }
        }
        return num++;
    }


    public int firstMissingPositive(int[] nums) {
        int num = 0;
        for (int i= nums.length -1;i>=0;i--){
            if (nums[i] > 0){
                num++;
            }
        }
        int[] arr = new int[num+2];
        for (int i= nums.length -1;i>=0;i--){
            if (nums[i] > 0 && nums[i] <= num){
                arr[nums[i]] =1;
            }
        }
        for (int i=1;i<arr.length;i++){
            if (arr[i] != 1){
                return i;
            }
        }
        return 1;

    }
    public static void main(String[] args) {
        TestMain.testMethod(Main41.class);
    }
}
