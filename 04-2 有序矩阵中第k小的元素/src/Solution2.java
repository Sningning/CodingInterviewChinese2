/**
 * @Author: Song Ningning
 * @Date: 2020-07-02 15:57
 */
public class Solution2 {

    /**
     * 值域二分
     * 矩阵左上角和右下角分别是最小值和最大值，这样就有了一个范围。
     * 取 left = matrix[0][0], right = matrix[n-1][n-1];
     * 中间值 mid = (left + right) / 2;
     * 我们统计出矩阵中 <= mid 的数字个数 count，与 k 进行比较：
     *     如果 count < k：说明要找的数字肯定要大于 mid，在右侧，将 left 更新为 mid+1；
     *     如果 count >= k：说明要找的数字在 [left...mid] 这个范围里，将 right 更新为 mid。
     * 如果 count = k，且 mid 在矩阵中，则 mid 为要找的值。
     *
     * 视频：
     * https://www.bilibili.com/video/BV1kK411n7Bi?from=search&seid=15572351607533511481
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            int count = findNotBiggerThanMid(matrix, mid, n);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 在排序方阵中找到不大于 mid 的元素个数
     * @param matrix 排序方阵
     * @param mid 目标值
     * @param n 方阵的行数
     * @return 不大于 mid 的元素个数
     */
    private static int findNotBiggerThanMid(int[][] matrix, int mid, int n) {
        // 从左下角按列查找，如果 matrix[i][j] <= mid，则 matrix[0...i][j] 均不大于 mid
        int i = n - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                // 第 j 列有 i+1 个元素 <=mid
                count += (i + 1);
                j++;
            } else {
                // 第 j 列目前的数大于 mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] arr = {
                {1, 10, 20},
                {2, 11, 21},
                {3, 12, 22}};
        System.out.println(kthSmallest(arr, 3)); // 3
    }
}
