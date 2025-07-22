package problems.DJSpecial;

import node.Node;
import utils.LinkedListUtilsOOP;
public class reversingSinglyInplace {
    public static Node reverseInplace(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr != null){
            next = curr.next; //Store the next node of current node
            curr.next = prev; //Reversing the link between current and prev
            prev = curr;      //Moving prev pointer to current
            curr = next;      //Moving current pointer to next
        }
        return prev;
    }
    public static void main(String[] args) {
        LinkedListUtilsOOP ll = new LinkedListUtilsOOP();
        ll.createList(new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        ll.display();
        ll.reverseNodeInplace();
        ll.display();
    }
}