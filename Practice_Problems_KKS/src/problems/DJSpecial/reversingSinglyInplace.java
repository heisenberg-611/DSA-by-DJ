package problems.DJSpecial;

import node.Node;
import utils.LinkedListUtilsOOP;
public class reversingSinglyInplace {
    public static Node reverseInplace(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return head;
    }
    public static void main(String[] args) {
        LinkedListUtilsOOP ll = new LinkedListUtilsOOP();
        ll.createList(new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        ll.display();
        ll.reverseNodeInplace();
        ll.display();
    }
}