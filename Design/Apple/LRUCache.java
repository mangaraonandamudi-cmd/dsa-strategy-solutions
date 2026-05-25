/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.



Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4


Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.
*/

class ListNode {
    int key;
    int value;
    ListNode prev;
    ListNode next;

    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

}

public class LRUCache {
    int capacity;
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // if key does not exist in the Map, return -1
        if(!map.containsKey(key)) {
            return -1;
        }
        // if exists remove the node and remove from Map
        ListNode node = map.get(key);
        remove(node);
        // add at tail
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        // If map  contains key, return existing Node and delete the existing Node
        if(map.containsKey(key)) {
            ListNode existingNode = map.get(key);
            remove(existingNode);
        }

        // otherwise create new and append at the end
        // Also put the new Node in Map
        ListNode newNode = new ListNode(key, value);
        add(newNode);
        map.put(key, newNode);
          /*ListNode lastNode = tail.prev;
          lastNode.next = tail;
          tail.prev = lastNode;*/

        // After adding if it exceeds capacity remove from head and Map
        if(map.size() > capacity) {
            ListNode nodeToDelete = head.next;
            remove(nodeToDelete);
            map.remove(nodeToDelete.key);
        }
    }

    private void add(ListNode node) {
        ListNode lastNode = tail.prev;
        lastNode.next = node;

        node.prev = lastNode;
        node.next = tail;
        tail.prev = node;
    }

    private void remove(ListNode nodeToRemove) {
        nodeToRemove.prev.next = nodeToRemove.next;
        nodeToRemove.next.prev = nodeToRemove.prev;

    }
}