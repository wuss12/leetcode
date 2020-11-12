package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 529. 扫雷游戏
 * 让我们一起来玩扫雷游戏！
 *
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 *
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 *
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *
 *
 * 示例 1：
 *
 * 输入:
 *
 * [['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'M', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E']]
 *
 * Click : [3,0]
 *
 * 输出:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * 解释:
 *
 * 示例 2：
 *
 * 输入:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * Click : [1,2]
 *
 * 输出:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'X', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 */
public class Main529 {

    /**
     * 'M' 代表一个未挖出的地雷
     * 'E' 代表一个未挖出的空方块
     * 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块
     *  数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻
     *  X' 则表示一个已挖出的地雷。
     * @param board
     * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'
     * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露
     * 3.如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
     * 如果在此次点击中，若无更多方块可被揭露，则返回面板
     * @param click
     * @return
     */

    static  int c;
    static  int r;
    public char[][] updateBoard(char[][] board, int[] click) {
        c = board.length;
        r = board[0].length;

        int x = click[0];
        int y = click[1];
        if (x< 0 || x>= c || y<0 || y>=r){
            return board;
        }
        char ch = board[x][y];
        if (ch != 'E' && ch != 'M'){
            return board;
        }
        if (ch == 'M'){
            board[x][y] = 'X';
            return board;
        }
        int countM = countM(board,x,y);
        if (countM == 0){
            board[x][y] ='B';
            for (int i=-1;i<2;i++){
                for (int j=-1;j<2;j++){
                    if (i == 0 && j == 0){
                        continue;
                    }
                    click[0] = x+i;
                    click[1] = y+j;
                    updateBoard(board,click);
                }
            }

        }else {
            board[x][y] = (char) (countM +'0');
        }
        return board;
    }

    private static int countM(char[][] board,int x,int y){

        int count = 0;
        char ch;
        for (int i=x-1;i<=x+1 ;i++){
            if (i <0 || i >= c){
                continue;
            }
            for (int j= y-1;j<= y+1  ;j++){
                if (j < 0 || j >= r){
                    continue;
                }
                ch = board[i][j];
                if (ch == 'M'){
                    count++;
                }
            }
        }
        return count;
    }

}
