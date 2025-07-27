package problems.Mid_Questions_Solved.Fall24;

import node.Node;
import utils.LinkedListUtilsOOP;
public class Question_Two {
    public static Node reverseAndSwap(Node head, int i) {
    if (head == null || i <= 0) return head;
    Node current = head;
    Node prev = null;
    Node next = null;
    int count = 0;

    while (current != null && count < i) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
        count++;
    }
    Node remainingHead = current;
    if (remainingHead == null) {
        return prev;
    }

    Node temp = remainingHead;
    while (temp.next != null) {
        temp = temp.next;
    }
    temp.next = prev;
    return remainingHead;
}
    public static void main(String[] args) {
        LinkedListUtilsOOP ll = new LinkedListUtilsOOP();
        ll.createList(new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        ll.displayinStyle();
        ll.head = reverseAndSwap(ll.head, 5);
        ll.displayinStyle();
    }
}
