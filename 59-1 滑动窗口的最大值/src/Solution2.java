import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 提示：
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * @Author: Song Ningning
 * @Date: 2020-07-09 8:44
 */
public class Solution2 {

    /**
     * 单调队列保存索引
     *
     * 从队首到队尾元素递减，这样队首元素就是最大值，当有新元素要入队时，先和队尾元素比较：
     *     ① 当前值 <= 队尾元素，直接将当前元素插入队尾；
     *     ② 当前值 > 队尾元素，先将队尾元素出队，然后继续比较队尾元素，直到 <= 队尾元素或者队列为空。
     * 因为如果“当前考虑的数”比之前来的数还要大，那么之前的数（如果还没有划出“滑动窗口”）就一定不会是“滑动窗口”的最大值，应该把它们移除。
     * 如果当前元素成功入队，则该窗口中的最大元素激就是队首元素，但是首先应当判断队首元素是否属于当前窗口，
     * 如果不在当前窗口内，则需要将队首最大值删除，删除后队首才是所需要的最大值。
     *
     * 为了判断队首元素是都有效，需要保留其索引信息，因此队列中记录索引，因为值是可以通过数组方便获取。
     *
     * 时间复杂度：O(N)，线性遍历 nums 占用 O(N)；每个元素最多仅入队和出队一次，因此单调队列 dequed 占用 O(2N)
     * 空间复杂度：O(k)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果队尾代表的数小则需要依次弹出，直至满足要求
            while (!queue.isEmpty() && nums[i] > nums[queue.peekFirst()]) {
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (queue.peekFirst() < i - k + 1) {
                queue.pollFirst();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
