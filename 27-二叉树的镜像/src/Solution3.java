import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Song Ningning
 * @date: 2020-08-14 16:27
 */
public class Solution3 {

    /**
     * 迭代：先序
     */
    static class PreOrder {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                TreeNode leftChild = cur.left;
                cur.left = cur.right;
                cur.right = leftChild;
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
            return root;
        }
    }

    /**
     * 迭代：中序
     */
    static class InOrder {
        public TreeNode mirrorTree(TreeNode root) {
            TreeNode dummy = new TreeNode(-1);
            dummy.left = root;
            Deque<TreeNode> stack = new LinkedList<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                TreeNode leftChild = root.left;
                root.left = root.right;
                root.right = leftChild;
                root = root.left;
            }
            return dummy.left;
        }
    }
}
