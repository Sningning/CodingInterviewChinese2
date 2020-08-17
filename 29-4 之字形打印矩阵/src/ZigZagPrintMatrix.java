/**
 * 给定一个矩阵 matrix，按照“之”字形的方式打印这个矩阵。
 *
 * 要求：额外空间复杂度 O(1)
 *
 * 示例：
 *
 * 给定 matrix =
 * [
 *  [1, 2, 3, 4],
 *  [5, 6, 7, 8],
 *  [9,10,11,12]
 * ],
 *
 * 打印的结果为：1，2，5，9，6，3，4，7，10，11，8，12
 *
 * @author: Song Ningning
 * @date: 2020-08-17 16:23
 */
public class ZigZagPrintMatrix {
    /**
     * 还是从宏观上看，只要能找到对角线上两个元素，再实现一个打印对角线元素的函数即可。
     *
     * 准备两个指针，`A` 初始位置在 `(0,0)`，`A` 一直向右移动，到达边界后，向下移动；
     * `B` 初始位置也在 `(0,0)`，`B` 一直向下移动，到达边界后，向右移动。
     * 两个指针最终会同时到达右下角，注意，两个指针的移动是解耦的。
     *
     * 这样，`A` 和 `B` 都是指向对角线上起始和终止的位置，剩下需要做的就是实现一个 `printLevel` 函数，
     * 来打印这条对角线上的元素，还需要定义一个布尔型变量 `fromUp` 用来确定打印的方向。
     *
     * 实际写代码时，`A` 和 `B` 都是以坐标形式表示。
     */
    public void printMatrixZigZag(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int m = matrix.length; // 总行数
        int n = matrix[0].length; // 总列数
        int a = 0, b = 0; // A 的坐标
        int c = 0, d = 0; // B 的坐标
        boolean fromUp = false;
        while (a <= m) {
            printLevel(matrix, a, b, c, d, fromUp);
            // 考虑 A 移动
            a = b == n ? a + 1 : a;
            b = b == n ? b : b + 1;
            // 考虑 B 移动
            c = c == m ? c : c + 1;
            d = c == m ? d + 1 : d;
            fromUp = !fromUp;
        }
    }

    // 打印矩阵 matrix 中，(a,b) 和 (c,d) 对角线元素，fromUp 控制打印方向
    private void printLevel(int[][] matrix, int a, int b, int c, int d, boolean fromUp) {
        if (fromUp) {
            while (a <= c) {
                System.out.print(matrix[a++][b--] + " ");
            }
        } else {
            while (d <= b) {
                System.out.print(matrix[c--][d++] + " ");
            }
        }
    }
}
