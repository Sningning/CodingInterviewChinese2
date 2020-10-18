import java.util.PriorityQueue;

/**
 * @author: Song Ningning
 * @date: 2020-06-20 13:45
 */
public class Solution2 {

    /**
     * 之前是为了维护两个堆中的数量相差不超过 1，是在插入元素后进行调整，也可以在插入时选择轮流插入。
     * 比如当总元素个数是偶数个时，往大顶堆插入；当总元素个数是奇数个时，往小顶堆插入。
     *
     * 当总元素个数是偶数个时，应该是往大顶堆插，但是如果新元素 num > 小顶堆堆顶元素，其实应该插入小顶堆，
     * 但是为了维护平衡，需要先从小顶堆中取出堆顶元素放入大顶堆，然后再把新元素插入小顶堆；
     *
     * 当总元素个数是奇数个时，应该是往小顶堆插，但是如果新元素 num <= 大顶堆堆顶元素，其实应该插入大顶堆，
     * 但是为了维护平衡，需要先从大顶堆中取出堆顶元素放入小顶堆，然后再把新元素插入大顶堆；
     *
     */

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int count = 0;

    /** initialize your data structure here. */
    public Solution2() {}

    public void addNum(int num) {
        // 偶数个往大顶堆插入
        if ((count & 1) == 0) {
            if (!minHeap.isEmpty() && minHeap.peek() < num) {
                int oldMin = minHeap.poll();
                minHeap.offer(num);
                num = oldMin;
            }
            maxHeap.offer(num);
        } else { // 奇数个往小顶堆插入
            if ((!maxHeap.isEmpty() && maxHeap.peek() > num)) {
                int oldMax = maxHeap.poll();
                maxHeap.offer(num);
                num = oldMax;
            }
            minHeap.offer(num);
        }
        count++;
    }

    public double findMedian() {
        if ((count & 1) == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return (double) maxHeap.peek();
    }


    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.addNum(-1);
        s.findMedian();
        s.addNum(-2);
        s.findMedian();
    }
}
