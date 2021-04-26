package com.wuss.leetCode;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * @create: 2021/04/26 08:42
 * 1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 *
 *
 * 示例 1：
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 *
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 *
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 */
public class Main1011 {

    public static void main(String[] args) {
        int[] arrs ={1,2,3,1,1};
        int d = 1;
        System.out.println(shipWithinDays(arrs,d));
    }

//    public static int shipWithinDays(int[] weights, int D) {
//        // 确定二分查找左右边界
//        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
//        while (left < right) {
//            int mid = (left + right) / 2;
//            // need 为需要运送的天数
//            // cur 为当前这一天已经运送的包裹重量之和
//            int need = 1, cur = 0;
//            for (int weight : weights) {
//                if (cur + weight > mid) {
//                    ++need;
//                    cur = 0;
//                }
//                cur += weight;
//            }
//            if (need <= D) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }



    public static int shipWithinDays(int[] weights, int D) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        int mid = 0;
        while (l<r){
            mid = (l+r)>>1;
            int need = 1,sum = 0;
            for (int weight : weights) {
                if (sum + weight> mid){
                    need++;
                    sum = 0;
                }
                sum += weight;
            }
            if (need<= D){
                r = mid;
            }else {
                l = mid+1;
            }
        }
        return l;
    }

//    public static int shipWithinDays(int[] weights, int D) {
//        int sum = 0;
//        for (int arr : weights) {
//            sum += arr;
//        }
//        int avg = (sum+D-1)/D;
//
//        for (int i= avg;i<=sum;i++){
//            int d = 0;
//            int sum0 = 0;
//            for (int weight : weights) {
//                if (weight>i){
//                    d = sum;
//                    break;
//                }
//                if (sum0 + weight <= i){
//                    sum0 += weight;
//                    continue;
//                }
//                d++;
//                sum0 = weight;
//            }
//            if (d <= D-1){
//                return i;
//            }
//        }
//        return 0;
//    }
}
