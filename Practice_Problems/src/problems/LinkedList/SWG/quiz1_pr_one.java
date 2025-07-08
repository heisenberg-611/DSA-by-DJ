package problems.LinkedList.SWG;

import node.Node;
import utils.LinkedListUtilsOOP;

public class quiz1_pr_one {
    public static double findAverage(Node head) {
        if (head == null) {
            return 0.0;
        }
        if (head.next == null) {
            return -1;
        }
        Node temp = head;
        double sum = 0;
        int count = 0;
        while (temp != null) {
            if (count % 2 != 0) {
                sum += (int)temp.data;
            }
            count++;
            temp = temp.next;
        }
        return sum / (count / 2);
    }

    public static void main(String[] args) {
        LinkedListUtilsOOP ll = new LinkedListUtilsOOP();
        ll.createList(new Object[] {1, 2, 5, 5, 9, 9});
        System.out.println("Average of odd indices: " + findAverage(ll.head)); // Should be (2+5+9)/3 = 5.333...
        
        // Test with single node
        ll.createList(new Object[] {1});
        System.out.println("Single node: " + findAverage(ll.head)); // Should be -1
        
        // Test with empty list
        ll.createList(new Object[] {});
        System.out.println("Empty list: " + findAverage(ll.head)); // Should be 0.0
    }
}