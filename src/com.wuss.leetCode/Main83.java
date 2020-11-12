package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class Main83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode n1 = root,n2 = head;
        while (n1.next!= null){
            while (n2.next!= null && n1.next.val == n2.next.val){
                n2 = n2.next;
            }
            n1.next = n2;
            n1 = n2;
            n2 = n2.next;

        }
        return root.next;
    }

    public static void main(String[] args) {
        TestMain.testMethod(Main83.class);
    }
}
