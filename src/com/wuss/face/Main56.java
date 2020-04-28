package com.wuss.face;

import com.wuss.leetCode.TestMain;

import java.util.HashMap;
import java.util.Map;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 面试题56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 *
 * 限制：
 *
 * 2 <= nums <= 10000
 */
public class Main56 {
//    public int[] singleNumbers1(int[] nums) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int v : nums){
//            if (map.getOrDefault(v, 0) == 1){
//                map.remove(v);
//                continue;
//            }
//            map.put(v,1);
//        }
//        if (map.size() == 0){
//            return new int[0];
//        }
//        int[] arr = new int[2];
//        int index = 0;
//        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
//            arr[index++] = entry.getKey();
//            if (index == 2){
//                break;
//            }
//        }
//        return arr;
//    }

    // 自己寻找最右边 1 的位置
    public int[] singleNumbers(int[] nums) {
       int len = nums.length;
       if (len < 2){
           return new int[0];
       }

       int xor = 0;
       for (int num : nums){
           xor ^= num;
       }
       //寻找两个数从右往左找在哪一位上不同
        int r = 1;
       while ((r & xor) == 0){
           r = (r <<1);
       }
       int[] arr = new int[2];
       for (int v : nums){
           if ((r & v) == 0){
               arr[0]^= v;
           }else {
               arr[1] ^= v;
           }
       }
       return arr;
    }






    public static void main(String[] args) {
        TestMain.testMethod(Main56.class);
    }
}
