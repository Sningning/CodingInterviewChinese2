/**
 * @author: Song Ningning
 * @date: 2020-08-09 22:54
 */
public class Solution2 {
    
    /**
     * 递归
     */

    // 第 n 个节点的后继节点
    static ListNode succ = null;
    public static ListNode reverseList(ListNode head, int n) {
        if (n == 1) {
            succ = head.next;
            return head;
        }
        ListNode last = reverseList(head.next, n - 1);
        head.next.next = head;
        head.next = succ;
        return last;
    }

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
