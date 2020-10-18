/**
 * @author: Song Ningning
 * @date: 2020-06-03 11:41
 */
public class Solution3 {

    // 递归
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                // 去重
                head = head.next;
            }
            // 此时循环完成后，head 是当前段最后一个重复元素，也应该被删除
            // 所以下面直接递归求解 head.next
            return deleteDuplicates(head.next);
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }
}
