package node;

public class DHDCL {
    Node dh;
    Node tail;

    public DHDCL() {
        Node newNode = new Node(-99);
        dh = newNode;
        tail = dh;
        dh.next = dh;
        dh.prev = dh;
    }
}
