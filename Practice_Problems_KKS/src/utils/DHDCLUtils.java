package utils;

import node.Node;

public class DHDCLUtils {
    Node dh;
    Node tail;
    public DHDCLUtils(){
        Node n = new Node(-99);
        dh = n;
        tail = n;
        dh.next = dh;
        dh.prev = dh;
    }
}