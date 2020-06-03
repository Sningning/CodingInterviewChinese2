/**
 * 面试题22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 * @Author: Song Ningning
 * @Date: 2020-06-03 9:16
 */
public class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {

        /*
         * 双指针
         * i 和 j，由于倒数第一个结点是尾结点，所以先让 j 领先 i k 个结点，然后 i 和 j 一起往后走，
         * j 走到空结点，此时 i 结点对应的就是所求结点。
         *
         * i
         * 1,2,3,4,5 （k=2）
         *     j
         *       i
         * 1,2,3,4,5 （k=2）
         *           j
         *
         * Time：O(N)
         * Space：O(1)
         */

        // 特判
        if (head == null || k == 0)
            return null;
        ListNode former = head;
        ListNode latter = head;
        for (int i = 0; i < k; i++) {
            // 注意：防止 k 大于链表长度结点个数，导致越界
            if (former == null)
                return null;
            former = former.next;
        }
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
