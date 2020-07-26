import java.util.HashMap;

/**
 * 面试题07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 与力扣 105 题 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @Author: Song Ningning
 * @Date: 2020-05-16 19:23
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // 为了快速定位根节点在 inorder 中位置，使用 map 先存起来
        // 题目中说不含重复元素，所以可以把值作为 key，索引作为 value
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(int[] preorder, int preL, int preR,
                           int[] inorder, int inL, int inR,
                           HashMap<Integer, Integer> map) {

        if (preL > preR || inL > inR) {
            return null;
        }

        int pivot = preorder[preL];
        int pivotIdx = map.get(pivot);
        TreeNode root = new TreeNode(pivot);
        root.left = build(preorder, preL + 1, preL + (pivotIdx - inL),
                inorder, inL, pivotIdx - 1, map);
        root.right = build(preorder, preL + (pivotIdx - inL) + 1, preR,
                inorder, pivotIdx + 1, inR, map);
        return root;
    }
}
