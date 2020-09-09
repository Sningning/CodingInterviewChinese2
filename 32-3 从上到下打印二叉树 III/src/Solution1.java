import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 例如:
 * 给定二叉树:
 *                  1
 *           /              \
 *         2                3
 *     /      \          /     \
 *    4       5        6        7
 *  /  \    /  \     /  \     /  \
 * 8   9   10  11   12  13   14  15
 *
 * 返回其层次遍历结果：
 * [
 *   [1],
 *   [3,2],
 *   [4,5,6,7]
 *   [15,14,13,12,11,10,9,8]
 * ]
 *
 * 提示：
 * 节点总数 <= 1000
 *
 * @Author: Song Ningning
 * @Date: 2020-06-09 11:06
 */
public class Solution1 {

    /*
     * 方法一：层序遍历 + 双端队列 + 标志位
     *
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null)
            return new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int level = 1;
        while (!deque.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            // 如果是奇数层
            if ((level & 1) == 1) {
                for (int i = deque.size(); i > 0; i--) {
                    // 从队列尾部取出（从右向左依次取出）
                    TreeNode node = deque.pollLast();
                    list.add(node.val);
                    if (node.left != null)
                        // 先向队首加入左节点
                        deque.addFirst(node.left);
                    if (node.right != null)
                        // 再向队首加入右节点
                        deque.addFirst(node.right);
                }
            } else {  // 如果是偶数层
                for (int i = deque.size(); i > 0; i--) {
                    // 从队列首部取出（从左向右依次取出）
                    TreeNode node = deque.pollFirst();
                    list.add(node.val);
                    if (node.right != null)
                        // 先向队尾加入右节点
                        deque.addLast(node.right);
                    if (node.left != null)
                        // 再向队尾加入左节点
                        deque.addLast(node.left);
                }
            }
            level++;
            res.add(list);
        }
        return res;
    }
}
