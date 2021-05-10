package com.wuss.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * @create: 2021/05/10 08:50
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 * 872. 叶子相似的树
 */
public class Main872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        vist(root1,list1);
        vist(root2,list2);
        if (list1.size()!=list2.size()){
            return false;
        }
        int len = list1.size();
        for (int i=0;i<len;i++){
            if (list1.get(i).equals(list2.get(i))){
                continue;
            }
            return false;
        }
        return true;
    }


    private void vist(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }
        vist(node.left,list);
        if (node.left == null && node.right == null){
            list.add(node.val);
        }
        vist(node.right,list);
    }

}
