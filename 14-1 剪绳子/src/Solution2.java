/**
 * @Author: Song Ningning
 * @Date: 2020-05-28 13:03
 */
public class Solution2 {
    // 记忆化搜索
    // Time：O(N^2) 循环里递归调用，相当于多一层循环。
    // Space：O(N)
    public static int cuttingRope(int n) {
        int[] memo = new int[n + 1];
        return cut(n, memo);
    }

    private static int cut(int n, int[] memo) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }

        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * cut(n - i, memo)));
        }
        memo[n] = res;
        return memo[n];
    }


    public static void main(String[] args) {
        System.out.println(cuttingRope(10));  // 36
        System.out.println(cuttingRope(31));  // 78732
    }
}
