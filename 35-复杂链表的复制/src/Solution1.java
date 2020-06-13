import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 面试题35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 提示：
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *  
 * 注意：本题与力扣 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 *
 * @Author: Song Ningning
 * @Date: 2020-06-13 14:50
 */
public class Solution1 {
    /**
     * 方法一：哈希表
     * 哈希表中的 key 存源结点，value 存源结点的拷贝；
     * 第一次遍历链表，将每个源结点和其拷贝存入哈希表中；
     * 第二次遍历链表，完成每个结点 next 和 random 指针的连接.
     *
     * Time：O(N)
     * Space：O(N)
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new LinkedHashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            // 拷贝结点的 next = 源节点的 next 对应的 value
            map.get(cur).next = map.get(cur.next);
            // 拷贝结点的 random = 源节点的 random 对应的 value
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
