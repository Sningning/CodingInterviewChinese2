import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @Author: Song Ningning
 * @Date: 2020-06-12 15:08
 */
public class Solution1 {

    /**
     * 递归回溯
     */

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null) {
            return res;
        }
        List<Integer> path = new LinkedList<>();
        backtrack(root, sum, path);
        return res;
    }

    private void backtrack(TreeNode node, int sum, List<Integer> path) {
        // 递归终止条件：到达了根节点且满足条件
        if (node.left == null && node.right == null && node.val == sum) {
            path.add(node.val);
            res.add(new LinkedList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        // 递归终止条件：到达了根节点但不满足条件
        // 不加该判断也可以，只不过加上判断后，可以提前退出，不需要再进行后面的递归操作
        if (node.left == null && node.right == null) {
            return;
        }

        // 能运行到这里，说明 node 不是根节点，将当前节点的值加入 path
        path.add(node.val);

        // 左孩子不为空就继续走
        if (node.left != null) {
            backtrack(node.left, sum - node.val, path);
        }
        // 右孩子不为空就继续走
        if (node.right != null) {
            backtrack(node.right, sum - node.val, path);
        }
        path.remove(path.size() - 1);
    }
}
