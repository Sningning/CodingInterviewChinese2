/**
 * 52-2 两个链表节点的第一个公共结点 II
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 要求：
 * 如果链表 1 的长度为 m，链表 2 的长度为 n，时间复杂度请达到 O(m+n)，额外空间复杂度请达到O(1)。
 *
 * @Author: Song Ningning
 * @Date: 2020-06-29 19:21
 */
public class FindFirstIntersectNode {

    /**
     * 本题中单链表可能有环，也可能无环；这两个链表可能相交，也可能不相交。
     * 首先判断两个链表是否有环：
     *     如果都没有环，则调用两个无环链表求第一个交点的方法；
     *     如果都有环，则调用两个有环链表求第一个交点的方法；
     *     如果一个有环、一个无环，由于是单链表，所以两个链表不可能相交。
     *
     * 现在分析都有环的情况，两个单链表都有环，有 3 种拓扑结构，如图片所示，
     * ① 两个链表各自成环；② 两个链表有唯一一个入环结点；③ 两个链表有两个入环结点。
     *
     * 下面是怎么区分这 3 种结构：
     * loop1 代表 head1 链表的入环结点；loop2 代表 head2 链表的入环结点。
     *     如果 loop1 == loop2，则肯定是第 ② 种结构，第 ② 种结构就可以使用两个无环链表相交的方法，
     * 只不过把 loop1 或 loop2 当做无环链表相交方法中最后的空结点；
     *     如果 loop1 != loop2，则为第 ① 种或第 ③ 种：
     *         从 loop1 开始往下走，如果绕了一圈都没有与 loop2 相遇，则是第 ① 种结构，没有交点；
     *         从 loop1 开始往下走，如果与 loop2 相遇了，则是第 ③ 种结构，返回 loop1 或 loop2。
     *
     */

    /**
     * 找出两个单链表的第一个公共结点
     * @param head1 链表 1 的头结点
     * @param head2 链表 2 的头结点
     * @return head1 和 head2 的第一个公共结点，没有则返回 null
     */
    public static ListNode getIntersectNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        // 获得链表 1 的第一个入环结点 loop1
        ListNode loop1 = getLoopNode(head1);
        // 获得链表 2 的第一个入环结点 loop2
        ListNode loop2 = getLoopNode(head2);
        // 两个单链表均无环
        if (loop1 == null && loop2 == null){
            return noLoop(head1, head2);
        }
        // 两个单链表均有环
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        // 一个有环一个无环，没有交点
        return null;
    }


    /**
     * 返回单链表的第一个入环结点
     * @param head 单链表头结点
     * @return head 的第一个入环结点，没有返回 null
     */
    private static ListNode getLoopNode(ListNode head) {
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    /**
     * 返回两个无环单链表的第一个相交结点
     *
     * 两个链表长度分别为 L1+C、L2+C， C 为公共部分的长度；
     * 第 1 个人走了 L1+C 步后，回到第二个人起点走 L2 步；
     * 第 2 个人走了 L2+C 步后，回到第一个人起点走 L1 步；
     * 当两个人走的步数都为 L1+L2+C 时就两个家伙就相遇了
     * @param head1 链表 1 的头结点
     * @param head2 链表 2 的头结点
     * @return 两个无环单链表的第一个相交结点，没有返回 null
     */
    private static ListNode noLoop(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while (cur1 != cur2) {
            cur1 = cur1 == null ? head2 : cur1.next;
            cur2 = cur2 == null ? head1 : cur2.next;
        }
        return cur1;
    }


    /**
     * 返回两个有环单链表的第一个相交结点
     * @param head1 链表 1 的头结点
     * @param loop1 链表 1 的入环结点
     * @param head2 链表 2 的头结点
     * @param loop2 链表 2 的入环结点
     * @return 链表 1 和链表 2 的第一个相交结点，没有返回 null
     */
    private static ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
        ListNode cur1;
        ListNode cur2;
        // 第 ② 种拓扑结构
        // 和无环链表相交问题类似，将入环结点看做 null
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            if (head1 == null || head2 == null) {
                return null;
            }
            while (cur1 != cur2) {
                // 将入环结点看做 null
                cur1 = cur1 == loop1 ? head2 : cur1.next;
                cur2 = cur2 == loop1 ? head1 : cur2.next;
            }
            return cur1;
        }
        else { // 第 ① 种或第 ③ 种拓扑结构
            cur1 = loop1.next;
            // cur1 在自己的环中转圈
            while (cur1 != loop1) {
                // 如果与 loop2 相遇，则是第 ③ 种拓扑结构
                // 此时返回 loop1 或 loop2 均可
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            // 如果最后 cur1 又转回 loop1
            // 则是第 ① 种拓扑结构，各自成环，不相交
            return null;
        }
    }


    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);

        // 0->9->8->6->7->null
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).val); // 6

        // 1->2->3->4->5->6->7->4...
        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).val); // 2

        // 0->9->8->6->4->5->6..
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).val); // 4
    }
}
