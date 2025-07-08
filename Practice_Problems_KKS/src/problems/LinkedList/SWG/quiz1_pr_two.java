package problems.LinkedList.SWG;

import node.Node;
import utils.LinkedListUtilsOOP;
public class quiz1_pr_two {
    public static Node rmConsecutiveDuplicates(Node head){
        Node temp = head;
        while(temp != null){
            if (temp.next != null && temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListUtilsOOP ll = new LinkedListUtilsOOP();
        ll.createList(new Object[] { 1,2,5,5,9,9});
        rmConsecutiveDuplicates(ll.head);
        ll.displayinStyle();
    }
}
