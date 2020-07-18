/**
 * @author: Song Ningning
 * @date: 2020-07-18 21:45
 */
public class Solution2 {

    /**
     * 针对暴力枚举的优化
     * 遍历的时候同时维护一个之前（不包括当前）的股票最低价，这样用当前价格减去最低价就得到了利润。
     * 省去一层循环。
     *
     * 其实这种方法是动态规划的优化：
     * 相当于两个数组 minPrice[i] 和 maxProfit[i]
     * minPrice[i] 表示前 i 天中的最低股价；maxProfit[i] 表示第 i 天可以获得的最大收益；
     * 状态转移：
     *     minPrice[i] = min(minPrice[i-1], price[i]);
     *     maxProfit[i] = max(maxProfit[i-1], price[i]-minPrice[i-1])，即第 i 天选择不卖或者卖
     * minPrice[i]可以压缩为一个变量；由于 maxProfit[i] 只和前一个状态有关系，所以也可以进行压缩；
     *
     * 时间按复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int res = 0;
        // 之前天数中的最低价
        int minPrice = prices[0];
        // 注意从第二天开始
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return res;
    }

    // 不压缩状态的动态规划
    static class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len < 2) {
                return 0;
            }
            int[] minPrice = new int[len];
            int[] maxProfit = new int[len];
            minPrice[0] = prices[0];
            maxProfit[0] = 0;
            for (int i = 1; i < len; i++) {
                maxProfit[i] = Math.max(maxProfit[i - 1], prices[i] - minPrice[i - 1]);
                minPrice[i] = Math.min(minPrice[i - 1], prices[i]);
            }
            return maxProfit[len - 1];
        }
    }
}
