import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: Song Ningning
 * @date: 2020-07-19 20:20
 */
public class Solution2 {

    /**
     * 状态定义：dp[i][j][k] 表示在 [0, i] 区间里（这个状态依然是前缀性质的），状态为 j 的最大收益：
     *     dp[i][0][0]：未持股，未卖出过股票：说明从未进行过买卖，利润为 0
     *         dp[i][0][0] = 0;
     *     dp[i][0][1]：未持股，卖出过 1 次股票：可能是之前卖的，也可能是今天卖的
     *         dp[i][0][1] = max(dp[i-1][0][1], dp[i-1][1][0] + prices[i]);
     *     dp[i][0][2]：未持股，卖出过 2 次股票：可能是之前卖出过两次，也可能是之前卖出过一次，今天又卖出一次
     *         dp[i][0][2] = max(dp[i-1][0][2], dp[i-1][1][1] + prices[i]);
     *     dp[i][1][0]：持股，未卖出过股票：可能是之前买入过一次，也可能是今天第一次买
     *         dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][0][0] - prices[i]);
     *     dp[i][1][1]：持股，卖出过 1 次股票：可能是之前卖出过一次，又买入了一次，也可能是之前卖出过一次，这次第二次买入
     *         dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][1] - prices[i]);
     *     dp[i][1][2]：持股，卖出过 2 次股票：不可能的状态
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][][] dp = new int[len][2][3];
        dp[0][0][0] = 0;                 // 第一天未持股，未卖出过股票：收益为 0
        dp[0][0][1] = 0;                 // 第一天未持股，卖出过 1 次股票：不可能
        dp[0][0][2] = Integer.MIN_VALUE; // 第一天未持股，卖出过 2 次股票：不可能
        dp[0][1][0] = -prices[0];        // 第一天持股，未卖出过股票：收益为 -prices[0]
        dp[0][1][1] = Integer.MIN_VALUE; // 第一天持股，卖出过 1 次股票：不可能
        dp[0][1][2] = Integer.MIN_VALUE; // 第一天持股，卖出过 2 次股票：不可能
        for (int i = 1; i < len; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][0] + prices[i]);
            dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][1] + prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] - prices[i]);
            dp[i][1][2] = Integer.MIN_VALUE;
        }
        // 最大值只发生在不持股的时候，因此来源有 3 个：k = 0 ,k = 1, k = 2
        return Math.max(dp[len - 1][0][0], Math.max(dp[len - 1][0][1], dp[len - 1][0][2]));
    }

    public static void main(String[] args) {
        int[] arr = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(arr));
    }
}
