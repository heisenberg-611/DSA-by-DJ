package problems.DJSpecial;

import node.Node;
import utils.LinkedListUtilsOOP;

public class middleElment {
    public static int middleElement(Node head) {
        if (head == null) {
            return -1;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return (int) slow.data;
    }

    public static void main(String[] args) {
        LinkedListUtilsOOP ll = new LinkedListUtilsOOP();
        ll.createList(new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        System.out.println(middleElement(ll.head));
    }
}
