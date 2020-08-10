/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *
 * @author: Song Ningning
 * @date: 2020-08-09 20:27
 */
public class Solution {

    /**
     * 迭代
     * 先找到第 m 个节点的前驱节点，记为 prev，然后找到第 m 个节点，记为 cur；
     * 然后将 cur 后面的 m-n 个节点依次先断开，然后依次插入到 prev 后面。
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = dummy.next;
        // 找到第 m 个节点的前驱节点和第 m 个节点
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
            cur = cur.next;
        }
        // 将第 m 个节点后面的 m-n 个节点依次作为 prev 的后继节点插入
        for (int i = 0; i < n - m; i++) {
            // 先保存待删除的节点
            ListNode removed = cur.next;
            // 跨过待删除的节点
            cur.next = cur.next.next;

            // 将待删除节点插入到 prev 后面
            removed.next = prev.next;
            prev.next = removed;
        }
        return dummy.next;
    }
}
