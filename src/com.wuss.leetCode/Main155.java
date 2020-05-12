package com.wuss.leetCode;

import java.net.Inet4Address;

/**
 * @program leetcode
 * @description:
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class Main155 {

//   class MinStack{
//       int[] arr;
//       int size;
//       /** initialize your data structure here. */
//       public MinStack() {
//           arr = new int[100000];
//           size = -1;
//       }
//
//       public void push(int x) {
//           arr[++size] = x;
//       }
//
//       public void pop() {
//          size--;
//       }
//
//       public int top() {
//           return arr[size];
//       }
//
//       public int getMin() {
//           int min = arr[0];
//           for (int i =1;i<= size;i++){
//               if (arr[i]<min){
//                   min = arr[i];
//               }
//           }
//           return min;
//       }
//   }

    //method2
    class MinStack{
        int[] arr;
        int[] minArr;
        int size;
        int minIndex;
        int min = Integer.MAX_VALUE;
        /** initialize your data structure here. */
        public MinStack() {
            arr = new int[100000];
            minArr = new int[100000];
            minArr[0] = Integer.MAX_VALUE;
            minIndex = 0;
            size = -1;
        }

        public void push(int x) {
            arr[++size] = x;
            min = minArr[minIndex];
            if (x < min){
                min = x;
            }
            minArr[++minIndex] = min;
        }

        public void pop() {
            size--;
            minIndex --;
        }

        public int top() {
            return arr[size];
        }

        public int getMin() {
           return minArr[minIndex];
        }
    }

}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
