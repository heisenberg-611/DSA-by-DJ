package node;

public class Node {
    
    public Object data;
    public Object key;
    public Node next;
    public Node prev;
    public Node left;
    public Node right;

    // Constructor for linked list (data only)
    public Node(Object data) { // for singly and doubly linked list and trees
        this.data = data;
        this.next = null;
        this.prev = null;
        this.left = null;
        this.right = null;
    }
    // Constructor for linked lists (data + next node)
    public Node(Object data, Node next) { // for singly linked list and stack
        this.data = data;
        this.next = next;
    }

    // Constructor for hash table (key + data)
    public Node(Object key, Object data) { // for hash table
        this.key = key;
        this.data = data;
        this.next = null;
    }
}