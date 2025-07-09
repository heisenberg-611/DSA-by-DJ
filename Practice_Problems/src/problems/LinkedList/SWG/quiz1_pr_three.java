package problems.LinkedList.SWG;

import node.Node;
import utils.DHDCLUtils;
public class quiz1_pr_three {
    public static Node reverseDhdcl(Node dh){
        Node current = dh.next;
        while(current != dh){
            Node temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = temp;
        }
        Node temp = dh.next;
        dh.next = dh.prev;
        dh.prev = temp;
        return dh;
    }
    public static void main(String[] args) {
        DHDCLUtils ll = new DHDCLUtils();
        ll.createList(new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        ll.traverseForward();
        ll.traverseBackward();
        reverseDhdcl(ll.dh);
        ll.traverseForward();
    }
}