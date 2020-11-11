package com.wuss.leetCode;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main31 {
    public  void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len <= 1){
            return;
        }
        boolean sortedFlag = true;
        for (int i=1;i<len;i++){
            if (nums[i-1]< nums[i]){
                sortedFlag = false;
                break;
            }
        }
        if (sortedFlag){
            for (int i=0,j=len-1;i<j;i++,j--){
                swap(nums,i,j);
            }
            return;
        }
        int index = 0;
        int min = 0;
        int tempValue = 0;
        for (int i = len-2;i>=0;i--){
            tempValue = nums[i];
            index = i;
            min = Integer.MAX_VALUE;
            for (int j= len-1;j>= i;j--){
                if (nums[j] > tempValue && nums[j] < min){
                    index = j;
                    min = nums[j];
                }
            }
            if (nums[index] > tempValue){
                swap(nums,index,i);
                Arrays.sort(nums,i+1,len);
                return;
            }
        }

    }
    private  void swap(int[] nums,int left,int right){

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }





    public void nextPermutation1(int[] nums) {
        boolean desFlag = true;
        int len = nums.length;
        for (int i=1;i<len;i++){
            if (nums[i] > nums[i-1]){
                desFlag = false;
                break;
            }
        }
        if (desFlag){
            Arrays.sort(nums);
            return;
        }
        for (int i=len-2;i>=0;i--){
            Integer min = null;
            int index = 0;
            for (int j=i+1;j<len;j++){
                if (nums[j]> nums[i] ){
                    if (min == null){
                        min = nums[j];
                        index = j;
                    }else {
                        if (min > nums[j]){
                            index =j;
                            min = nums[j];
                        }
                    }

                }
            }
            if (min == null){
                continue;
            }
            min = nums[index];
            nums[index] = nums[i];
            nums[i] = min;
            Arrays.sort(nums,i+1,len);

            break;
        }
    }
}
