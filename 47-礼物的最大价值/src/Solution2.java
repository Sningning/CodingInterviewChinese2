/**
 * @Author: Song Ningning
 * @Date: 2020-06-27 21:08
 */
public class Solution2 {

    /**
     * 由于 dp(i,j) 只与 dp(i-1,j), dp(i,j-1) 和 grid(i,j) 有关
     * 因此可以直接在原矩阵上进行操作。
     *
     * 时间复杂度：O(mn)，遍历矩阵每个元素
     * 空间复杂度：O(1)
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;

        // 初始化
        // 填充第一行
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        // 填充第一列
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
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
