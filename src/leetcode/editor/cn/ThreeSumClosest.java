  //给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 排序 
// 👍 888 👎 0

  
  package leetcode.editor.cn;

  import java.util.Arrays;

  public class ThreeSumClosest{
      public static void main(String[] args) {
           Solution solution = new ThreeSumClosest().new Solution();
           int[] nums = {-1,2,1,-4};
           System.out.println(solution.threeSumClosest(nums, 1));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;//临时存最接近的和，初始化为最大整型是为了保证一直有更小于它的和
        int ans = 0;
        int len = nums.length;
        for (int i=0; i< nums.length; i++){
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            //双指针
            int left = i + 1;
            int right = len - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target){
                    ans = sum;
                }
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    ans = sum;
                }
                if (sum > target){
                    right--;
                    while (left < right && nums[right]==nums[right+1]){
                        right--;
                    }
                }else {
                    left++;
                    while (left < right && nums[left]==nums[left-1]){
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }