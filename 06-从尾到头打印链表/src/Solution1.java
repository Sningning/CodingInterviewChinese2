import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * @Author: Song Ningning
 * @Date: 2020-05-15 22:44
 */
public class Solution1 {

    public int[] reversePrint(ListNode head) {

        // 栈
        // Time：O(N)；Space：O(N)

        if (head == null)
            return new int[0];
        Deque<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }
}
