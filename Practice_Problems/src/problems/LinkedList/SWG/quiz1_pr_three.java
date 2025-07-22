package problems.LinkedList.SWG;

import node.Node;
import utils.DHDCLUtils;
public class quiz1_pr_three {
    public static Node reverseDhdcl(Node dh){
        Node current = dh.next; // Start from the first actual node (dh.next) because dh is the dummy node
        while(current != dh){   // Continue until we reach back to the dummy node
            Node temp = current.next;  // Store the next node of the current node temporarily
            current.next = current.prev;  // Reverse the link direction: make current's next point to its previous node
            current.prev = temp;  // Reverse the link direction: make current's previous point to its original next node (stored in temp)
            current = temp;  // Move to the next node in original order (which is stored in temp before reversal)
        }
        // After reversing all nodes, swap dummy node's next and prev to complete the circular reversal

        Node temp = dh.next; // Store the old dh.next (which was the first node before reversal)
        dh.next = dh.prev;   // dh.next should now point to the last node (which was dh.prev before reversal)
        dh.prev = temp;  // dh.prev should now point to the first node (which we stored earlier in temp)
        return dh; // Return the dummy node (though this isn't always necessary)
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