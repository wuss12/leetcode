package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main45 {
    public static int jump(int[] nums) {
       int ans = 0;
       int start = 0;
       int end = 1;
       while (end < nums.length){
           int max= 0;
           for (int i= start;i<end;i++){
               max = Math.max(max,i+nums[i]);
           }
           start = end;
           end = max+1;
           ans++;
       }
       return ans;

    }
    public static int jump1(int[] nums) {
        int ans = 0;
        int end = 0;
        int maxPos = 0;
        for (int i = 0; i < nums.length - 1; i++)
        {
            maxPos = Math.max(nums[i] + i, maxPos);
            if (i == end)
            {
                end = maxPos;
                ans++;
            }
        }
        return ans;

    }





}
