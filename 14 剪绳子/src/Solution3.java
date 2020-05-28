/**
 * @Author: Song Ningning
 * @Date: 2020-05-28 15:09
 */
public class Solution3 {

    public static int cuttingRope(int n) {
        /*
         * 根据暴力递归可知，对于确定的一个数 n，将他分割后的最大乘积是固定不变的，即不管怎么分，最大值是一定的，因此无后效性;
         * 递归时可变参数 i 变化范围是 [1,n-1] (至少划分为2份)，所以对于每个 i，它的结果都可以确定地填在一维数组 dp[n+1] 中；
         * 最终想要的状态是 dp[n]
         * 递归终止条件是 if (n == 1) { return 1; }，因此 dp[1] 是不依赖其他位置的，即初始化 dp[1] = 1;
         * 对于某个 i，dp[i] 所依赖的状态有：dp[i-j] (1<= j <= i-1)，即所有 i 前面的状态，又因为 dp[1] 已知了，所以，可以依次求出
         * dp[2]、dp[3]...
         *
         * 动态规划
         * 状态：dp[i] 表示把长度为 i 的绳子剪成若干段之后各段长度乘积的最大值
         * 初始化：dp[1] = 1
         * 状态转移：要计算 dp[i]，就要计算 dp[i-1]、dp[i-2]...
         * 结果返回：dp[n]
         */

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 对于每一个 i，还要分解为 j + (i - j)，来计算出 dp[i]
            for (int j = 1; j <= i - 1; j++) {
                // 获得最大乘积的一种方式 j * (i - j)
                // 另一种方式 (i - j) 分割后的最大乘积 * j，而 (i - j) 分割后的最大乘积就是 dp[i - j]
                // 因为 (i - j) < i，因此之前已经求出了
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(cuttingRope(10));  // 36
        System.out.println(cuttingRope(31));  // 78732
    }
}
