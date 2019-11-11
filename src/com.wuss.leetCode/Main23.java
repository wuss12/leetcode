package com.wuss.leetCode;

import java.util.Arrays;
import java.util.Random;

public class Main23 {

    private static int[] merge(int[] arr1,int[] arr2){
        int len = arr1.length+arr2.length;
        int[] arr = new int[len];
        int i=0,j=0,k=0;
        while (i<arr1.length && j < arr2.length){
            if(arr1[i]<arr2[j]){
                arr[k++] = arr1[i++];
            }else {
                arr[k++] = arr2[j++];
            }
        }
        while (i< arr1.length){
            arr[k++] = arr1[i++];
        }
        while (j<arr2.length){
            arr[k++] = arr2[j++];
        }
        return arr;
    }


    private static int[]  sort(int[] arr,int left,int right){
        int mid;
        if(left == right){
            return new int[]{arr[left]};
        }
        if(left > right){
            return new int[]{};
        }
        mid = (left + right)/2;
        int[] arr1 = sort(arr,left,mid);
        int[] arr2 = sort(arr,mid+1,right);
        return merge(arr1,arr2);
    }

    public static void main(String[] args) {
        int [] arr = new int[100];
        Random random = new Random();
        for (int i=0;i<100;i++){
            arr[i] = random.nextInt(100);
        }
        int[] arr1 = Arrays.copyOf(arr,100);
        int[] re = sort(arr,0,arr.length-1);

        Arrays.sort(arr1);
        System.out.println(Arrays.toString(re));
//        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.equals(re,arr1));
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return sort(lists,0,lists.length-1);
    }

    private static ListNode sort(ListNode[] nodes,int left,int right){
        if(left == right){
            return nodes[left];
        }
        int mid = (left + right) >> 1;
        ListNode lNode = sort(nodes, left, mid);
        ListNode rNode = sort(nodes, mid+1, right);
        return mergeTwoLists(lNode,rNode);

    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l2 == null){
            return l1;
        }
        if(l1 == null){
            return l2;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }


}
