import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Song Ningning
 * @date: 2020-06-06 20:38
 */
public class MinStack2 {

    /*
     * 第二种思路：双栈
     * 准备两个栈，dataStack 和 minStack。
     *
     * push 操作：
     * 每次来一个新元素，先入 dataStack，然后比较新元素与 minStack 栈顶元素大小：
     *     如果新元素 <= minStack 栈顶元素：将新元素压入 minStack
     *         (之所以取到等号，即再压入一次 minStack，是因为如果该元素被弹出，minStack 栈顶元素如果与它相等，也会被弹出，
     *         但是 dataStack 中可能还会有和它相同的数据，而那个数据也是当前最小元素，但此时由于在 minStack 中只存了一个，
     *         且被弹出，所以此时 minStack 栈顶元素已经不是最小值了)
     *     如果新元素 > minStack 栈顶元素：什么都不做
     * pop 操作：
     * 弹出 dataStack 栈顶元素，同时比较被弹出的元素的大小与 minStack 栈顶元素的大小
     *     如果被弹出元素 = minStack 栈顶元素：弹出 minStack 栈顶元素
     *     如果被弹出元素 > minStack 栈顶元素：什么都不做
     *     如果被弹出元素 < minStack 栈顶元素：这种情况不存在，因为 minStack 栈顶元素一直保证是最小的元素
     * top 操作：
     * 返回 dataStack 栈顶元素
     * min 操作：
     * 返回 minStack 栈顶元素
     */

    Deque<Integer> dataStack;
    Deque<Integer> minStack;

    public MinStack2() {
        dataStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek())  // 注意等号
            minStack.push(x);
    }

    public void pop() {
        if (dataStack.isEmpty())
            throw new RuntimeException("Stack is empty.");
        if (dataStack.pop().equals(minStack.peek()))
            minStack.pop();
    }

    public int top() {
        if (dataStack.isEmpty())
            throw new RuntimeException("Stack is empty.");
        return dataStack.peek();
    }

    public int min() {
        if (dataStack.isEmpty())
            throw new RuntimeException("Stack is empty.");
        return minStack.peek();
    }
}
