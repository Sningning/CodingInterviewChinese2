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
public class Solution1 {

    int[] res;
    Queue<Integer> list = new LinkedList<>();

    public int[] spiralOrder(int[][] m) {

        if (m == null || m.length == 0) {
            return new int[0];
        }
        int a = 0, b = 0;
        int c = m.length - 1;
        int d = m[0].length - 1;

        int len = m.length * m[0].length;
        res = new int[len];

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
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
