import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Song Ningning
 * @Date: 2020-06-06 20:53
 */
public class MinStack3 {

    /*
     * 第三种思路：一个栈
     * 只需要一个栈 stack 和一个变量 min，min 中保存最小值
     *
     * push 操作：
     * 由于只有一个变量保存最小值，如果 pop 的元素刚好是最小值，min 需要更新为次小元素，但是次小元素已经丢失了，
     * 为了保证次小元素不会丢失，需要备份。具体操作：
     * 每次来一个新元素，先比较新元素与 min 的大小：
     *     如果新元素 <= min：先将 min 压入 stack，然后再更新 min；(为什么取等号和之前分析一样)
     *     如果新元素 > min：新元素直接压入 stack
     * pop 操作：
     * 先比较被弹出的元素的大小与 min 的大小
     *     如果被弹出元素 > min：直接弹出
     *     如果被弹出元素 = min：再一次弹出 stack 栈顶元素，该元素是之前最小值的备份，然后用该值更新 min
     * top 操作：
     * 返回 stack 栈顶元素
     * min 操作：
     * 返回 min
     */

    Deque<Integer> stack;
    Integer min;

    public MinStack3() {
        stack = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {  // 注意等号
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.isEmpty())
            throw new RuntimeException("Stack is empty.");
        if (stack.pop().equals(min))
            min = stack.pop();
    }

    public int top() {
        if (stack.isEmpty())
            throw new RuntimeException("Stack is empty.");
        return stack.peek();
    }

    public int min() {
        if (stack.isEmpty())
            throw new RuntimeException("Stack is empty.");
        return min;
    }
}
