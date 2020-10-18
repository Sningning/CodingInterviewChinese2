/**
 * @author: Song Ningning
 * @date: 2020-06-15 9:11
 */
public class Solution2 {

    /**
     * 前序遍历
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     * 序列化结果：1,2,null,null,3,4,null,5,null,
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder res = new StringBuilder();
        preOrder(root, res);
        return res.toString();
    }

    private void preOrder(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("null,");
            return;
        }
        builder.append(node.val).append(",");
        preOrder(node.left, builder);
        preOrder(node.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }
        String[] values = data.split(",");
        return deserialize(values);
    }

    /**
     * 此处 index 应该定义为全局变量，因为在 deserialize 递归函数中，index 应该是始终连续的
     * 比如 root.right = deserialize(values) 递归完后，index 为 5，那么在执行 root.right = deserialize(values)
     * 时，index 也必须为 5
     */
    int index = 0;
    private TreeNode deserialize(String[] values) {
        if (values[index].equals("null")) {
            index++;  // 注意：在 return 之前要先更新 index
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[index]));
        index++;
        root.left = deserialize(values);
        root.right = deserialize(values);
        return root;
    }
}
