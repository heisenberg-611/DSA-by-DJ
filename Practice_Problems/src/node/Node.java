package node;

public class Node {
    
    public Object data;
    public Node next;
    public Node prev;

    public Node(Object data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}