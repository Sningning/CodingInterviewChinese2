/**
 * @author: Song Ningning
 * @date: 2020-08-01 17:40
 */
public class Solution2 {
    /**
     * 递归
     * 递归函数返回的不重复子链的头结点，在回溯过程中，比较当前节点和子链头结点的val是否相同，
     * 若相同则保留当前节点（删除子链的头结点）。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            head.next = head.next.next;
        }
        return head;
    }
}
