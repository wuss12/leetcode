package com.wuss.leetCode;


import java.util.*;

/**
 * @program leetcode
 * @description:
 * @author: wuss@wjs.com
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 所有输入均为小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (String str:strs) {
            char[] arrs = str.toCharArray();
            Arrays.sort(arrs);
            String key = String.valueOf(arrs);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Main49 main49 = new Main49();
        String[] strs ={"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = main49.groupAnagrams(strs);
        result.stream().forEach(e-> System.out.println(e));
    }
}
