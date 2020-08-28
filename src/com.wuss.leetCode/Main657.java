package com.wuss.leetCode;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 657. 机器人能否返回原点
 */
public class Main657 {
    //R（右），L（左），U（上）和 D（下）
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        char r='R';
        char l ='L';
        char u = 'U';
        char d = 'D';

        char[] chars = moves.toCharArray();
        for (char ch : chars){
            if (ch == r){
                x++;
                continue;
            }
            if (ch == l){
                x--;
                continue;
            }
            if (ch == u){
                y++;
                continue;
            }
            if (ch == d){
                y--;
            }
        }
        return x == 0 && y == 0;
    }
}
