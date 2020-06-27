 /**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 *
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 提示：
 * 0 <= num < 231
 *
 * @Author: Song Ningning
 * @Date: 2020-06-24 11:54
 */
public class Solution1 {

    /**
     * 动态规划
     *
     * 实际上这道题就是爬楼梯的换皮题
     *
     * 状态定义：dp[i] 以第 i 个数字结尾的翻译方案
     * 初始化：dp[0] = dp[1] = 1;
     * 转移方程：
     *     如果 i-1 和 i 可以组合：dp[i] = dp[i-2](选择组合) + dp[i-1](选择不组合)；
     *     如果 i-1 和 i 不能组合：dp[i] = dp[i-1]；
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)，字符串 O(N)，dp 数组 O(N)
     */
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        // 由于 dp 比 s 长度大一，因此 dp[i] 实际上是考虑的 s 中 i-1 位置字符
        for (int i = 2; i < len + 1; i++) {
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2') && s.charAt(i - 1) < '6') {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }

     public static void main(String[] args) {
         Solution1 s = new Solution1();
         System.out.println(s.translateNum(12258)); // 5
     }

}
