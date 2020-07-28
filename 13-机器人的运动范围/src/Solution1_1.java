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
public class Solution1_1 {

    /**
     * DFS
     */

    int rows, cols;
    boolean[][] visited;
    int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int res = 0;

    public int movingCount(int m, int n, int k) {
        rows = m;
        cols = n;
        visited = new boolean[rows][cols];
        dfs(0, 0, k);
        return res;
    }

    private void dfs(int x, int y, int k) {
        // 递归终止条件
        if (!inArea(x, y) || visited[x][y] || sumOfDigits(x, y) > k) {
            return;
        }
        // 标记为已访问过
        visited[x][y] = true;
        // 运行到这里，说明当前位置满足条件，结果加一
        res++;
        // 往周围再去探索
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            dfs(newX, newY, k);
        }
    }

    // 计算两个数字的数位和
    private int sumOfDigits(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }

    // 边界检查
    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {

        Solution1_1 s = new Solution1_1();
        int count = s.movingCount(16, 8, 4);  // 15
        System.out.println(count);
    }
}
