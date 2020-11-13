package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class Main328 {
    //method one
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    //method two
    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode jiNode = null,ouNode = null;
        ListNode temp = head;
        ListNode jiStart = head.next;
        int i=0;
        while (temp != null){
            if (i%2 == 0){
                if (ouNode == null){
                    ouNode = temp;
                }else {
                    ouNode.next = temp;
                    ouNode = ouNode.next;
                }
            }else {
                if (jiNode == null){
                    jiNode = temp;
                }else {
                    jiNode.next = temp;
                    jiNode = jiNode.next;
                }

            }
            i++;
            temp = temp.next;
        }
        ouNode.next = jiStart;
        jiNode.next = null;
        return head;
    }

    //method three

    public ListNode oddEvenList3(ListNode head) {
        if (head == null||head.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode node = oddEvenList(head, evenHead);
        node.next = evenHead;
        return head;
    }

    public ListNode oddEvenList(ListNode odd,ListNode even){
        if (even == null || odd == null){
            return odd;
        }
        odd.next = even.next;
        if (odd.next == null){
            return odd;
        }
        odd = odd.next;

        even.next = odd.next;
        even = even.next;
        return oddEvenList(odd,even);
    }
}
