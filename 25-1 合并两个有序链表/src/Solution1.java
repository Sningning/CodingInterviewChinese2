/**
 * 面试题25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 限制：
 * 0 <= 链表长度 <= 1000
 *
 * 注意：本题与力扣 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @Author: Song Ningning
 * @Date: 2020-06-04 15:11
 */
public class Solution1 {

    /*
     * 第一次合并后，剩下两个链表依然是有序的，可以重复第一次的过程，考虑用递归。
     * 注意输入空结点的情况（两个都为空？其中一个为空？）。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 特判
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
