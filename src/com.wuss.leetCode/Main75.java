package com.wuss.leetCode;

import sun.applet.Main;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class Main75 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return;
        }
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i= 0;i<len;i++){
            if (nums[i] == 0){
                count0++;
                continue;
            }
            if (nums[i] == 1){
                count1++;
                continue;
            }
            count2++;
        }
        Arrays.fill(nums,0,count0,0);
        Arrays.fill(nums,count0,count0+count1,1);
        Arrays.fill(nums,len - count2,len,2);
    }

    public static void main(String[] args) {
        Main75 main75 = new Main75();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] split = s.split(",");
            int[] arr = new int[split.length];
            int i = 0;
            for (String str : split) {
                arr[i++] = Integer.valueOf(str);

            }
            main75.sortColors(arr);
            System.out.println(Arrays.toString(arr));

        }
    }
}