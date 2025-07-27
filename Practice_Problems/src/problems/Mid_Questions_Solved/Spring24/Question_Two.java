package problems.Mid_Questions_Solved.Spring24;
import utils.LinkedListUtilsOOP;
import node.Node;
public class Question_Two {
    public static boolean isSumPossible(Node head, int n) {
    if (head == null || head.next == null) return false;

    Node current = head;
    while (current != null) {
        Node checker = current.next;
        while (checker != null) {
            if ((int)current.data + (int)checker.data == n) {
                return true;
            }
            checker = checker.next;
        }
        current = current.next;
    }
    return false;
}

    public static void main(String[] args) {
        LinkedListUtilsOOP ll = new LinkedListUtilsOOP();
        ll.createList(new Object[] { 1,5,3,2,4});
        System.out.println(isSumPossible(ll.head, 7));
    }
}
