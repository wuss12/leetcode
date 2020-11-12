package com.wuss.leetCode;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 65. 有效数字
 * 验证给定的字符串是否可以解释为十进制数字。
 *
 * 例如:
 *
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 *
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 *
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * 当然，在输入中，这些字符的上下文也很重要。
 *
 * 更新于 2015-02-10:
 * C++函数的形式已经更新了。如果你仍然看见你的函数接收 const char * 类型的参数，请点击重载按钮重置你的代码。
 */
public class Main65 {
    public boolean isNumber(String s) {
       s = s.trim();
       if (s.contains("--")||s.contains("-+")||s.contains("++")||s.contains("+-")||s.indexOf(' ')>0){
           return false;
       }
       char[] chars = s.toCharArray();
       for (char ch : chars){
           if ((ch >='0' && ch <='9')||"-+e.".indexOf(ch)>=0){
               continue;
           }
           return false;
       }
       if (s.indexOf('e')!= s.lastIndexOf('e')){
           return false;
       }
        String[] es = s.split("e");
       if (es.length >2 ){
           return false;
       }
       if (s.indexOf('e')>=0 && es.length < 2){
           return false;
       }
       if (es[0].length() == 0 ||  !oneTime(es[0],'.')){
           return false;
       }


       if (es[0].indexOf('-')> 0 || es[0].indexOf('+')> 0){
           return false;
       }
       if (es.length ==2){
           if (es[1].length() == 0){
               return false;
           }
           if (es[1].indexOf('-')> 0 || es[1].indexOf('+')> 0){
               return false;
           }
           if (es[1].indexOf("-") ==es[1].length()-1 ||es[1].indexOf("+") ==es[1].length()-1){
               return false;
           }
           return es[1].indexOf('.') < 0;
       }
       return true;
    }
    private static boolean oneTime(String str,char chJ){
        if (str.isEmpty()){
            return true;
        }
        if (str.equals(".")){
            return false;
        }
        int index1 = str.lastIndexOf('-');
        int index = str.lastIndexOf('+');
        if (index>0 || index1>0){
            return false;
        }
        if (index == 0 || index1 == 0){
            if (str.length() == 1){
                return false;
            }
        }

        index = str.indexOf('.');
        if (index > 0){
            char ch = str.charAt(index-1);
            if (ch == '-'|| ch == '+'){
                if (index == str.length() -1){
                    return false;
                }
            }

        }
        if (index == 0){
            if (str.length() == 1){
                return false;
            }
            char ch = str.charAt(index+1);
            if (ch < '0' || ch >'9'){
                return false;
            }
        }



        int num = 0;
        for (char ch : str.toCharArray()){
            if (ch == chJ){
                num++;
                if (num >1){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isNum(String str){
        String regx="\\ *(\\+|\\-)?(\\.?\\d+|\\d+\\.?\\d*)(e(\\+|\\-)?\\d+)?\\ *";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();

    }

    /**
     *     作者：user8973
     *     链接：https://leetcode-cn.com/problems/valid-number/solution/biao-qu-dong-fa-by-user8973/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *     有限状态机解法
     *     class Solution {
     *         public int make(char c) {
     *             switch(c) {
     *                 case ' ': return 0;
     *                 case '+':
     *                 case '-': return 1;
     *                 case '.': return 3;
     *                 case 'e': return 4;
     *                 default:
     *                     if(c >= 48 && c <= 57) return 2;
     *             }
     *             return -1;
     *         }
     *
     *         public boolean isNumber(String s) {
     *             int state = 0;
     *             int finals = 0b101101000;
     *             int[][] transfer = new int[][]{{ 0, 1, 6, 2,-1},
     *                     {-1,-1, 6, 2,-1},
     *                     {-1,-1, 3,-1,-1},
     *                     { 8,-1, 3,-1, 4},
     *                     {-1, 7, 5,-1,-1},
     *                     { 8,-1, 5,-1,-1},
     *                     { 8,-1, 6, 3, 4},
     *                     {-1,-1, 5,-1,-1},
     *                     { 8,-1,-1,-1,-1}};
     *             char[] ss = s.toCharArray();
     *             for(int i=0; i < ss.length; ++i) {
     *                 int id = make(ss[i]);
     *                 if (id < 0) return false;
     *                 state = transfer[state][id];
     *                 if (state < 0) return false;
     *             }
     *             return (finals & (1 << state)) > 0;
     *         }
     *     }
     */




    public static void main(String[] args) {
        Main65 main65 = new Main65();
        Scanner scanner = new Scanner(System.in);
        String value;
        while (scanner.hasNext()){
            value = scanner.nextLine();
            System.out.println(main65.isNumber(value));
//            System.out.println(main65.isNum(value));
        }
    }
}
