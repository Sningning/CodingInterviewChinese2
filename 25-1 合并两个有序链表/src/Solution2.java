/**
 * @author: Song Ningning
 * @date: 2020-06-04 15:20
 */
public class Solution2 {

    /*
     * 改成迭代
     * dummy 的 next 指向归并后的链表的头节点；tail 指向每次归并后的链表的尾节点
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        // 循环条件是 && ，退出循环时，可能一个为空一个不为空
        tail.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
