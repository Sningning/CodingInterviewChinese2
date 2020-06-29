/**
 * @Author: Song Ningning
 * @Date: 2020-06-29 17:01
 */
public class Solution3 {

    /**
     * 双指针
     *
     * 假设两个链表有交点，A 链表从头结点到相交结点长度为 a，B 链表从头结点到相交结点长度为 b，相交节点到尾结点长度为 c。
     * 两个指针 curA 和 curB，首先遍历两个链表，如果 curA 先走到了空，则令 curA 指向 B 的头结点，然后继续走，某个时刻，
     * curB 走到了空，则令 curB 指向 A 的头结点，继续走，直到 curA = curB。
     * 此时 curA 走过的路程为 a+c+b，curB 走过的路程为 b+c+a。
     *
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}
