package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= n <= 5 * 106
 */
public class Main204 {
    public int countPrimes(int n) {
        if (n<= 2){
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        list.add(2);
        int size = 1;
        for (int i=3;i<n;i=i+2){
            Iterator<Integer> iterator = list.iterator();
            boolean ji = true;
            int end = (int) Math.sqrt(i)+1;
            while (iterator.hasNext()){
                int value = iterator.next();
                if (value>end){
                    break;
                }
                if (i% value == 0){
                    ji = false;
                    break;
                }
            }
            if (ji){
                list.add(i);
                size++;

            }

        }

        return size;

    }
}
