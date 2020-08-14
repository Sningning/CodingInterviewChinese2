import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Song Ningning
 * @Date: 2020-06-05 11:43
 */
public class Solution2 {

    /**
     * 层序遍历
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 取出队首结点，交换他的左右子树
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            // 队首结点的左孩子入队，准备下一轮交换它的左右子树
            if (node.left != null)
                queue.add(node.left);
            // 队首结点的左孩子入队，准备下一轮交换它的左右子树
            if (node.right != null)
                queue.add(node.right);
        }
        return root;
    }

}
