package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 1095. 山脉数组中查找目标值
 * （这是一个 交互式问题 ）
 *
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 *
 * 如果不存在这样的下标 index，就请返回 -1。
 *
 *
 *
 * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 *
 * 首先，A.length >= 3
 *
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 *
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 *
 * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
 *
 * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
 * MountainArray.length() - 会返回该数组的长度
 *
 *
 * 注意：
 *
 * 对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消
 * 示例 1：
 *
 * 输入：array = [1,2,3,4,5,3,1], target = 3
 * 输出：2
 * 解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
 * 示例 2：
 *
 * 输入：array = [0,1,2,4,2,1], target = 3
 * 输出：-1
 * 解释：3 在数组中没有出现，返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-in-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 3 <= mountain_arr.length() <= 10000
 * 0 <= target <= 10^9
 * 0 <= mountain_arr.get(index) <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-in-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main1095 {
    static int[] arr = new int[10000];
    static Integer len;
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int left = 0;int right = len-1;
        int mid ;

        int valueM,valueM1;
        int result = -1;

        while (left <= right){
            mid =(left+right)>>1;
            valueM = mountainArr.get(mid);
            if ( valueM == target){
                result = mid;
            }
            if (left == right){
                return result;
            }
            valueM1 = mountainArr.get(mid+1);
            //前一部分升序
            if (valueM < valueM1){
                int bifind = bifind(target, mountainArr, left, mid + 1, true);
                if (bifind >=0){
                    return bifind;
                }
                left = mid+2;
            }else {
                int bifind = bifind(target, mountainArr,  mid + 1,right, false);
                if (bifind >=0){
                    if (result == -1){
                        result = bifind;
                    }else {
                        result = Math.min(result,bifind);
                    }

                }
                right = mid -1;
            }

        }
        return result;
    }

    //aes : true 升序 ,fale 降序
    public static int bifind(int target ,MountainArray mountainArr,int start,int end,boolean aes){
        int startVale = mountainArr.get(start);
        int endValue = mountainArr.get(end);
        if (aes){
            if (startVale > target || target >endValue){
                return -1;
            }
        }else {
            if (startVale < target || target  < endValue){
                return -1;
            }
        }
        if (startVale == target){
            return start;
        }
        if (endValue == target){
            return end;
        }
        int mid = 0;
        int midValue = 0;
        while (start <=  end){
            mid = (start + end) >>1;
            midValue = mountainArr.get(mid);
            if (midValue == target){
                return mid;
            }
            if (aes){
                if (midValue < target){
                    start = mid+1;
                }else {
                    end = mid -1;
                }
            }else {
                if (midValue > target){
                    start = mid+1;
                }else {
                    end = mid -1;
                }
            }
        }
        return -1;
    }

    interface MountainArray {
     default  int get(int index){
         return arr[index];
     }
      default int length() {
         return len;
      }
  }

    public static void main(String[] args) {
        int[] ar = {1,5,2};
        len = ar.length;
        arr = ar;
        int target = 2;
        System.out.println(findInMountainArray(target, new MountainArray() {

        }));

    }
}
