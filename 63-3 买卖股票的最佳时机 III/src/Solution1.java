/**
 * 123. 买卖股票的最佳时机 III 【困难】
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 *
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * @author: Song Ningning
 * @date: 2020-07-19 15:26
 */
public class Solution1 {

    /**
     * 由于最多只能交易两次（可以不交易，交易一次，交易两次），而且必须卖出后才能买入，考虑将数组分成两部分。
     * 每次找到 prices[0...index] 范围内最大利润和 prices[index+1...len) 范围内最大利润，最后的结果就是两者相加
     * 求在每个区间最多交易一次的最大利润，代码就是 121 题.
     * 但对每个 i 都按照 121 题做法来一遍，最后汇总计算最大利润，这么做的时间复杂度为O(N^2)：计算前半部分需要计算 prices[0...index]，
     * 而再计算 prices[index...len) 范围，还是需要再计算 prices[0...index]。
     *
     * 对于第二部分，考虑从后往前计算，每次记录 [index...len) 的最大价格 maxPrice，以此价格作为卖出，往前找小于 maxPrice 的价格作为买入，
     * 再更新当前的最大利润和 maxPrice 即可。
     *
     * 时间复杂度：O(3N)
     * 空间复杂度：O(2N)
     */
    public int maxProfit(int[] prices) {

        int len = prices.length;

        // 处理前半部分
        int minPrice = prices[0];  // 前半部分最小买入价格
        int[] left = new int[len]; // 前半部分利润表，profit1[i] 代表从第 0 天到第 i 天的最大利润
        left[0] = 0;
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        // 处理后半部分
        int maxPrice = prices[len - 1]; // 后半部分最大卖出价格
        int[] right = new int[len];     // 后半部分利润表，profit2[i] 代表从第 i 天(i为索引值)到最后一天的最大利润
        right[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }

        // 枚举间隙
        int maxProfit = Math.max(left[len - 1], right[0]); // 有可能是只交易一次的场景
        for (int i = 1; i < len - 2; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }
        return maxProfit;
    }


    /**
     * 合并到一个循环中
     */
    static class Solution2 {

        public int maxProfit(int[] prices) {

            int len = prices.length;

            int minPrice = prices[0];       // 前半部分最小买入价格
            int[] left = new int[len];      // 前半部分利润表，profit1[i] 代表从第 0 天到第 i 天的最大利润

            int maxPrice = prices[len - 1]; // 后半部分最大卖出价格
            int[] right = new int[len];     // 后半部分利润表，profit2[i] 代表从第 i 天(i为索引值)到最后一天的最大利润

            for (int i = 1; i < len; i++) {
                // 处理前半部分
                left[i] = Math.max(left[i - 1], prices[i] - minPrice);
                minPrice = Math.min(minPrice, prices[i]);
                // 处理后半部分
                right[len - 1 - i] = Math.max(right[len - i], maxPrice - prices[len - 1 - i]);
                maxPrice = Math.max(maxPrice, prices[len - 1 - i]);
            }

            // 枚举间隙
            int maxProfit = Math.max(left[len - 1], right[0]); // 有可能是只交易一次的场景
            for (int i = 1; i < len - 2; i++) {
                maxProfit = Math.max(maxProfit, left[i] + right[i]);
            }
            return maxProfit;
        }
    }
}
