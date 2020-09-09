import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Song Ningning
 * @Date: 2020-06-14 14:19
 */
public class Solution2 {

    /**
     * 迭代
     * Time：O(N) 所有节点遍历一遍
     * Space：O(N)
     */
    public Node treeToDoublyList(Node root) {

        if (root == null)
            return null;
        Node prev = null, head = null;
        Node cur = root;
        Deque<Node> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.poll();
            if (prev == null) {
                head = cur;
            } else {
                prev.right = cur;
                cur.left = prev;
            }
            prev = cur;
            cur = cur.right;
        }
        prev.right = head;
        head.left = prev;
        return head;
    }
}
