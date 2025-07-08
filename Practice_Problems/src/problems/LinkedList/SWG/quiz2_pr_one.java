package problems.LinkedList.SWG;

import node.Node;
import utils.LinkedListUtils;
import utils.LinkedListUtilsOOP;
public class quiz2_pr_one {
    public static void main(String[] args) {
        Object[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        LinkedListUtilsOOP list = new LinkedListUtilsOOP();
        list.createList(arr);
        list.display();
        list.reverseNodeInplace();
        list.display();
        Node head = list.reverseNodeOutplace();
        LinkedListUtils.printListinStyle(head);
    }
}
