package com.wuss.leetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class Main117 {
    public Node connect(Node root) {
        if (root== null){
            return null;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.add(root);
        Node temp,pre;
        while (!deque.isEmpty()){
            int size = deque.size();
            pre = null;
            for (int i=0;i<size;i++){
                temp = deque.pollFirst();
                if (pre != null){
                    pre.next = temp;
                }
                pre = temp;
                if (temp.left!=null){
                    deque.add(temp.left);
                }
                if (temp.right!=null){
                    deque.add(temp.right);
                }
            }
        }
        return root;
    }
}
