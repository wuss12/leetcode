package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 */
public class Main119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list1 = new ArrayList<>(rowIndex+1);
        List<Integer> list2 = new ArrayList<>(rowIndex+1);
        List<Integer> one =null;
        List<Integer> two = new ArrayList<>(0);
        boolean list1Flag = true;
        for (int i=0;i<=rowIndex;i++){
            if (list1Flag){
                one = list1;
                two = list2;
            }else {
                one = list2;
                two = list1;
            }
            list1Flag = !list1Flag;
            if (i ==0){
                one.add(1);
                continue;
            }
            int sum = 0;
            one.clear();
            for (int j=0;j<=i-1;j++){
                sum = sum +two.get(j);
                one.add(sum);
                sum = two.get(j);
            }
            one.add(1);
        }
        return one;
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main119.class);
    }
}
