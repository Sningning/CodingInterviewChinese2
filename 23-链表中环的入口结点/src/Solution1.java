import java.util.HashSet;
import java.util.Set;

/**
 * 面试题23. 链表中环的入口节点
 * 给一个链表，若其中包含环，请找出该链表的环的入口节点，否则，输出null。
 *
 * 注意：本题与力扣 142 题相同：https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @Author: Song Ningning
 * @Date: 2020-06-03 10:22
 */
public class Solution1 {

    /*
     * 哈希表
     * Time：O(N)
     * Space：O(N)
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (set.contains(node))
                return node;
            set.add(node);
            node = node.next;
        }
        return null;
    }
}
