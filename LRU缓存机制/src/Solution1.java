import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 * LRUCache cache = new LRUCache( 2 // 缓存容量 );
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得关键字 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得关键字 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 *
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @author: Song Ningning
 * @date: 2020-07-25 10:06
 */
public class Solution1 {

    /**
     * 定义双向链表尾部为最新节点
     */

    // 双向链表内部类
    private static class ListNode {
        private Integer key;
        private Integer value;
        private ListNode prev;
        private ListNode next;
        public ListNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private Map<Integer, ListNode> map;
    private ListNode dummyHead;
    private ListNode dummyTail;

    public Solution1(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.dummyHead = new ListNode(-1, -1);
        this.dummyTail = new ListNode(-1, -1);
        this.dummyHead.next = this.dummyTail;
        this.dummyTail.prev = this.dummyHead;
    }

    /**
     * 如果存在，把当前结点移动到双向链表的尾部
     * @param key
     * @return
     */
    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        // 将其移动到尾部
        moveNodeToTail(node);
        return node.value;
    }

    /**
     * 如果哈希表的容量满了，就要删除链表头部元素，然后在链表尾部插入新元素
     * @param key
     * @param value
     */
    public void put(int key, int value) {

        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.value = value;
            // 将其移动到尾部
            moveNodeToTail(node);
        } else if (map.size() < capacity) {
            // 如果还没满，直接插入双向链表尾部
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            addNodeToTail(node);
        } else {
            // 如果已经满了，需要删除头节点，并将新节点插双向链表尾部
            ListNode node = new ListNode(key, value);
            removeHead();
            map.put(key, node);
            addNodeToTail(node);
        }
    }

    /**
     * 将节点 node 添加到双向链表尾部
     * @param node 待添加的节点
     */
    private void addNodeToTail(ListNode node) {
        if (node != dummyTail.prev) {
            dummyTail.prev.next = node;
            node.prev = dummyTail.prev;
            node.next = dummyTail;
            dummyTail.prev = node;
        }
    }

    /**
     * 将节点 node 移动到双向链表尾部
     * @param node 待移动的节点
     */
    private void moveNodeToTail(ListNode node) {
        // 调整当前节点的前后节点
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // 将当前节点插入链表尾部
        addNodeToTail(node);
    }

    /**
     * 删除双向链表头节点
     */
    private void removeHead() {
        ListNode temp = dummyHead.next;
        dummyHead.next = temp.next;
        temp.next.prev = dummyHead;
        temp.prev = null;
        temp.next = null;
        map.remove(temp.key);
    }

}
