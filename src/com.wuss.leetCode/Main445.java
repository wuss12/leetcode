package com.wuss.leetCode;

import java.util.Stack;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 */
public class Main445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        ListNode tempNode = l1;
        while (tempNode != null){
            stack1.push(tempNode);
            tempNode = tempNode.next;
        }
        tempNode = l2;
        while (tempNode != null){
            stack2.push(tempNode);
            tempNode = tempNode.next;
        }
        int value = 0;
        int a,b;
        while (!stack1.isEmpty() || !stack2.isEmpty() || value > 0){
           a = stack1.isEmpty() ? 0:stack1.pop().val;
           b = stack2.isEmpty() ? 0:stack2.pop().val;
           value = a+b + value;
           stack3.push(value%10);
           value = value /10;
        }

        ListNode result = null,parent = null;
        while (!stack3.isEmpty()){
            value = stack3.pop();
            tempNode = new ListNode(value);
            if (result == null){
                result = tempNode;
            }else {
                parent.next = tempNode;
            }
            parent = tempNode;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(1/10);
    }
}
