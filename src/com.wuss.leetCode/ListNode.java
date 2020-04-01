package com.wuss.leetCode;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) {
        val = x;
    }
    public static void show(ListNode node){
        ListNode temp = node;
        while (temp!=null){
            if(temp.next != null){
                System.out.print(temp.val+"->");
            }else {
                System.out.print(temp.val);
            }

            temp = temp.next;
        }
        System.out.println();
    }
    public static ListNode getList(int ... arr){
        ListNode root;
        int len = arr.length;
        if(len == 0){
            return null;
        }
        root = new ListNode(arr[0]);
        ListNode temp = root;
        ListNode newNode = null;
        for (int i=1;i<len;i++){
            newNode = new ListNode(arr[i]);
            temp.next = newNode;
            temp = temp.next;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6};
        ListNode root  = getList(arr);
        show(root);
    }

    @Override
    public String toString() {
        show(this);
        return super.toString();
    }
}
