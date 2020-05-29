import java.util.LinkedList;
import java.util.Queue;
/**
 * 面试题29. 顺时针打印矩阵
 *
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 *
 * @Author: Song Ningning
 * @Date: 2020-05-12 12:45
 */
public class Solution2 {

    // 定义一个索引值，用于返回数组的递增添加
    int index = 0;

    public int[] spiralOrder(int[][] m) {

        if (m == null || m.length == 0) {
            return new int[0];
        }
        int a = 0, b = 0;
        int c = m.length - 1;
        int d = m[0].length - 1;

        int[] res;
        int len = m.length * m[0].length;
        res = new int[len];

        while (a <= c && b <=d) {
            printEdge(m, a++, b++, c--, d--, res);
        }

        return res;
    }

    private void printEdge(int[][] m, int a, int b, int c, int d, int[] res) {

        if (a == c) {
            for (int i = b; i <= d; i++) {
                res[index++] = m[a][i];
            }
        } else if (b == d) {
            for (int i = a; i <= c; i++) {
                res[index++] = m[i][b];
            }
        } else {
            int curR = a;
            int curC = b;
            while (curC < d) {
                res[index++] = m[a][curC++];
            }
            while (curR < c) {
                res[index++] = m[curR++][d];
            }
            while (curC > b) {
                res[index++] = m[c][curC--];
            }
            while (curR > a) {
                res[index++] = m[curR--][b];
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        Solution2 solution1 = new Solution2();
        int[] arr = solution1.spiralOrder(matrix);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
