package leetcode.lee146;

import java.util.HashMap;

public class LRUCache implements Cache{

    private Node head;

    private Node tail;

    private HashMap<Integer,Node> map = new HashMap<>();

    private int capcity;

    public LRUCache() {
        this(16);
    }

    public LRUCache(int capcity) {
        if(capcity < 1){
            throw new IllegalArgumentException("capcity can not less than 1");
        }

        this.capcity = capcity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public void put(int key, int value){

        Node node = map.get(key);
        if (node == null) {
            node = new Node(key,value);
            addToTail(node);

            map.put(key,node);

            if(map.size() > capcity){
                removeLRU();
            }
        }else {
            node.updateVale(value);

            if(node.next!=tail){
                removeNode(node);
                addToTail(node);
            }
        }
    }

    private void removeLRU() {
        Node node = head.next;
        removeNode(node);
        map.remove(node.key);
    }


    private void removeNode(Node node) {
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }

    private void addToTail(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        tail.prev = node;

        node.prev = prev;
        node.next = tail;
    }

    @Override
    public int get(int key){
        Node node = map.get(key);
        if(node!=null){
            if(node.next!=tail){
                removeNode(node);
                addToTail(node);
            }
            return node.value;
        }
        return -1;
    }


    class Node {

        private int key;
        private int value;

        private Node prev;
        private Node next;


        private long lastUseTime;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.lastUseTime = System.currentTimeMillis();
        }

        public void updateVale(int value) {
            this.value = value;
            this.lastUseTime = System.currentTimeMillis();
        }

    }

    public void printLRU(){
        Node p = head.next;
        while (p!=tail){
            System.out.println("key="+p.key+",value="+p.value+",lastUseTime="+p.lastUseTime);
            p = p.next;
        }
    }
}
