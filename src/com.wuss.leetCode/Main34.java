package com.wuss.leetCode;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program leetcode
 * @description:
 * @author: wuss
 * @create: 2020/01/19 15:33
 */
public class Main34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        int left = 0;
        int len  = nums.length ;
        if (len <= 0){
            return result;
        }
        if (len == 1){
            return nums[0] == target?new int[]{0,0}:result;
        }
        int index = findBi(nums,0,len-1,target);
        if (index == -1){
            return result;
        }
        result = new int[]{index,index};

        while (true){

            int leftIndex = findBi(nums,0,result[0] -1,target);
            if (leftIndex == -1){
                break;
            }
            result[0] = leftIndex;

        }
        while (true){

            int rightIndex = findBi(nums,result[1] +1,len-1,target);
            if (rightIndex == -1){
                break;
            }
            result[1] = rightIndex;

        }
        return result;


    }
    private int findBi(int[] nums,int left,int right,int target){
        if (left > right){
            return -1;
        }
        while (left <= right){
            int mid = (left + right) /2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] > target){
                right = mid -1;
                continue;
            }
            left = mid +1;
        }
        return -1;
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main34.class);
    }
}

