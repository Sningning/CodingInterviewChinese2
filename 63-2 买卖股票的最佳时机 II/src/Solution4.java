/**
 * @author: Song Ningning
 * @date: 2020-07-19 15:09
 */
public class Solution4 {

    /**
     * 压缩空间
     * 也可以将二维数组拆成两个变量。
     *
     * 时间复杂度：O(N)，这里 N 表示股价数组的长度。
     * 空间复杂度：O(1)
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int notHold = 0; // 当天不持有股票的最大收益
        int hold = -prices[0]; // 当天持有股票的收益
        int preNotHold = notHold; // 前一天不持有股票的最大收益
        int preHold = hold; // 前一条持有股票的收益
        for (int i = 1; i < len; i++) {
            notHold = Math.max(preNotHold, preHold + prices[i]);
            hold = Math.max(preHold, preNotHold - prices[i]);
            preNotHold = notHold;
            preHold = hold;
        }
        return notHold;
    }
}
