package com.wuss.leetCode;

import java.util.ArrayList;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = 'ABCCED', 返回 true
 * 给定 word = 'SEE', 返回 true
 * 给定 word = 'ABCB', 返回 false
 *
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * 通过次数52,981提交次数128,500
 */
public class Main79 {
     int r,c;
     char[][] board;
     String word;
     boolean[][] flag;
      boolean exist(char[][] board, String word) {
         r = board.length;
        if (r == 0 || word.isEmpty()){
            return false;
        }
        c = board[0].length;
        this.word = word;
        this.board = board;
        flag = new boolean[r][c];
        char ch = word.charAt(0);
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                if (board[i][j]!= ch){
                    continue;
                }
                if (exist(i,j,0)){
                    return true;
                }

            }
        }
        return false;
    }

     int[][] dirct=new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
      boolean checkArea(int x,int y){
        if (x<0 || x>= r || y <0 || y>= c){
            return false;
        }
        return true;
    }

    boolean exist(int x,int y,int start){
        char ch = word.charAt(start);
        if (ch != board[x][y]){
            return false;
        }
        if (start == word.length() - 1) {
            return true;
        }
        flag[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int newX = x + dirct[k][0];
            int newY = y + dirct[k][1];
            if (checkArea(newX, newY) && !flag[newX][newY]) {
                if (exist(newX, newY, start + 1)) {
                    return true;
                }
            }
        }
        flag[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
          Main79 main79= new Main79();
//        char[][] chars = new char[][]{{'A','B','C','E'}, {'S','F','E','S'}, {'A','D','E','E'}};
//        String str ="ABCESEEEFS";
        char[][] chars = {{'a', 'b'},{'c','d'}};
        String str = "acdb";
//        char[][] chars = new char[][]{{'a'}};
//        String str ="a";
        boolean exist = main79.exist(chars, str);
        System.out.println(exist);
//        System.out.println(chars == chars.clone());

    }
}
