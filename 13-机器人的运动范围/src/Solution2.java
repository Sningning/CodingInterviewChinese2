import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Song Ningning
 * @Date: 2020-05-20 9:10
 */
public class Solution2 {

    public int movingCount(int m, int n, int k) {
        if (k == 0)
            return 1;

        boolean[][] visited = new boolean[m][n];
        int[][] d = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0][0] = true;
        int res = 1;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int x = index / n;
            int y = index % n;
            for (int i = 0; i < 4; i++) {
                int newX = x + d[i][0];
                int newY = y + d[i][1];
                if (inArea(newX, newY, m, n) && !visited[newX][newY] && sumOfDigits(newX, newY) <= k) {
                    queue.add(newX * n + newY);
                    visited[newX][newY] = true;
                    res++;
                }
            }
        }
        return res;
    }

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

    private boolean inArea(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.sumOfDigits(12, 34));
        int count = s.movingCount(16, 8, 4);  // 预期 15
        System.out.println(count);
    }

}
