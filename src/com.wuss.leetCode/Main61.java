package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Main61 {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        if (head == null || k == 0){
            return head;
        }
        while (temp != null){
            len++;
            temp = temp.next;
        }
        k = k % len;
        if (k == 0){
            return head;
        }

        ListNode pre = head,current = null;
        for (int i=0;i<k;i++){
            pre=pre.next;
        }
        current = head;
        while (pre.next!= null){
            pre = pre.next;
            current = current.next;
        }
        pre.next = head;
        head = current.next;
        current.next = null;
        return head;

    }

    public static void main(String[] args) {
        ListNode list = ListNode.getList(1, 2, 3, 4, 5);
        Main61 main61 = new Main61();
        ListNode result = main61.rotateRight(list,2);
        ListNode.show(result);
    }
}
