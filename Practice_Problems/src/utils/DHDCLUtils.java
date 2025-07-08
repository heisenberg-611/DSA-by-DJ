package utils;

import node.Node;

public class DHDCLUtils {
    Node dh;
    Node tail;
    public DHDCLUtils(){
        Node n = new Node(-99);
        dh = n;
        dh.next = dh;
        dh.prev = dh;
        tail = n;
    }

    public void addNode(Object data) {
        Node n = new Node(data);
        tail.next = n;
        n.prev = tail;
        tail = n;
        tail.next = dh;
        dh.prev = tail;
    }
}