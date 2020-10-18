import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例:
 * 你可以将以下二叉树：
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 注意：本题与力扣 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author: Song Ningning
 * @date: 2020-06-14 15:36
 */
public class Solution1 {

    /**
     * 题目没有限定执行逻辑，他的调用方法是：
     * Codec codec = new Codec();
     * codec.deserialize(codec.serialize(root));
     * 因此只要求能用写的函数序列化和反序列化即可。
     *
     * 考虑几种遍历方式：前序、中序、后序、层序、
     * 如果二叉树的序列化是从根节点开始，那么反序列化的时候读到第一个元素时就可以进行操作，
     * 因此考虑 前序遍历 或者 层序遍历。
     *
     * 注意的是，遇到空节点不能直接返回，需要标注为 null。
     */

    /**
     * 层序遍历
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     * 序列化结果：1,2,3,null,null,4,5,null,null,null,null,
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.append("null,");
            } else {
                res.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }
        // "1,2,3,null,null,4,5,null,null,null,null," 分割后变成
        // ["1" "2" "3" "null" "null" "4" "5" "null" "null" "null" "null"]
        String[] values = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!values[index].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(node.left);
            }
            index++;
            if (!values[index].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }
}
