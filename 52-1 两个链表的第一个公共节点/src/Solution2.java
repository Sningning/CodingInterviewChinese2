/**
 * @Author: Song Ningning
 * @Date: 2020-06-29 16:16
 */
public class Solution2 {

    /**
     * 双指针
     * 分别遍历两个链表，定义 countA 和 countB 记录两个链表的长度，再定义 tailA 和 tailB 记录两个链表的尾节点。
     * 如果两个尾节点不同，链表肯定不相交；
     * 如果尾节点相同，计算两个链表的长度差 n，先在较长的链表上走 n 个节点，然后同时走，两个指针肯定会在第一个交点处相交。
     *
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(1)
     */

    static class IntersectionNode1 {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode curA = headA;
            ListNode curB = headB;
            ListNode tailA = null;
            ListNode tailB = null;
            int countA = 0;
            int countB = 0;
            while (curA != null) {
                countA++;
                tailA = curA;
                curA = curA.next;
            }
            while (curB != null) {
                countB++;
                tailB = curB;
                curB = curB.next;
            }
            // 如果尾节点不同，肯定不相交
            if (tailA != tailB) {
                return null;
            }
            // curA 指向较长的链表，curB 指向较短的链表
            curA = countA > countB ? headA : headB;
            curB = curA == headA ? headB : headA;
            // 在长链表上先走
            int count = Math.abs(countA - countB);
            while (count != 0) {
                count--;
                curA = curA.next;
            }
            // 一起走
            while (curA != curB) {
                curA = curA.next;
                curB = curB.next;
            }
            return curA;
        }
    }

    /**
     * 另一种写法
     */
    static class IntersectionNode2 {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode curA = headA;
            ListNode curB = headB;
            int count = 0;
            // 这里判断条件改为 curA.next != null
            // 因此 count 最终会比实际链表长度小一个
            // 不过由于下面的条件也是 curB.next != null
            // 因此长度差保持不变
            while (curA.next != null) {
                count++;
                curA = curA.next;
            }
            while (curB.next != null) {
                count--;
                curB = curB.next;
            }
            // 如果尾节点不同，肯定不相交
            if (curA != curB) {
                return null;
            }
            // curA 指向较长的链表，curB 指向较短的链表
            curA = count > 0 ? headA : headB;
            curB = curA == headA ? headB : headA;
            // 在长链表上先走
            count = Math.abs(count);
            while (count != 0) {
                count--;
                curA = curA.next;
            }
            // 一起走
            while (curA != curB) {
                curA = curA.next;
                curB = curB.next;
            }
            return curA;
        }
    }
}
