package com.wuss.leetCode;

/**
 *  给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int allLen = len1+len2;
        int[] mergeNums = new int[allLen];
        int i1=0,i2=0,i=0;
        while (i1 <len1 && i2 < len2){
            if(nums1[i1]<nums2[i2]){
                mergeNums[i++] = nums1[i1++];
            }else {
                mergeNums[i++] = nums2[i2++];
            }
        }
        while (i1<len1){
            mergeNums[i++] = nums1[i1++];
        }
        while (i2<len2){
            mergeNums[i++] = nums2[i2++];
        }
        int mid = (allLen)/2;
        if(allLen %2 == 0){
            return (mergeNums[mid]+mergeNums[mid-1])/2.0;
        }
        return mergeNums[mid];
    }

    public static void main(String[] args) {
        Main4 main4 = new Main4();
        int[] arr ={1,3};
        int[] arr1 ={2,4};
        System.out.println(main4.findMedianSortedArrays(arr,arr1));
    }

}
