package com.wuss.leetCode;

import java.util.Stack;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Main92 {
//    public ListNode reverseBetween(ListNode head, int m, int n) {
//        if (m == n || head == null){
//            return head;
//        }
//        ListNode preM,preN;
//        ListNode root = new ListNode(0);
//        root.next = head;
//        Stack<ListNode> stack = new Stack<>();
//        ListNode pre;
//        ListNode cur;
//        pre = root;
//        cur= head;
//        int i=1;
//        while (cur!=null){
//            if (i<m){
//                pre = pre.next;
//            }
//            if (i>= m && i<= n){
//                stack.push(cur);
//            }
//            if (i==n){
//                break;
//            }
//            cur = cur.next;
//            i++;
//
//        }
//        ListNode end = cur.next;
//        while (!stack.isEmpty()){
//            pre.next = stack.pop();
//            pre = pre.next;
//        }
//        pre.next = end;
//        return root.next;
//    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null) {
            return head;
        }
        ListNode preM, preN;
        ListNode root = new ListNode(0);
        root.next = head;
        Stack<ListNode> stack = new Stack<>();
        ListNode pre;
        ListNode cur;
        pre = root;
        cur = head;
        int i = 1;
        while (cur != null) {
            if (i < m) {
                pre = pre.next;
            }
            if (i >= m && i <= n) {
                stack.push(cur);
            }
            if (i == n) {
                break;
            }
            cur = cur.next;
            i++;

        }
        ListNode end = cur.next;
        while (!stack.isEmpty()) {
            pre.next = stack.pop();
            pre = pre.next;
        }
        pre.next = end;
        return root.next;
    }

}
