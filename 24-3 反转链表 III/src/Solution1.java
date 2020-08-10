/**
 * 反转链表 III
 * 实现一个反转链表前 n 个节点的方法。
 *
 * 说明:
 * 1 ≤ n ≤ 链表长度。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL, n = 3
 * 输出: 3->2->1->4->5->NULL
 *
 * @author: Song Ningning
 * @date: 2020-08-09 22:50
 */
public class Solution1 {

    /**
     * 迭代
     */
    public static ListNode reverseList(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy.next;
        for (int i = 0; i < n - 1; i++) {
            ListNode removed = cur.next;
            cur.next = cur.next.next;

            removed.next = dummy.next;
            dummy.next = removed;
        }

        return dummy.next;
    }

    // for test
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        print(head);
        System.out.println();
        print(reverseList(head, 4));
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
