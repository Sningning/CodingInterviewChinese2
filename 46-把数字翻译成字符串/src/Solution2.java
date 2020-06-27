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
public class Solution2 {

    /**
     * 动态规划
     *
     * dp[i] 只与 dp[i-2] 和 dp[i-1] 有关，因此只需 3 个变量即可
     * a = dp[0]; b = dp[1];
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)，字符串 O(N)
     */
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        String s = String.valueOf(num);
        int a = 1, b = 1;
        int c;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2') && s.charAt(i) < '6') {
                c = a + b;
            } else {
                c = b;
            }
            a = b;
            b = c;
        }
        return b;
    }

     public static void main(String[] args) {
         Solution2 s = new Solution2();
         System.out.println(s.translateNum(12258)); // 5
     }

}
