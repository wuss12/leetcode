package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */
public class Main200 {
    static int num =0;
    int r = 0;
    int c = 0;
    char[][] grid;
    public int numIslands(char[][] grid) {
        num = 0;
        r = grid.length;
        if (r ==0){
            return 0;
        }
        c = grid[0].length;
        this.grid = grid;
        for (int i=0;i< r;i++){
            for (int j = 0;j< c;j++){
                if (grid[i][j] =='1'){
                    grid[i][j] = '0';
                    numIslands(i,j);
                    num++;
                }
            }
        }
        return num;
    }
    private void numIslands(int x,int y) {
        if (x+1< r){
            if (grid[x+1][y] == '1'){
                grid[x+1][y] = '0';
                numIslands(x+1,y);
            }
        }
        if (x-1>=0){
            if (grid[x-1][y] == '1'){
                grid[x-1][y] = '0';
                numIslands(x-1,y);
            }
        }
        if (y+1 < c){
            if (grid[x][y+1] == '1'){
                grid[x][y+1] = '0';
                numIslands(x,y+1);
            }
        }
        if (y-1 >= 0){
            if (grid[x][y-1] == '1'){
                grid[x][y-1] = '0';
                numIslands(x,y-1);
            }
        }

    }

    public static void main(String[] args) {
        Main200 main200 = new Main200();
        char[][] arr = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int nums = main200.numIslands(arr);
        System.out.println(nums);
    }
}
