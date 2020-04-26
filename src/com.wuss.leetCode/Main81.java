package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 81. 搜索旋转排序数组 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 *
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么
 */
public class Main81 {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        if (end < 0 )
            return false;
        int mid;
        while (start <= end){
            mid = (start + end)>>1;
            if (nums[mid] == target){
                return true;
            }
            if (nums[mid] == nums[start]){
                start++;
                continue;
            }
            //前部分有序
            if (nums[start] < nums[mid]){
                if (nums[start] <= target && target <= nums[mid]){
                    end = mid -1;
                }else {
                    start = mid +1;
                }
            }else {
                if (nums[mid] <= target && target <= nums[end]){
                    start = mid +1;
                }else {
                    end = mid -1;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        TestMain.testMethod(Main81.class);
    }

}
