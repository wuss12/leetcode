package com.wuss.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 137. 只出现一次的数字 II
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 */
public class Main137 {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>((int)(len*1.4)+1);
        for(int v : nums){
            int num = map.getOrDefault(v,0);
            map.put(v,num+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 0;
    }
}
