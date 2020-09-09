/**
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 示例 1:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * 提示：
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 *
 * @author: Song Ningning
 * @date: 2020-06-27 20:19
 */
public class Solution1 {

    /**
     * 动态规划
     *
     * 由于只能【向右】或者【向下】移动，因此到达 (i,j)，有两条路：(i-1,j) 和 (i,j-1)
     * 因此 dp(i,j) = max(dp(i-1,j), dp(i,j-1)) + grid(i,j)；
     * 初始化：
     *     dp 表的第一行和第一列都可以预先填好；
     * 返回：
     *     dp(m-1,n-1)
     *
     * 时间复杂度：O(mn)，遍历矩阵每个元素
     * 空间复杂度：O(mn)，dp 数组大小为 m*n
     */
    public int maxValue(int[][] grid) {

        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // 初始化
        dp[0][0] = grid[0][0];
        // 填充第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        // 填充第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 按行填充
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[][] grid1 = {{1, 3, 1},
                         {1, 5, 1},
                         {4, 2, 1}};
        int[][] grid2 = {{1, 3, 1}};
        int[][] grid3 = {{1}, {1}, {4}};
        System.out.println(s.maxValue(grid1)); // 12
        System.out.println(s.maxValue(grid2)); // 5
        System.out.println(s.maxValue(grid3)); // 6
    }
}
