/**
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 *
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * @Author: Song Ningning
 * @Date: 2020-05-19 22:26
 */
public class Solution1 {

    int rows, cols;
    boolean[][] visited;
    // int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int movingCount(int m, int n, int k) {
        if (k == 0)
            return 1;

        rows = m;
        cols = n;
        visited = new boolean[rows][cols];
        int res = dfs(0, 0, k);
        return res;
    }

    private int dfs(int x, int y, int k) {
        if (!inArea(x, y) || (sumDigit(x) + sumDigit(y) > k) || visited[x][y])
            return 0;

        visited[x][y] = true;
        return 1 + dfs(x + 1, y, k) +
                dfs(x - 1, y, k) +
                dfs(x, y + 1, k) +
                dfs(x, y - 1, k);
    }

    // 计算数字 num 的数位和
    private int sumDigit(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // 边界检查
    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {

        Solution1 s = new Solution1();
        int count = s.movingCount(16, 8, 4);  // 预期 15
        System.out.println(count);
    }
}
