import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 *
 * 注意：本题与力扣 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 *
 * @author: Song Ningning
 * @date: 2020-05-12 12:45
 */
public class Solution1 {

    /*
     * 从外往里打印，先打印最外圈，依次打印内圈。
     * 只剩下中间一个元素（方阵）或者一行元素（列数 > 行数）或者一列元素（行数 > 列数）时，继续输出。
     *
     *     ---------|   |
     *       1   2  | 3 |
     *     ---------|   |
     *     | 4 | 5  | 6 |
     *     |   |---------
     *     | 7 | 8    9
     *     |   |---------
     *
     * 每次将结果存到一个队列中，最后将从队列头部依次取出元素到返回数组中。
     *
     * Time：O(MN)，M 为矩阵行数，N 为矩阵列数，相当于遍历一遍。
     * Space：O(MN)，使用了一个大小为 M * N 的队列。
     */

    Queue<Integer> list = new LinkedList<>();
    public int[] spiralOrder(int[][] m) {

        if (m == null || m.length == 0) {
            return new int[0];
        }
        int a = 0, b = 0;
        int c = m.length - 1;
        int d = m[0].length - 1;

        int len = m.length * m[0].length;
        int[] res = new int[len];

        while (a <= c && b <=d) {
            printEdge(m, a++, b++, c--, d--);
        }

        for (int i = 0; i < len; i++) {
            res[i] = list.poll();
        }

        return res;
    }

    private void printEdge(int[][] m, int a, int b, int c, int d) {

        if (a == c) {  // 只有一行
            for (int i = b; i <= d; i++) {
                list.add(m[a][i]);
            }
        } else if (b == d) {  // 只有一列
            for (int i = a; i <= c; i++) {
                list.add(m[i][b]);
            }
        } else {
            int curR = a;
            int curC = b;
            while (curC < d) {
                list.add(m[a][curC++]);
            }
            while (curR < c) {
                list.add(m[curR++][d]);
            }
            while (curC > b) {
                list.add(m[c][curC--]);
            }
            while (curR > a) {
                list.add(m[curR--][b]);
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        Solution1 solution1 = new Solution1();
        int[] arr = solution1.spiralOrder(matrix);
        for (int value : arr) {
            System.out.print(value + " ");  // 1 2 3 6 9 8 7 4 5
        }
    }
}
