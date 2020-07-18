/**
 * @author: Song Ningning
 * @date: 2020-07-18 21:54
 */
public class Solution3 {

    /**
     * 计算每天的收益
     * prices：[7, 1, 5,  3, 6,  4]
     * gain：    [-6, 4, -2, 3, -2]
     *
     * gain[i] 表示第 i-1 天买入，第 i 天卖出的收益，可以为负数
     * 最终问题转化为求 gain 的子序列的最大值，和力扣第 53 题：最大子序和 相同。
     * 比如：上面的例子中是 [4, -2, 3]，代表第 2 天买入，第 5 天卖出
     *
     * 最后，因为允许不交易，所以最小值肯定是 0，而计算最大连续子序列的和可能为负数，所以最后要取较大值。
     *
     * 时间按复杂度：O(N) + O(N)
     * 空间复杂度：O(N)
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[] gains = new int[len - 1];
        for (int i = 1; i < len; i++) {
             gains[i - 1] = prices[i] - prices[i - 1];
        }
        // 寻找最大连续子序列
        int[] dp = new int[gains.length];
        dp[0] = gains[0];
        for (int i = 1; i < gains.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = gains[i];
            } else { // dp[i - 1] >= 0
                dp[i] = dp[i - 1] + gains[i];
            }
        }
        // 遍历找到最大值
        int max = dp[0];
        for (int profit : dp) {
            max = Math.max(max, profit);
        }
        return Math.max(max, 0);
    }
}
