import java.util.PriorityQueue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 示例 1：
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 *
 * 示例 2：
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *
 * 限制：
 * 最多会对 addNum、findMedia进行 50000 次调用。
 * 注意：本题与力扣 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-stream/
 *
 * @author: Song Ningning
 * @date: 2020-06-19 11:18
 */
public class Solution1 {

    /**
     * 如果用未排序数组的话，插入元素是 O(1)，但是每次获得中位数，必须对已有元素排序，时间复杂度为 O(NlogN)；
     * 如果用排序数组，插入元素就排序，插入操作为 O(NlogN)，获得中位数的操作为 O(1)；
     *
     * 求中位数的时候，整个数据流被分为两部分，左半部分数据小于右半部分数据。
     * 因此，如果有两个容器 A、B，容器 A 装左半部分数据，B 装右半部分数据，即使两个容器中元素是无序的，但只要能保证可
     * 以快速得到 A 中的最大值和 B 中的最小值，就可以计算出中位数。能快速获取一组元素的最大值和最小值的数据结构就是堆。
     *
     * 因此维护一个大根堆 A 和一个小根堆 B，A 中装左半部分数据，堆顶元素是左侧数据的最大值；B 中装右半部分数据，堆顶元素是右侧数据的最小值。
     * 因为要取中位数，如果元素个数为偶数个时，需要保证两个堆中元素数量相等，此时的中位数就是两个堆顶元素的平均值；
     * 如果元素个数为奇数个时，需要保证两个堆中元素数量只能相差 1，此时的中位数就是元素较多的堆的堆顶元素。
     * 因此添加元素时，还应同时维护两个堆的大小，保证两个堆中元素个数之差不能超过 1。
     *
     * 添加新元素 num 时：
     *   如果堆 A 为空或 A 的堆顶元素 >= num，直接将 num 放入 A 中；
     *   如果不满足上面条件，即 A 不空，A 的堆顶元素 < num，进行下面的操作
     *     如果堆 B 为空或堆 B 的堆顶元素 <= num，直接将 num 放入 B 中；
     *     如果堆 B 的堆顶元素 > num，同时 A 的堆顶元素 < num，即 A 的堆顶元素 < num < B 的堆顶元素，此时可以将 num 放入任意一个堆中，
     *     因为无论放入 A 还是 B，num 一定是堆顶元素，最后再进行统一调整即可。
     *   添加完元素后，判断是否需要调整结构
     *
     */

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    /** initialize your data structure here. */
    public Solution1() {}

    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
        } else if (maxHeap.peek() >= num) {
            maxHeap.offer(num);
        } else if (minHeap.isEmpty()) {
            minHeap.offer(num);
        } else if (minHeap.peek() <= num) {
            minHeap.offer(num);
        } else { // maxHeap.peek() < num < minHeap.peek()
            // 这种情况下，放入任意一个堆中都可以
            // 这里选择放入大根堆
            maxHeap.offer(num);
        }
        modifyTwoHeapsSize();
    }

    private void modifyTwoHeapsSize() {
        if (maxHeap.size() == minHeap.size() + 2) {
            minHeap.offer(maxHeap.poll());
        }
        else if (minHeap.size() == maxHeap.size() + 2) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        int count = maxHeap.size() + minHeap.size();
        if ((count & 1) == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
    }
}
