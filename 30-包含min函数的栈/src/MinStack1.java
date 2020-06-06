import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 注意：本题与力扣 155 题相同：https://leetcode-cn.com/problems/min-stack/
 *
 * @Author: Song Ningning
 * @Date: 2020-06-06 20:18
 */
public class MinStack1 {

    /*
     * 第一种思路：双栈
     * 准备两个栈，dataStack 和 minStack。
     *
     * push 操作：
     * 每次来一个新元素，先入 dataStack，然后比较新元素与 minStack 栈顶元素大小：
     *     如果新元素 <= minStack 栈顶元素：将新元素压入 minStack
     *     如果新元素 > minStack 栈顶元素：将 minStack 栈顶元素在压入一次 minStack 中
     * pop 操作：
     * 同时弹出两个栈的栈顶元素
     * top 操作：
     * 返回 dataStack 栈顶元素
     * min 操作：
     * 返回 minStack 栈顶元素
     */

    Deque<Integer> dataStack;
    Deque<Integer> minStack;

    public MinStack1() {
        dataStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty())
            minStack.push(x);
        else
            minStack.push(x <= minStack.peek() ? x : minStack.peek());
    }

    public void pop() {
        if (dataStack.isEmpty())
            throw new RuntimeException("Stack is empty.");
        dataStack.pop();
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
