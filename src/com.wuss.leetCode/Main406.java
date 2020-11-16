package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Main406 {
    public static int[][] reconstructQueue(int[][] people) {
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });
        disPlay(people);
        int len = people.length;
        for (int i = 0; i < len; i++) {
            result.add(people[i][1], people[i]);
        }
        return result.toArray(new int[0][]);
    }


    private static void disPlay(int[][] pe){
        Stream.of(pe).peek(e-> System.out.print("["+e[0]+","+e[1]+"],")).count();
        System.out.println();
    }

    public static void main(String[] args) {
//        int[][] arrs ={{7,0}, {4,4}, {7,1}, {6,1}, {5,2}, {5,0}};
        int[][] arrs ={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        disPlay(arrs);
        int[][] ints = reconstructQueue(arrs);
        disPlay(ints);

    }
}
