package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @program leetcode
 * @description:
 * @author: wuss
 *
 * 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
public class Main501 {
    boolean start = false;
    int preValue;
    int max = 0;
    int curNum = 0;
    List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        dfs(root);
        int size =result.size();
        if (size == 0){
            result.add(preValue);

        }else {
            int lastValue = result.get(result.size() -1);
            if (lastValue != preValue){
                if (curNum > max){
                    result.clear();
                }
                if (curNum>= max){
                    result.add(preValue);

                }
            }
        }
       int len = result.size();
        int[] arr = new int[len];
        for (int i=0;i<len;i++){
            arr[i] = result.get(i);
        }
        return arr;
    }

    public void dfs(TreeNode root) {

        if (root.left != null) {
            dfs(root.left);
        }
        int nowValue = root.val;
        if (!start) {
            start = true;
            preValue = nowValue;
        }
        if (preValue == nowValue) {
            curNum++;
        }
        if (preValue != nowValue) {
            if (curNum >= max) {
                if (curNum > max) {
                    result.clear();
                }
                result.add(preValue);
                max = curNum;
            }

            preValue = nowValue;
            curNum = 1;

        }

        if (root.right != null) {
            dfs(root.right);
        }


    }







    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode(3,2,4,1,3,null,5);
        Main501 main501 = new Main501();
        int[] mode = main501.findMode(treeNode);
        System.out.println(Arrays.toString(mode));
    }
}
