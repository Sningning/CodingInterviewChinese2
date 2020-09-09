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
public class Solution2 {

    /*
     * 方法一：层序遍历 + 双端队列
     * 前面是设置了一个标志位，来判断当前考虑的是奇数层还是偶数层，其实在打印时，首先是第一层的根节点，然后是偶数层，再是奇数层...
     * 因此，可以将奇数层和偶数层的打印放在一起，先打印奇数层，再打印偶数层。
     * 有一点要注意：打印完奇数层要判断当前的队列是否为空了，如果二叉树总共奇数层，最后一次 while 循环就不需要打印偶数层。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null)
            return new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            // 打印奇数层
            List<Integer> list = new LinkedList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.pollLast();
                list.add(node.val);
                if (node.left != null)
                    deque.addFirst(node.left);
                if (node.right != null)
                    deque.addFirst(node.right);
            }
            res.add(list);
            if (deque.isEmpty())
                break;
            // 打印偶数层
            list = new LinkedList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.pollFirst();
                list.add(node.val);
                if (node.right != null)
                    deque.addLast(node.right);
                if (node.left != null)
                    deque.addLast(node.left);
            }
            res.add(list);
        }
        return res;
    }
}
