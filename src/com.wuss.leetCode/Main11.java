package com.wuss.leetCode;

public class Main11 {

    public int maxArea(int[] height) {
        int max = 0;
        int cal;
        int a = 0;
        for (int i=0;i<height.length;i++){
            a = height[i];
            for (int j=height.length -1;j>i;j--){
                cal = Math.min(a,height[j])*(j-i);
                max = Math.max(max,cal);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main10.class);
    }
}
