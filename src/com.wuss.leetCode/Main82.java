package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class Main82 {
    public ListNode deleteDuplicates1(ListNode head) {
        if (head==null|| head.next == null) {
            return head;
        }
        ListNode parent = head;
        ListNode current = parent.next;
        if (parent.val == current.val){
            while (current!= null && parent.val == current.val){
                current = current.next;
            }
            return deleteDuplicates1(current);
        }else {
            while (current!= null && current.next!=null){
                if (current.val!=current.next.val){
                    parent = current;
                    current = current.next;
                }else {
                    while (current.next!= null && current.val==current.next.val){
                        current = current.next;
                    }
                    current = current.next;
                    parent.next = deleteDuplicates1(current);

                }
            }
        }
        return head;
    }
    public ListNode deleteDuplicates(ListNode head) {
       ListNode root = new ListNode(0);
       root.next = head;
       ListNode parent = root;
       ListNode current = head;
       int repet = 0;
       while (parent.next != null){
           while (current.next != null && parent.next.val == current.next.val){
               current = current.next;
               repet = 1;
           }
           if (repet == 1){
               parent.next = current.next;
               repet = 0;
           }else {
               parent = parent.next;
           }
           current = current.next;
       }
       return root.next;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 3, 4, 4, 5};
        int[] arr = new int[]{1,2,2};
        ListNode list = ListNode.getList(arr);
        ListNode.show(list);
        Main82 main82 = new Main82();
        ListNode node = main82.deleteDuplicates(list);
        ListNode.show(node);
    }


}
