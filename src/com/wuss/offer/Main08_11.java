package com.wuss.offer;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 面试题 08.11. 硬币
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * <p>
 * 示例1:
 * <p>
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 * <p>
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * 说明：
 * <p>
 * 注意:
 * <p>
 * 你可以假设：
 * <p>
 * 0 <= n (总金额) <= 1000000
 */
public class Main08_11 {


    /**
     * 令 dp[i][j] 为遍历到当下这个硬币时，组成金额 j 的方法数目
     * 有两种可能性（1）当前这个硬币没有取，dp[i][j]=dp[i-1][j]；（2）当前这个硬币取了，dp[i][j]=dp[i][j-coins[i]]。最后的结果是两者的和
     * 将状态转移方程翻译成代码，并处理边界条件
     *
     * 作者：yuanninesuns
     * 链接：https://leetcode-cn.com/problems/coin-lcci/solution/dong-tai-gui-hua-jian-dan-yi-dong-by-yuanninesuns/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */

    int mod = 1000000007;
    public int waysToChange(int n) {
        int[][] dp=new int[4][n+1];
        int[] coins={1,5,10,25};

        for(int i=0;i<=n;i++)
            dp[0][i]=1;
        for(int i=0;i<4;i++)
            dp[i][0]=1;

        for(int i=1;i<4;i++){
            for(int j=1;j<=n;j++){
                if(j>=coins[i])
                    dp[i][j]=(dp[i-1][j]+dp[i][j-coins[i]])% mod;
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[3][n];
    }

    public static void main(String[] args) {
        Main08_11 main08_11 = new Main08_11();

//        System.out.println(main08_11.waysToChange(1000000));
        for (int i=0;i<60;i++){
            System.out.println(i+":\t"+main08_11.waysToChange(i));
        }

    }


}
