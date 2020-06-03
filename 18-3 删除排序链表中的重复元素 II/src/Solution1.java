/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现的数字。
 *
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @Author: Song Ningning
 * @Date: 2020-06-03 10:39
 */
public class Solution1 {

    /*
     * 也类似于双指针
     * cur 从虚拟头结点开始遍历链表，
     *     用 cur.next 和 cur.next.next 比较是因为要记录第一个重复元素前面那个元素，以便后面拼接
     *     if cur.next.val != cur.next.next.val: 直接判断下一个
     *     if cur.next.val == cur.next.next.val
     *         用 node 辅助找到最后一个重复元素，即只要 node 的值和其下一个结点的值相等，就一直执行 node = node.next
     *         找到最后一个重复元素时，通过 cur.next = node.next，跳过中间重复结点
     *         注意：如果链表后面的结点都是相同的，在 node = node.next 过程中可能会越界，当 node.next == null 时，到了最后，
     *              此时 node 指向尾结点
     *     最后返回 dummy.next
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode node;
        while (cur.next != null && cur.next.next != null) {

            if (cur.next.val == cur.next.next.val) {
                // node 此时指向第一个重复的结点；
                // cur 指向第一个重复结点前面的那个结点
                node = cur.next;
                // 如果最后几个元素都是重复元素，node 可能会越界，用 node.next != null 保证不会越界
                while (node.next != null && node.val == node.next.val)
                    node = node.next;
                // while 循环结束后 node 指向最后一个重复结点
                // 跨过重复结点，进行连接
                cur.next = node.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
