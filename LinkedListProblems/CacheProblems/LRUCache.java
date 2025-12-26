package LinkedListProblems.CacheProblems;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;

    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        moveToFront(node);
        return node.value;
    }


    public void put(int key, int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);
        } else{
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToFront(newNode);

            if(map.size() > capacity){
                Node lru = removeTail();
                map.remove(lru.key);
            }
        }
    }
    //--------- Helper Methods --------

    private void addToFront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToFront(Node node){
        removeNode(node);
        addToFront(node);
    }

    private Node removeTail(){
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }
}
