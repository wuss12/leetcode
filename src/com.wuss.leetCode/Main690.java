package com.wuss.leetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * @create: 2021/05/01 20:47
 * 690. 员工的重要性
 * 给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。
 *
 * 比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
 *
 * 现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
 *
 *
 *
 * 示例：
 *
 * 输入：[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出：11
 * 解释：
 * 员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
 */
public class Main690 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer ,Employee>  employeeMap = new HashMap<>(employees.size());
        for (Employee employee : employees){
            employeeMap.put(employee.id,employee);
        }
        int sum = 0;
        Employee employee = employeeMap.get(id);
        sum += employee.importance;
        if (employee.subordinates.size() == 0){
            return sum;
        }
        Stack<Integer> stack = new Stack<>();
        for (Integer subordinate : employee.subordinates) {
            stack.push(subordinate);
        }

        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            Employee employee1 = employeeMap.get(pop);
            sum+= employee1.importance;
            for (Integer subordinate : employee1.subordinates) {
                stack.push(subordinate);
            }
        }
        return sum;

    }



}


class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

}