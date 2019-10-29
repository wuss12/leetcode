package com.wuss.leetCode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1){
            return s;
        }
        boolean[][] booleans = new boolean[len][len];
        int start = 0,longest = 1;
        for (int i=0;i<len;i++){
            booleans[i][i] = true;
            if(i < len -1){
                if(s.charAt(i) == s.charAt(i+1)){
                    booleans[i][i+1] = true;
                    start = i;
                    longest = 2;
                }
            }
        }
        int end = 0;

        for (int l = 3;l<=len;l++){
            for (int j=0;j<len - l +1;j++){
                end = j+l -1;
                if(s.charAt(j) == s.charAt(end) && booleans[j+1][end-1]){
                    booleans[j][end] = true;
                    start = j;
                    longest = l;
                }
            }
        }
        return s.substring(start,start+longest);

    }

    public static void main(String[] args) {
        Main5 main5  = new Main5();
        String str ="kztakrekvefgchersuoiuatzlmwynzjhdqqftjcqmntoyckqfawikkdrnfgbwtdpbkymvwoumurjdzygyzsbmwzpcxcdmmpwzmeibligwiiqbecxwyxigikoewwrczkanwwqukszsbjukzumzladrvjefpegyicsgctdvldetuegxwihdtitqrdmygdrsweahfrepdcudvyvrggbkthztxwicyzazjyeztytwiyybqdsczozvtegodacdokczfmwqfmyuixbeeqluqcqwxpyrkpfcdosttzooykpvdykfxulttvvwnzftndvhsvpgrgdzsvfxdtzztdiswgwxzvbpsjlizlfrlgvlnwbjwbujafjaedivvgnbgwcdbzbdbprqrflfhahsvlcekeyqueyxjfetkxpapbeejoxwxlgepmxzowldsmqllpzeymakcshfzkvyykwljeltutdmrhxcbzizihzinywggzjctzasvefcxmhnusdvlderconvaisaetcdldeveeemhugipfzbhrwidcjpfrumshbdofchpgcsbkvaexfmenpsuodatxjavoszcitjewflejjmsuvyuyrkumednsfkbgvbqxfphfqeqozcnabmtedffvzwbgbzbfydiyaevoqtfmzxaujdydtjftapkpdhnbmrylcibzuqqynvnsihmyxdcrfftkuoymzoxpnashaderlosnkxbhamkkxfhwjsyehkmblhppbyspmcwuoguptliashefdklokjpggfiixozsrlwmeksmzdcvipgkwxwynzsvxnqtchgwwadqybkguscfyrbyxudzrxacoplmcqcsmkraimfwbauvytkxdnglwfuvehpxd";
        System.out.println(main5.longestPalindrome(str));
    }
}
