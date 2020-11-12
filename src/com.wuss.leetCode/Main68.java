package com.wuss.leetCode;


import java.util.ArrayList;
import java.util.List;

/**
 * @program leetcode
 * @description:
 * @author: wuss
 * 68. 文本左右对齐
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 说明:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 * <p>
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * 示例 3:
 *
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/text-justification
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 * 因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 */
public class Main68 {
    char blank = ' ';

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int len = 0,left,appendLen = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<words.length;){
            left = i;
            len = 0;
            while (i< words.length){
                if (len + (i-left-1)+words[i].length() < maxWidth  ){
                    len = len + words[i].length();
                    i++;
                }else {
                    break;
                }

            }
            sb.setLength(0);
            appendLen = (maxWidth - len);
            if (i >= words.length){
                for (int k=left;k<words.length;k++){
                    sb.append(words[k]).append(blank);
                }
                if (sb.length()>maxWidth){
                    sb.setLength(maxWidth);
                }else {
                    append(sb,maxWidth - sb.length());
                }
                list.add(sb.toString());
                continue;
            }
            if (i -left == 1){
                sb.append(words[left]);
                append(sb,maxWidth-words[left].length());
                list.add(sb.toString());
                continue;
            }
            int[] nums = new int[i-left];
            for (int k=0;k<appendLen;k++){
                nums[k%(i-left-1)]++;
            }
            for (int k = left;k<i;k++){
                sb.append(words[k]);
                append(sb,nums[k-left]);
            }
            list.add(sb.toString());



        }

        return list;
    }

    private String append(StringBuilder sb ,int appendLen){
        for (int i=0;i<appendLen;i++){
            sb.append(blank);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
//        String[] arr =new String[]{"What","must","be","acknowledgment","shall","be"};
        String[] arr =new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        Main68 main68 = new Main68();
        int len =20;
        List<String> list = main68.fullJustify(arr,len);
        System.out.println(list);
    }


}

