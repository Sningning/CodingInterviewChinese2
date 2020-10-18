import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Song Ningning
 * @date: 2020-07-01 16:03
 */
public class Solution2 {

    /**
     * 层序遍历（BFS）
     * 计算层数，每遍历完一层，计数器加一
     *
     * 时间复杂度：O(N)；
     * 空间复杂度：O(N)；
     */
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null){
            return depth;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
