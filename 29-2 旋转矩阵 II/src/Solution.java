/**
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 *
 * @author: Song Ningning
 * @date: 2020-08-17 16:53
 */
public class Solution {

    /**
     * 和上一题一样，从宏观上入手，每次填充一圈，从外到内，由于是方阵，最后肯定 a==c,b==d。
     */
    int index = 1;

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int a = 0, b = 0;
        int c = n - 1, d = n - 1;
        while (a <= c && b <= d) {
            generateEdge(res, a++, b++, c--, d--);
        }
        return res;
    }

    private void generateEdge(int[][] res, int a, int b, int c, int d) {
        if (a == c) {
            res[a][b] = index;
        } else {
            int curR = a;
            int curC = b;
            while (curC < d) {
                res[a][curC++] = index++;
            }
            while (curR < c) {
                res[curR++][d] = index++;
            }
            while (curC > b) {
                res[c][curC--] = index++;
            }
            while (curR > a) {
                res[curR--][b] = index++;
            }
        }
    }
}
