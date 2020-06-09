import java.util.*;

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
 * @Date: 2020-06-09 9:49
 */
public class Solution3 {

    /*
     * 方法二：双栈
     *
     * 输出 1 之后，将 1 的左结点 2 和右结点 3 保存在一个容器中，第二层打印顺序是 3、2，根据输入和输出的顺序可以推断，该容器应该是栈；
     * 第三层打印的时候，还是先打印的 2 的子结点，然后再打印的 3 的子结点，所以存放 2、3 子结点的容器也是栈；
     * 但是注意，第三层打印 2 子结点的时候是先打印的左结点(4)、后打印的右结点(5)，所以压入第二层结点的子结点时，需要先压入右结点，再压入左结点。
     *
     * 总结：用两个栈保存结点；
     * 在遍历奇数层的元素时，每遍历一个，就要向另一个栈中先压入左结点、再压入右结点；
     * 在遍历偶数层的元素时，每遍历一个，就要向另一个栈中先压入右结点、再压入左结点。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null)
            return new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> oddStack = new LinkedList<>();
        Deque<TreeNode> evenStack = new LinkedList<>();
        oddStack.push(root);
        int level = 1;
        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            if ((level & 1) == 1) {
                while (!oddStack.isEmpty()) {
                    TreeNode node = oddStack.pop();
                    list.add(node.val);
                    if (node.left != null) evenStack.push(node.left);
                    if (node.right != null) evenStack.push(node.right);
                }
            } else {
                while (!evenStack.isEmpty()) {
                    TreeNode node = evenStack.pop();
                    list.add(node.val);
                    if (node.right != null) oddStack.push(node.right);
                    if (node.left != null) oddStack.push(node.left);
                }
            }
            level++;
            res.add(list);
        }
        return res;
    }
}
