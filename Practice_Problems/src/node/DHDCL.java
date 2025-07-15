package node;

public class DHDCL {
    public Node dh;
    public Node tail;

    public DHDCL() {
        Node newNode = new Node(null);
        dh = newNode;
        tail = dh;
        dh.next = dh;
        dh.prev = dh;
    }
}
