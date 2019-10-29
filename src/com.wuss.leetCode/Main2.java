package com.wuss.leetCode;

import java.math.BigInteger;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       if(l1 == null  ){
           return l2;
       }
       if(l2 == null ){
           return l1;
       }
       int  jin = 0;
       int result = 0;
       ListNode returnNode = null,tempNode = null;
       while (l1!= null && l2 != null){
           result = l1.val + l2.val + jin;
           if(result > 9){
               result = result - 10;
               jin = 1;
           }else {
               jin = 0;
           }
           l1 = l1.next;
           l2 = l2.next;
           if(returnNode == null){
               returnNode = new ListNode(result);
               tempNode = returnNode;
           }else {
               tempNode.next = new ListNode(result);
               tempNode = tempNode.next;
           }

       }
       while (l1 != null){
           result = l1.val + jin;
           if(result > 9){
               result = result - 10;
               jin = 1;
           }else {
               jin = 0;
           }
           if(returnNode == null){
               returnNode = new ListNode(result);
               tempNode = returnNode;
           }else {
               tempNode.next = new ListNode(result);
               tempNode = tempNode.next;
           }
           l1 = l1.next;
       }

        while (l2 != null){
            result = l2.val + jin;
            if(result > 9){
                result = result - 10;
                jin = 1;
            }else {
                jin = 0;
            }
            if(returnNode == null){
                returnNode = new ListNode(result);
                tempNode = returnNode;
            }else {
                tempNode.next = new ListNode(result);
                tempNode = tempNode.next;
            }
            l2 = l2.next;
        }
        if(jin == 1){
            tempNode.next = new ListNode(jin);
            tempNode = tempNode.next;
        }
        return  returnNode;
    }
}
