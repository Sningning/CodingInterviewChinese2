import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Song Ningning
 * @date: 2020-06-06 19:40
 */
public class Solution2 {

    // 迭代

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null)
                continue; // 注意
            if (node1 == null || node2 == null)
                return false;
            if (node1.val != node2.val)
                return false;
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }
}
