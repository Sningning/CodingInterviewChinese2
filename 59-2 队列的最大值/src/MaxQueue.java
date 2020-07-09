import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 *
 * 示例 2：
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *
 * 限制：
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 * @Author: Song Ningning
 * @Date: 2020-07-09 18:45
 */

/**
 * 对于一个普通队列，push_back 和 pop_front 的时间复杂度都是 O(1)，因此直接使用队列的相关操作就可以实现这两个函数.
 * 对于 max_value 函数，通常会这样思考，即每次入队操作时都更新最大值：但是当出队时，这个方法会造成信息丢失，即当最大值出队后，
 * 我们无法知道队列里的下一个最大值。
 *
 * 解题思路
 * 为了解决上述问题，我们只需记住当前最大值出队后，队列里的下一个最大值即可。
 * 使用一个辅助双端队列，保证双端队列头部是最大元素，依次递减，每次来新元素时，先和队尾元素比较，如果小于等于队尾元素，直接入队；
 * 如果大于队尾元素，先将队尾元素出队，再与此时的队尾元素比较，直到等于或小于队尾元素，此时再将新元素入队。
 *
 * max_value：O(1)，直接返回双端队列（或数组）头部的元素。
 *
 * pop_front：O(1)，从队列中弹出一个元素，仍然是常数时间复杂度。
 *
 * push_back：O(1)，例如 543216，只有最后一次 push_back 操作是 O(n)，其他每次操作的时间复杂度都是 O(1)，均摊时间复杂度为
 * (O(1) × (n−1) + O(n)) / n = O(1)。
 *
 */
public class MaxQueue {

    Queue<Integer> queue;
    Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && value > deque.peekLast()) {
            deque.pollLast();
        }
        deque.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int ret = queue.poll();
        if (ret == deque.peekFirst()) {
            deque.pollFirst();
        }
        return ret;
    }
}
/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
