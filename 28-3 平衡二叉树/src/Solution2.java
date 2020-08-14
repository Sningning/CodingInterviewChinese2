/**
 * @author: Song Ningning
 * @date: 2020-08-14 21:27
 */
public class Solution2 {

    public boolean isBalanced(TreeNode root) {
        return getTreeDepth(root) != -1;
    }

    /**
     * 以 root 为根的二叉树的最大深度
     * @param root
     * @return 二叉树的最大最大深度，如果左右节点高度相差超过 1，返回 -1
     */
    private int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getTreeDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getTreeDepth(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
