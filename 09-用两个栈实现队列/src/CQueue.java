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

    Deque<Integer> pushStack;
    Deque<Integer> popStack;

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
