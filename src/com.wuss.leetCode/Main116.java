package com.wuss.leetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 116. 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
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
 * 示例：
 */
public class Main116 {
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

    public static void main(String[] args) {
        Node[] nodes = new Node[7];
        for (int i=1;i<=7;i++){
            nodes[i-1] = new Node(i,null,null,null);
        }
        nodes[0].left=nodes[1];
        nodes[0].right=nodes[2];

        nodes[1].left=nodes[3];
        nodes[1].right=nodes[4];

        nodes[2].left=nodes[5];
        nodes[2].right=nodes[6];
        Main116 main116 = new Main116();
        Node connect = main116.connect(nodes[0]);
        System.out.println(connect);


    }

}
