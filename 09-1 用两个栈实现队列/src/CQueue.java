import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题09. 用两个栈实现队列
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * @Author: Song Ningning
 * @Date: 2020-05-16 21:54
 */
public class CQueue {

    /**
     * 队列特点是先进先出，栈的特点是后进先出。
     * 如果执行出队操作，必须把该元素后面所有的元素暂存，然后将该元素删除，
     * 准备两个栈，pushStack 和 popStack 栈，pushStack 专门用来执行添加数据，popStack 专门用来删除数据。
     * 如果执行入队操作，直接向 pushStack 中添加即可；
     * 如果执行出队操作，则从 popStack 中删除元素：
     *     如果两个栈均为空，返回 -1；
     *     如果 popStack 为空，需要把 pushStack 中所有元素依次弹出，再依次压入 popStack 中，最后从 popStack 中弹出元素；
     *     如果 popStack 不为空，则直接从 popStack 中弹出栈顶元素即可。
     */

    private Deque<Integer> pushStack;
    private Deque<Integer> popStack;

    public CQueue() {
        pushStack = new LinkedList<>();
        popStack = new LinkedList<>();
    }

    public void appendTail(int value) {
        pushStack.push(value);
    }

    public int deleteHead() {
        if (pushStack.isEmpty() && popStack.isEmpty())
            return -1;
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty())
                popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }
}
