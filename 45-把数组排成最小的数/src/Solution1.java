/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 *
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 * 提示:
 * 0 < nums.length <= 100
 *
 * 说明:
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 * @Author: Song Ningning
 * @Date: 2020-06-24 9:29
 */
public class Solution1 {

    /**
     * 找到一个排序规则，数据根据这个规则排序后就可以得到最小的数字。
     * 要确定排序规则，就要比较两个数字，即给定两个数字 m 和 n，
     * 根据规则判断 m 和 n 哪个应该排在前面，而不是单纯比较两个数的大小。
     *
     * m 和 n 能拼成 mn 和 nm，
     *     如果 mn < nm，定义 m 小于 n；
     *     如果 mn > nm，定义 n 小于 m；
     *     如果 mn = nm，定义 n 等于 m。
     * 比如：101 和 21，数值上：101 > 21，但是 10121 < 21101，因此 101 应该在前面，即规则应该给出 101 小于 21。
     *
     * 如果 m 和 n 是两个很大的数，那么拼接的结果可能会超出范围，因此将数字转换为字符串。
     *
     * 可以使用快速排序 或 Arrays.sort(T[] a, Comparator<? super T> c) 重新定义排序规则。
     */

    /**
     * 快速排序
     *
     * 如果 str[i] + pivot <= pivot + str[i]，说明 pivot 应该在 str[i] 后面，str[i] 小于 pivot，i 后移再进行判断；
     * 如果 str[i] + pivot > pivot + str[i]，说明 pivot 应该在 str[i] 前面；
     *
     * 如果 pivot + str[j] <= str[j] + pivot，说明 pivot 应该在 str[j] 前面，str[j] 大于 pivot，j 前移再进行判断；
     * 如果 pivot + str[j] > str[j] + pivot，说明 pivot 应该在 str[i] 后面；
     */
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        quickSort(str, 0, str.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : str) {
            res.append(s);
        }
        return res.toString();
    }

    private void quickSort(String[] str, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        String p = str[lo];
        int i = lo + 1, j = hi;
        while (true) {
            while (i < hi && (str[i] + p).compareTo(p + str[i]) <= 0) i++;
            while (j > lo && (str[j] + p).compareTo(p + str[j]) >= 0) j--;
            if (i >= j) {
                break;
            }
            swap(str, i, j);
            i++;
            j--;
        }
        swap(str, lo, j);
        quickSort(str, lo, j - 1);
        quickSort(str, j + 1, hi);
    }

    private void swap(String[] str, int i, int j) {
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] arr = {3,30,34,5,9};
        System.out.println(s.minNumber(arr)); // "3033459"
    }
}
