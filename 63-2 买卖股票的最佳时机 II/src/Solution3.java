/**
 * @author: Song Ningning
 * @date: 2020-07-19 15:07
 */
public class Solution3 {

    /**
     * 压缩空间
     * 因为只与上个状态有关，所以使用两行即可，但是要分奇偶数，代码略显冗余。
     *
     * 时间复杂度：O(N)，这里 N 表示股价数组的长度。
     * 空间复杂度：O(1)
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            if ((i & 1) == 1) {
                dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[i]);
                dp[1][1] = Math.max(dp[0][0] - prices[i], dp[0][1]);
            } else {
                dp[0][0] = Math.max(dp[1][0], dp[1][1] + prices[i]);
                dp[0][1] = Math.max(dp[1][0] - prices[i], dp[1][1]);
            }
        }
        return Math.max(dp[0][0], dp[1][0]);
    }
}
