package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class Main118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        if(numRows == 0){
            return result;
        }
        int a = 1;
        List<Integer> list = new ArrayList<>();
        list.add(a);
        result.add(list);
        for (int i=1;i< numRows;i++){
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = result.get(i - 1);
            int pre = 0;
            for (int v:list2){
                list1.add(pre+v);
                pre = v;
            }
            list1.add(pre);
            result.add(list1);
        }
        return result;

    }

    public static void main(String[] args) {
        TestMain.testMethod(Main118.class);
    }
}
