/**
 * @author: Song Ningning
 * @date: 2020-06-13 14:52
 */
public class Solution2 {
    /**
     * 使用 O(1) 的额外空间
     * 具体操作见图示
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 克隆源节点
        Node cur = head;
        while (cur != null) {
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        // 给克隆节点的 random 赋值
        cur = head;
        while (cur != null) {
            // 注意：一定要检查 cur.random 是否为空，否则会出现空指针异常
            // 如果 cur.random 为空，那么 cur 的克隆节点的 random 也需要为空
            // 但是初始化克隆节点时，random 默认为空，因此不需要处理
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 拆分
        cur = head;
        Node cloneCur = head.next;
        Node cloneHead = head.next;
        while (cloneCur.next != null) {
            // 修改源链表
            cur.next = cur.next.next;
            cur = cur.next;
            // 修改克隆链表
            cloneCur.next = cloneCur.next.next;
            cloneCur = cloneCur.next;
        }
        // 此时，处理完了克隆链表，但是源链表最后一个节点还指向着克隆链表最后一个节点
        // 应该将源链表最后一个节点的 next 指向 null
        cur.next = null;
        return cloneHead;
    }
}
