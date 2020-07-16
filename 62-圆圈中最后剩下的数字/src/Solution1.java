import java.util.ArrayList;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出: 3
 *
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 * 限制：
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 *
 * @author: Song Ningning
 * @date: 2020-07-16 19:06
 */
public class Solution1 {

    /**
     * 假设当前删除的位置是 idx，下一个删除的数字的位置是 idx + m。但是，由于把当前位置的数字删除了，
     * 后面的数字会前移一位，所以实际的下一个位置是 idx + m - 1。由于数到末尾会从头继续数，所以最后取模一下，
     * 就是 (idx + m - 1) mod n。
     *
     * Java 中使用 LinkedList 会超时，用 ArrayList 可以通过，ArrayList 的 remove 操作在后续移位的时候，其实是内存连续空间的拷贝的！
     * 所以相比于 LinkedList 大量非连续性地址访问，ArrayList 的性能还可以。
     *
     * 时间复杂度：O(N^2)
     */
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i);
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
