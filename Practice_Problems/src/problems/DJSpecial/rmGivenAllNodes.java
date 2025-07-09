package problems.DJSpecial;

import node.Node;
import utils.LinkedListUtilsOOP;

public class rmGivenAllNodes {

    public static Node rmGivenAllNode(Node head, Integer target) {
        // First remove ALL leading target nodes
        while (head != null && head.data.equals(target)) {
            head = head.next;
        }

        // If list became empty after removal
        if (head == null) {
            return null;
        }

        // Now process the rest of the list
        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.data.equals(target)) {
                // Skip the target node
                current.next = current.next.next;
            } else {
                // Move forward
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListUtilsOOP ll = new LinkedListUtilsOOP();
        ll.createList(new Object[]{7, 1, 7, 7});

        System.out.print("Original list: ");
        ll.displayinStyle();

        Node head = ll.head;

        // Assign the returned head to actually update the list!
        head = rmGivenAllNode(head, 7);
        ll.head = head;

        System.out.print("After removing 7: ");
        ll.displayinStyle();
    }
}
