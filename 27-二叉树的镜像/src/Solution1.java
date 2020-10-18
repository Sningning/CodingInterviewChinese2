/**
 * 面试题27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 *     输入：              镜像输出：
 *      4                   4
 *    /   \               /   \
 *   2     7             7     2
 *  / \   / \           / \   / \
 * 1   3 6   9         9   6 3   1
 *
 * 限制：
 * 0 <= 节点个数 <= 1000
 *
 * 注意：本题与力扣 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author: Song Ningning
 * @date: 2020-06-05 11:11
 */
public class Solution1 {

    /*
     * 从图示可以看出，就是左右节点交换
     * 可以先交换当前节点的左右孩子，然后再递归交换左右孩子的两个子树（前序）
     * 或者从底往上，从叶子节点开始交换，最后交换根节点（后序）
     * 中序也可以，先操作 root 的左子树，然后交换 root 的左右孩子，最后操作 root 之前的右孩子（现在已经成了左孩子）
     */

    /**
     * 前序
     */
    static class PreOrder {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null)
                return null;

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            mirrorTree(root.left);
            mirrorTree(root.right);
            return root;
        }
    }

    /**
     * 后序
     */
    static class PostOrder {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null)
                return null;

            mirrorTree(root.left);
            mirrorTree(root.right);

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            return root;
        }
    }

    /**
     * 中序
     * 中序遍历有个陷阱，完成 root 左子树交换，再交换 root 的左右孩子；
     * 此时注意 root 之前的左孩子变成了右孩子，之前的右孩子变成了左孩子；
     * 所以第二次想操作之前的右孩子时，实际是在现在的左孩子上进行操作
     */
    static class InOrder {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null)
                return null;

            mirrorTree(root.left);

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            mirrorTree(root.left);

            return root;
        }
    }
}
