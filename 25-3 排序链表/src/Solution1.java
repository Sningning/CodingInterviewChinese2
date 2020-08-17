/**
 * 148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * https://leetcode-cn.com/problems/sort-list/
 *
 * @author: Song Ningning
 * @date: 2020-08-17 17:54
 */
public class Solution1 {

    /**
     * 归并排序（递归），递归不符合空间复杂度要求。
     *
     * 归并排序分为两个步骤：分割、合并
     *
     * 时间复杂度：O(nlogn)，递归：O(logn)，merge过程：O(n)
     * 空间复杂度：O(logn)
     */

    public ListNode sortList(ListNode head) {
        // 如果为空或只有一个节点，返回
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        // 找到中间节点。如果是奇数个，找到中间的节点；如果是偶数个，找到靠左的节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // cut
        ListNode rightHead = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(rightHead));
    }

    // merge
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                ListNode tmp = l1;
                l1 = l2;
                l2 = tmp;
            }
            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
        }
        // 如果一个为空，一个不为空，直接将不为空的挂在后面
        tail.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }
}
