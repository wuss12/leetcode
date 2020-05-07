package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program leetcode
 * @description: 572. 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1:
 * 给定的树 s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 2:
 * 给定的树 s：
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 */
public class Main572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Boolean x = checkBefore(s, t);
        if (x != null)
            return x;
        boolean result = false;
        if (s.val == t.val){
            result = result || isSubtree1(s,t);
        }
        if (result){
            return true;
        }
        result = result || isSubtree(s.left,t)|| isSubtree(s.right,t);
        return result;

    }

    private Boolean checkBefore(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s != null && t == null || s == null && t != null) {
            return false;
        }
        return null;
    }

    private boolean isSubtree1(TreeNode s,TreeNode t){
        Boolean x = checkBefore(s, t);
        if (x != null)
            return x;
        if (s.val != t.val){
            return false;
        }
        return isSubtree1(s.left,t.left) && isSubtree1(s.right,t.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode11 = new TreeNode(1);
        treeNode.left = treeNode1;
        Main572 main572 = new Main572();
        System.out.println(main572.isSubtree(treeNode,treeNode11));
    }


}
