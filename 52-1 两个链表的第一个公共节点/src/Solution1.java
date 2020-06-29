import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @Author: Song Ningning
 * @Date: 2020-06-29 12:10
 */
public class Solution1 {

    /**
     * 双栈
     *
     * 根据题意可知：两个链表为单链表，因此如果有公共结点，形状肯定是 Y 型，不会是 X 型，
     * 因为相交结点只有一个 next 指针。
     * 如果有公共结点，从公共结点往后只有一条链，因此可以从后往前比较。
     * 使用两个栈，首先将两个链表结点入栈，然后依次弹出栈顶结点，进行比较：
     * 如果相同，接着弹出比较，知道找到最后一个相同的结点。
     *
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(m + n)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 不进行此项判断，下面的 while 会造成死循环
        if (headA == headB) {
            return headA;
        }
        Deque<ListNode> stackA = new LinkedList<>();
        Deque<ListNode> stackB = new LinkedList<>();
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            stackA.push(curA);
            curA = curA.next;
        }
        while (curB != null) {
            stackB.push(curB);
            curB = curB.next;
        }
        curA = stackA.poll();
        curB = stackB.poll();
        ListNode res = null;
        while (curA == curB) {
            res = curA;
            if (!stackA.isEmpty()) {
                curA = stackA.poll();
            }
            if (!stackB.isEmpty()) {
                curB = stackB.poll();
            }
        }
        return res;
    }
}
