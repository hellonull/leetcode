//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 4063 👎 0


package leetcode.editor.cn;
public class LongestPalindromicSubstring{
  public static void main(String[] args) {
       Solution solution = new LongestPalindromicSubstring().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1){
            return s;
        }

        int begin = 0;
        int maxLen = 1;
        //dp[i][j]表示s[i...j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        //初始化：所有长度为1的字串都是回文串
        for (int i=0; i<len; i++){
            dp[i][i] = true;
        }

        for (int L=2; L<=len; L++){
            for (int i=0; i<len; i++){
                //左边界从0开始，右边界j-i+1=L
                int j = L-1+i;
                if (j >= len){
                    break;
                }
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                    continue;
                }else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        // 当一对边界组合相等时，那么该对边界中间包含的 前面已经判断过的更短边界对 也要相等，否则这对边界及其包含元素组合的子串不是回文串
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j-i+1>maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}