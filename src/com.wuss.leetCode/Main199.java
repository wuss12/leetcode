package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 */
public class Main199 {


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, 0, result);
        return result;
    }

    public void dfs(TreeNode root, int n, List<Integer> result){
        if(root == null){
            return;
        }
        if(result.size() == n){
            result.add(root.val);
        }
        dfs(root.right, n+1, result);
        dfs(root.left, n+1, result);
    }

    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        TreeNode temp = root;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(temp);
        TreeNode pop = null;
        while (true){
            if (!stack1.isEmpty()){
                pop = stack1.pop();
                list.add(pop.val);
                if (pop.right != null){
                    stack2.push(pop.right);
                }
                if (pop.left != null){
                    stack2.push(pop.left);
                }
            }

            while (!stack1.isEmpty()){
                pop = stack1.pop();
                if (pop.right != null){
                    stack2.push(pop.right);
                }
                if (pop.left != null){
                    stack2.push(pop.left);
                }

            }
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            if (stack1.isEmpty() && stack2.isEmpty()){
                break;
            }
        }
        return list;

    }



}
