package problems.LinkedList;

import node.Node;
import utils.LinkedListUtilsOOP;
public class kks_ques_one {
    public static Node moveLastToFirst(Node head){
        Node temp = head;
        if (temp == null || temp.next == null) {
            return head;
        }
        while (temp.next.next != null) {
            temp = temp.next;
        }
        Node last = temp.next;
        temp.next = null;
        last.next = head;
        
        return last;
    }
    public static void main(String[] args) {
        LinkedListUtilsOOP ll = new LinkedListUtilsOOP();
        ll.createList(new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        ll.display();
    }
}
