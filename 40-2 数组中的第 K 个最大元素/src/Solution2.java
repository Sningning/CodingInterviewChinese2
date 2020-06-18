import java.util.PriorityQueue;

/**
 * @Author: Song Ningning
 * @Date: 2020-06-18 17:32
 */
public class Solution2 {
    /**
     * 堆
     * 维护一个容量为 k 的最小堆，数组元素如果比堆顶元素大，则将堆顶元素删除，当前元素加入堆中，每次删除的都是最小的；
     * 剩下的 k 个元素就是数组中最大的 k 个元素，返回堆顶元素即可。
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            if (heap.size() < k) {
                heap.offer(num);
            } else if (num > heap.peek()) {
                heap.poll();
                heap.offer(num);
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] arr1 = {3,2,1,5,6,4};
        int[] arr2 = {3,2,3,1,2,4,5,5,6};
        System.out.println(s.findKthLargest(arr1, 2)); // 5
        System.out.println(s.findKthLargest(arr2, 4)); // 4

    }
}
