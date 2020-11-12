package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 *287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class Main287 {
    //抽屉原理
//    public int findDuplicate(int[] nums) {
//        int left = 0;
//        int right = nums.length-1;
//        int mid;
//        int cnt;
//        while (left<right){
//            cnt = 0;
//            mid = (left+right)>>1;
//            for (int num: nums){
//                if (num <= mid){
//                    cnt++;
//                }
//            }
//            if (cnt > mid){
//                right = mid;
//            }else {
//                left = mid+1;
//            }
//        }
//        return left;
//    }

    //快慢指针
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
            fast = nums[fast];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }



    //1 1 2


    public static void main(String[] args) {
        TestMain.testMethod(Main287.class);
    }
}

