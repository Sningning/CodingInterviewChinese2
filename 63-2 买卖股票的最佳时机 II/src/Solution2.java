/**
 * @author: Song Ningning
 * @date: 2020-07-19 11:11
 */
public class Solution2 {

    /**
     * 动态规划
     *
     * 每天都有三种动作：买入（buy）、卖出（sell）、无操作（rest）。
     * 因为不限制交易次数，因此交易次数这个因素不影响题目，不必考虑。
     * DP Table 是二维的，两个维度分别是天数（0,1,...,n-1）和是否持有股票（1 表持有，0 表不持有）
     *
     * dp[i][0] 表示索引为 i 的当天不持有股票获得的收益；dp[i][1] 表示索引为 i 的当天持有股票获得的收益；
     *
     * 如果当天不持有股票，有两种可能到达这种状态：
     *     前一天不持有股票，无操作：dp[i][0] = dp[i-1][0];
     *     前一天持有股票，今天卖出：dp[i][0] = dp[i-1][1] + prices[i]
     * 如果当天持有股票，有两种可能到达这种状态：
     *     前一天不持有股票，今天买入：dp[i][1] = dp[i-1][0] - prices[i];
     *     前一天持有股票，今天不操作：dp[i][1] = dp[i-1][1]；
     *
     * 初始状态：
     *     dp[0][0] = 0; // 第一天没有股票，说明没买没卖，获利为0
     *     dp[0][1] = -price[0];  // 第一天持有股票，说明买入了，花掉一笔钱
     *
     * 时间复杂度：O(N)，这里 N 表示股价数组的长度。
     * 空间复杂度：O(N)，虽然是二维数组，但是第二维是常数，与问题规模无关。
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[len - 1][0]; // 一定有 dp[len - 1][0] > dp[len - 1][1]
    }

}
