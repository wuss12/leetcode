package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Main86 {
    public ListNode partition1(ListNode head, int x) {
        ListNode root = new ListNode(0);
        ListNode temp = head;
        root.next = head;
        ListNode parent = root;
        while (temp != null){
            while (parent.next!= null && parent.next.val < x){
                parent = parent.next;
                if (parent.next == null){
                    return root.next;
                }

            }
            temp = parent;

            while (temp.next != null && temp.next.val>=x){
                temp = temp.next;
                if (temp.next == null){
                    return root.next;
                }
            }
            ListNode node = parent.next;
            parent.next = temp.next;
            if (temp.next!= null){
                temp.next = temp.next.next;
                parent.next.next = node;
            }
            parent = parent.next;



        }
        return root.next;

    }

    public ListNode partition(ListNode head, int x) {
      ListNode pre = new ListNode(0);
      ListNode after = new ListNode(0);
      ListNode temp = head;
      ListNode preTemp = pre;
      ListNode afterTemp = after;
      while (temp != null){

          if (temp.val < x){
              preTemp.next = temp;
              preTemp = preTemp.next;
          }else {
              afterTemp.next = temp;
              afterTemp = afterTemp.next;
          }
          temp = temp.next;
      }
      preTemp.next = after.next;
      afterTemp.next = null;
      return pre.next;

    }

    public static void main(String[] args) {
        Main86 main86 = new Main86();
        ListNode head = ListNode.getList(1,4,3,2,5,2);
        ListNode result = main86.partition(head,1);
        ListNode.show(result);
    }
}
