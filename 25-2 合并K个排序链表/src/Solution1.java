import java.util.PriorityQueue;

/**
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @author: Song Ningning
 * @date: 2020-08-10 11:07
 */
public class Solution1 {

    /**
     * 小根堆
     *
     * 使用小根堆结构，首先将所有链表的头节点放入堆中，然后弹出堆顶节点，再将弹出节点的下一个节点放入堆中。
     * 每次弹出的都是堆中最小的节点，依次连接即可。注意：由于放入堆中的是自定义链表，因此要定义比较器，使用链表的值进行比较。
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> (o1.val - o2.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            tail.next = minNode;
            tail = tail.next;
            if (minNode.next != null) {
                queue.offer(minNode.next);
            }
        }
        return dummy.next;
    }
}
