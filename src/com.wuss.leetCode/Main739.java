package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 739. 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class Main739 {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] arr = new int[len];
        dailyTemperatures(T,arr,0,len);
        return arr;
    }

    private void dailyTemperatures(int[] T,int[] arr,int index,int end) {
        if (index == end){
            return;
        }
        int temp = T[index];
        arr[index] = 0;
        for (int i=index+1;i< end;i++){
            if (T[i] > temp){
                arr[index] = i-index;
                break;
            }
        }
        dailyTemperatures(T,arr,index+1,end);
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main739.class);
    }
}