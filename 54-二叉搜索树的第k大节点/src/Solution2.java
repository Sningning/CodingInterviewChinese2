import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Song Ningning
 * @Date: 2020-07-01 11:05
 */
public class Solution2 {

    /**
     * 迭代
     * 将中序遍历代码中访问左右结点的顺序颠倒
     */
    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            if (k == 1) {
                return node.val;
            }
            k--;
            node = node.left;
        }
        return -1;
    }
}
