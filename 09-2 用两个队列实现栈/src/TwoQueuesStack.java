import java.util.LinkedList;
import java.util.Queue;

/**
 * 仅用队列结构实现栈结构
 *
 * @Author: Song Ningning
 * @Date: 2020-06-30 9:13
 */
public class TwoQueuesStack {

    /**
     * 思路：利用两个队列，入栈时，只向 queue 队列入队，
     * 执行 peek 操作时：先将 queue 队列中元素逐个出队放到 help 队列中，只剩队尾元素，将剩下的元素返回，
     *                因为是 peek 操作，还需将其再加入到 help 队列中，然后交换两个队列的角色；
     * 执行 pop 操作时：与 peek 操作一样，只不过不需要将返回元素再压入 help 栈中
     *
     */

    private Queue<Integer> queue;
    private Queue<Integer> help;

    public TwoQueuesStack() {
        this.queue = new LinkedList<>();
        this.help = new LinkedList<>();
    }

    public void push(int num) {
        queue.offer(num);
    }

    public int peek() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        while (queue.size() != 1) {
            help.offer(queue.poll());
        }
        int res = queue.poll();
        help.offer(res);
        swap();
        return res;
    }

    public int pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        while (queue.size() != 1) {
            help.offer(queue.poll());
        }
        int res = queue.poll();
        swap();
        return res;
    }

    private void swap() {
        Queue<Integer> temp = queue;
        queue = help;
        help = temp;
    }
}
