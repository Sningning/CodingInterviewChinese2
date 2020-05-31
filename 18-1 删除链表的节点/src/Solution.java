/**
 * 面试题18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 【注意：此题对比原题有改动】
 *
 * 说明：
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 *
 * @Author: Song Ningning
 * @Date: 2020-05-31 21:32
 */
public class Solution {

    /**
     * Time：O(N)
     * Space：O(1)
     */

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
                break;
            }
            prev = prev.next;
        }
        return dummy.next;
    }
}
