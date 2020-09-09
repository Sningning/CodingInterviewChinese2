import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: Song Ningning
 * @date: 2020-06-18 11:15
 */
public class Solution2 {

    /**
     * Top K 问题一个经典解法是使用【堆】这种数据结构。
     *
     * 堆的性质是每次可以找出最大或最小的元素。
     * 可以使用一个大小为 k 的最大堆（大顶堆），将数组中的元素依次入堆，当堆的大小超过 k 时，便将多出的元素从堆顶弹出。
     * 这样，由于每次从堆顶弹出的数都是堆中最大的，最小的 k 个元素一定会留在堆里。
     * 把数组中的元素全部入堆之后，堆中剩下的 k 个元素就是最大的 k 个数了。
     *
     * 空间复杂度：O(k), 堆的大小为 k
     * 时间复杂度：O(Nlogk)，大小为 k 的堆的插入和删除是 O(logk)，最坏情况下，每个元素都会插入。
     *
     * 如果使用小根堆的话需要把全部的元素都入堆，然后取 k 次堆顶元素，时间复杂度：O(NlogN)
     *
     * 使用 Java 中的 PriorityQueue 实现
     * Java 中的 PriorityQueue 默认是最小堆，可以使用
     * public PriorityQueue(int initialCapacity, Comparator<? super E> comparator) 构造方法，
     * 实现定制排序。
     *
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }
        if (arr.length <= k) {
            return arr;
        }
        Queue<Integer> heap = new PriorityQueue<>(((o1, o2) -> (o2 - o1)));
        for (int num : arr) {
            if (heap.size() < k) {
                heap.offer(num);
            } else if (num < heap.peek()) {
                heap.poll();
                heap.offer(num);
            }
        }
        int[] res = new int[heap.size()];
        int index = 0;
        for (int num : heap) {
            res[index++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr1 = {3,2,1};
        int[] arr2 = {0,1,2,1};
        int[] res1 = s.getLeastNumbers(arr1, 2);
        for (int num : res1) {
            System.out.print(num + " ");
        }
        System.out.println();
        int[] res2 = s.getLeastNumbers(arr2, 2);
        for (int num : res2) {
            System.out.print(num + " ");
        }
    }
}
