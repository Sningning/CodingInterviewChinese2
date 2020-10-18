/**
 * 面试题04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author: Song Ningning
 * @date: 2020-05-15 22:12
 */
public class Solution {

    public boolean findNumberIn2DArray(int[][] m, int k) {

        // 由于数组每行有序、每列有序，可以从左下角或者右上角出发
        // 如果当前元素比 k 大，往右或者往下寻找；
        // 如果当前元素比 k 小，往上或者往左寻找

        if (m.length == 0)
            return false;
        // 右上角开始寻找
        int x = 0; // 行
        int y = m[0].length - 1;  // 列
        while (x < m.length && y >= 0) {
            if (m[x][y] == k)
                return true;
            if (m[x][y] < k)
                x++;
            else
                y--;
        }
        return false;
    }
}
