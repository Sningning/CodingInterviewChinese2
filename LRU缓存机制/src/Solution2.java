import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 牛客链接
 * https://www.nowcoder.com/practice/e3769a5f49894d49b871c09cadd13a61?tpId=190&rp=1&ru=%2Fta%2Fjob-code-high-rd&qru=%2Fta%2Fjob-code-high-rd%2Fquestion-ranking
 *
 * @author: Song Ningning
 * @date: 2020-08-26 16:36
 */
public class Solution2 {

    class Node {
        private Integer key;
        private Integer val;
        private Node pred;
        private Node succ;
        public Node(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Node dummyHead = new Node(-1, -1);
    private Node dummyTail = new Node(-1, -1);
    private Map<Integer, Node> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();


    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        capacity = k;
        map = new HashMap<>(k);
        dummyHead.succ = dummyTail;
        dummyTail.pred = dummyHead;

        for (int[] ops : operators) {
            int first = ops[0];
            if (first == 1) {
                put(ops[1], ops[2]);
            } else if (first == 2) {
                get(ops[1]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 如果存在，把当前结点移动到双向链表的头部
     * @param key
     * @return
     */
    private void get(Integer key) {
        if (!map.containsKey(key)) {
            list.add(-1);
            return;
        }
        Node node = map.get(key);
        moveNodeToHead(node);
        list.add(node.val);
    }

    /**
     * 如果哈希表的容量满了，就要删除链表尾部元素，然后在链表头部插入新元素
     * @param key
     * @param val
     */
    private void put(int key, int val) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = val;
            moveNodeToHead(node);
        } else if (map.size() < capacity) {
            Node node = new Node(key, val);
            map.put(key, node);
            addNodeToHead(node);
        } else {
            Node node = new Node(key, val);
            removeTail();
            map.put(key, node);
            addNodeToHead(node);
        }
    }

    private void moveNodeToHead(Node node) {
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        node.succ = dummyHead.succ;
        dummyHead.succ.pred = node;
        dummyHead.succ = node;
        node.pred = dummyHead;
    }

    private void addNodeToHead(Node node) {
        if (node != dummyHead.succ) {
            dummyHead.succ.pred = node;
            node.pred = dummyHead;
            node.succ = dummyHead.succ;
            dummyHead.succ = node;
        }
    }

    private void removeTail() {
        Node temp = dummyTail.pred;
        temp.pred.succ = dummyTail;
        dummyTail.pred = temp.pred;
        temp.pred = null;
        temp.succ = null;
        map.remove(temp.key);
    }
}
