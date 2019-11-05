package com.wuss.leetCode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Main19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = head;
        ListNode temp = root;
        ListNode parent = null,delNode= null;
        int i =0;
        while (i++ < n){
            temp = temp.next;
        }
        parent = head;
       if(temp == null){
           parent = parent.next;
           return parent;
       }
       delNode = parent.next;
        temp = temp.next;
        while (temp != null){
            delNode=delNode.next;
            temp = temp.next;
            parent=parent.next;
        }


        parent.next = delNode.next;
        return root;

    }

    public static void main(String[] args) {
        TestMain.testMethod(Main19.class);
    }
}
