//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1782 👎 0


package leetcode.editor.cn;
public class LongestCommonPrefix{
  public static void main(String[] args) {
       Solution solution = new LongestCommonPrefix().new Solution();
       String[] str = {"dog","racecar","car"};
      System.out.println(solution.longestCommonPrefix(str));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prex = "";
        int firstLen = strs[0].length();
        if (firstLen == 0){
            return prex;
        }
        int currentIndex = 0;
        char currentVal;
        boolean endFlag = false;
        while (firstLen != 0){
            currentVal = strs[0].charAt(currentIndex);
            for (String str : strs){
                if (str.length() <= currentIndex){
                    endFlag = true;
                    break;
                }
                if (str.charAt(currentIndex) != currentVal){
                    endFlag = true;
                    break;
                }
            }
            if (endFlag){
                break;
            }
            prex += currentVal;
            currentIndex ++;
            firstLen--;
        }
        return prex;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}