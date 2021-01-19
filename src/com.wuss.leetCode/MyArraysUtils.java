package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * 数组类型工具类
 */
public class MyArraysUtils {

    /**
     * [[0,0],[2,2],[3,10],[5,2],[7,0]]  --> 数组
     * @param str
     * @return
     */
    public static int[][] getArrays(String str){
        str = str.replace("[[","").replace("]]","");
        String[] arr = str.split("\\],\\[");
        int[][] result = new int[arr.length][];
        int i=0;
        for (String s:arr){
            String[] tempArr = s.split(",");
            result[i]= new int[tempArr.length];
            int j=0;
            for (String ts:tempArr){
                result[i][j++] = Integer.valueOf(ts);
            }
            i++;
        }
        return result;
    }


    /**
     *[["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/accounts-merge
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param str
     * @return
     */
    public static List<List<String>> getLists(String str){
        str = str.replace("[[","").replace("]]","");
//        String[] arr = str.split("\\],\\[");
        String[] arr = str.split("\\], \\[");
        List<List<String>> lists = new ArrayList<>();
        for (String s : arr){
            lists.add(new ArrayList<>(Arrays.asList(s)));
        }
        return lists;
    }

    public static void main(String[] args) {
        testGetArray();
        testGetLists();
    }

    private static void testGetLists() {
        String str ="[[\"John\", \"johnsmith@mail.com\", \"john00@mail.com\"], [\"John\", \"johnnybravo@mail.com\"], [\"John\", \"johnsmith@mail.com\", \"john_newyork@mail.com\"], [\"Mary\", \"mary@mail.com\"]]";
        List<List<String>> lists = getLists(str);
        System.out.println(lists);
    }

    private static void testGetArray() {
        String str ="[[0,0],[2,2],[3,10],[5,2],[7,0]]";
        int[][] arrays = getArrays(str);
        for (int[] arr : arrays){
            System.out.println(Arrays.toString(arr));
        }
    }
}
