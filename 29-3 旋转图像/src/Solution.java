/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * https://leetcode-cn.com/problems/rotate-image/
 *
 * @author: Song Ningning
 * @date: 2020-08-17 10:38
 */
public class Solution {

    /**
     * 思路：能完成一圈旋转就可以完成所有旋转，因此最主要的就是最外面一圈怎么旋转
     *  1  2  3
     *  4     6
     *  7  8  9
     *
     *  左上角为(a, b)，右下角为(c, d)，在这一圈中，先是 1 3 9 7 调整位置，然后 2 6 8 4 调整位置，
     *  这样外面这一圈位置就调整完毕，然后进入下一圈。
     *
     */

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;
        int a = 0, b = 0;
        int c = n - 1, d = n - 1;
        while (a < c) {
            rotateEdge(matrix, a++, b++, c--, d--);
        }
    }

    private void rotateEdge(int[][] matrix, int a, int b, int c, int d) {
        // 当前这一圈需要调整的次数
        int times = d - b;
        int temp;
        for (int i = 0; i < times; i++) {
            temp = matrix[a][b + i];
            matrix[a][b + i] = matrix[c - i][b];
            matrix[c - i][b] = matrix[c][d - i];
            matrix[c][d - i] = matrix[a + i][d];
            matrix[a + i][d] = temp;
        }
    }
}
