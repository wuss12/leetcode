package com.wuss.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program leetcode
 * @description:a
 * @author: wuss@wjs.com
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main105 {
   int preIndex = 0;
   int[] preorder;
   Map<Integer,Integer> inorderMap = new HashMap<>();


    public TreeNode buildTree(int[] preorder, int[] inorder) {
     int len = inorder.length;
     if (len == 0){
         return null;
     }
     this.preorder = preorder;
     int index = 0;
     for (Integer v : inorder){
         inorderMap.put(v,index++);
     }
     return helper(0,inorder.length);
    }

    public TreeNode helper(int left,int right){
        if (left == right){
            return null;
        }
        Integer rootValue = preorder[preIndex];
        TreeNode root = new TreeNode(rootValue);
        int indexOfRoot = inorderMap.get(rootValue);
        preIndex++;
        root.left = helper(left,indexOfRoot);
        root.right = helper(indexOfRoot+1,right);
        return root;

    }




    public static void main(String[] args) {
        Main105 main105 = new Main105();
        int[] preorder={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};
        TreeNode treeNode = main105.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

}
